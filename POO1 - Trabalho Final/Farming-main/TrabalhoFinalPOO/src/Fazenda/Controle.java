package Fazenda;

import java.util.*;
import java.util.Scanner;
import Fazenda.Animais.*;
import Fazenda.EventoRandomico;
import Fazenda.Inventario.*;
import Fazenda.Plantas.*;


public class Controle {
    int dias;
    boolean jogoAcontecendo, pulouDia;
    EventoRandomico evento = new EventoRandomico();

    public Controle(){
        jogoAcontecendo = true;
        pulouDia = false;
        dias = 0;
    }

    public boolean isJogoAcontecendo() { return jogoAcontecendo; }

    public void setJogoAcontecendo(boolean jogoAcontecendo) {
        this.jogoAcontecendo = jogoAcontecendo;
    }

    public boolean isPulouDia() {
        return pulouDia;
    }

    public void setPulouDia(boolean pulouDia) {
        this.pulouDia = pulouDia;
    }

    public void iniciar(){
        Inventario inventario = new Inventario();
        Lotes lotes = new Lotes();
        Scanner scanner = new Scanner(System.in);
        Loja loja = new Loja();
        Dinheiro dinheiro = new Dinheiro();
        Controle controle = new Controle();
        EstadoJogo estado = new EstadoJogo(inventario,dinheiro,lotes);

        System.out.print("Deseja carregar o jogo salvo? (s/n): ");
        String resposta = scanner.nextLine();
        if (resposta.equalsIgnoreCase("s")) {
            estado = Arquivo.carregarJogo("fazenda.sav");
            if (estado != null) {
                inventario = estado.getInventario();
                dinheiro = estado.getDinheiro();
                lotes = estado.getLotes();
                System.out.println("Jogo carregado com sucesso.");
            } else {
                System.out.println("Falha ao carregar o jogo. Iniciando novo jogo");
                System.out.println("\"Em uma bela manhã de domingo, seu tio lhe envia uma carta dizendo que quer " +
                        "se aposentar de seus cuidos na fazenda, e quer deixá-la sob seus cuidados, você estará " +
                        "disposto a sair do barulho e movimento da cidade para ir até a pacata BusFarm, longe de tudo " +
                        "para  inciar uma nova jornada?\n" +
                        "\n" +
                        "Crie animais, os alimente, expanda suas lavouras, irrigue as plantas e venda na feira local," +
                        " seja bem-vindo a uma vida nova!\"");
            }
        }

        while(controle.isJogoAcontecendo()){
            controle.atualizarDados(lotes, loja,dias);
            controle.exibirResumoDiario(inventario, lotes, loja, dinheiro);
            while(!controle.isPulouDia()){
                controle.exibirEscolhas(scanner, loja, lotes, inventario, dinheiro);
            }
            Arquivo arquivo = new Arquivo();
            arquivo.perguntarSalvar(inventario,dinheiro,lotes,controle,scanner);
            controle.setJogoAcontecendo(false);
        }
        scanner.close();
    }

    public void atualizarDados(Lotes lotes, Loja loja, int dias){
        loja.Inicializar();
        setPulouDia(false);
        reduzirVidaeDiasdeProd(lotes);
        matar(lotes,TipoLote.GALINHA);
        matar(lotes,TipoLote.VACA);
        matar(lotes,TipoLote.OVELHA);
        dias++;
    }

    public void exibirResumoDiario(Inventario inventario, Lotes lotes, Loja loja, Dinheiro dinheiro){
        System.out.println("DIA " + dias);
        System.out.println("Dinheiro R$:" + dinheiro.getValor());
        System.out.println();
        System.out.println("Inventario: " );
        inventario.imprimirInventario();
        System.out.println();
        System.out.println("Lotes: " );
        lotes.imprimir(lotes);
    }

    public void exibirEscolhas(Scanner scanner, Loja loja, Lotes lotes, Inventario inventario, Dinheiro dinheiro){
        System.out.println("Escolha uma ação:");
        System.out.println("1 - Comprar itens na Loja");
        System.out.println("2 - Plantar");
        System.out.println("3 - Regar as plantas");
        System.out.println("4 - Colocar animal no lote");
        System.out.println("5 - Alimentar animal");
        System.out.println("6 - Coletar tudo");
        System.out.println("7 - Visualizar inventario");
        System.out.println("8 - Visualizar fazenda");
        System.out.println("9 - Proximo dia");


        int escolha;
        try {
            System.out.print("Opção: ");
            escolha = scanner.nextInt();
            scanner.nextLine(); // consome o '\n' deixado pelo nextInt
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Digite um número.");
            scanner.nextLine(); // limpa entrada inválida
            return;
        }
        tratarEscolha(escolha, scanner, loja, lotes, inventario, dinheiro);
    }

    public void tratarEscolha(int escolha, Scanner scanner, Loja loja, Lotes lotes, Inventario inventario, Dinheiro dinheiro) {
        switch (escolha){
            case 1:
                loja.imprimirLoja();
                break;
            case 2:
                plantarTudo(scanner,inventario,lotes);
                break;
            case 3:
                regarTudo(lotes);
                break;
            case 4:

                break;
            case 5:
                alimentarAnimais(inventario,lotes);
                break;
            case 6:
                colherTudo(inventario, lotes);
                break;
            case 7:
                inventario.imprimirInventario();
                break;
            case 8:
                lotes.imprimir(lotes);
                break;
            case 9:
                setPulouDia(true);
                break;
        }
    }

    public void reduzirVidaAnimal (Animal animal){
        animal.setVida(animal.getVida() - 1);
    }

    public void reduzirDiasdeProdPlanta (Planta planta){
        planta.setDiasParaProduzir(planta.getDiasParaProduzir() - 1);
    }

    public void reduzirVidaeDiasdeProd(Lotes lotes) {
        try {
            for (ArrayList<Ativo> lote : lotes.getLotes()) {
                for (Ativo ativo : lote) {
                    if (ativo instanceof Animal animal) {
                        reduzirVidaAnimal(animal);
                    }
                    if (ativo instanceof Planta planta){
                        reduzirDiasdeProdPlanta(planta);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int matar(Lotes lotes, TipoLote tipoLote) {
        int contador = 0;
        ArrayList<Ativo>[] arrayLotes = lotes.getLotes();

        for (ArrayList<Ativo> arrayTipo : arrayLotes) {
            Iterator<Ativo> iterator = arrayTipo.iterator();
            while (iterator.hasNext()) {
                Ativo ativo = iterator.next();
                if (ativo instanceof Animal animal && animal.getVida() == 0) {
                    iterator.remove();
                    contador++;
                }
            }
        }
        return contador; //bizzi isso aqui retorna a quantidade de animais que morreram, use pra informar no metodo do resumo.
    }

    public void colherTudo(Inventario inventario, Lotes lotes) {
        ArrayList<Ativo>[] todosLotes = lotes.getLotes();
        int totalColhido = 0;

        for (ArrayList<Ativo> lote : todosLotes) {
            Iterator<Ativo> iterator = lote.iterator();
            while (iterator.hasNext()) {
                Ativo ativo = iterator.next();

                if (ativo instanceof Planta planta && planta.isEstado()) {
                    inventario.adicionar(planta.getItemProduzido(), planta.getQuantidadeProducao());
                    System.out.println(planta.getNome() + " colhido com sucesso! Produziu " + planta.getQuantidadeProducao() + " unidades.");
                    iterator.remove();
                    totalColhido++;
                }
            }
        }

        if (totalColhido == 0) {
            System.out.println("Nenhuma planta estava pronta para colheita.");
        } else {
            System.out.println("Total de plantas colhidas: " + totalColhido);
        }
    }

    public void plantarTudo(Scanner scanner, Inventario inventario, Lotes lotes) {
        while (true) {
            System.out.println("\n=== Plantar ===");
            System.out.println("Escolha o que plantar:");
            System.out.println("1 - Milho");
            System.out.println("2 - Soja");
            System.out.println("3 - Trigo");
            System.out.println("4 - Voltar");

            System.out.print("Opção: ");
            int opcao;

            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um número.");
                continue;
            }

            Planta planta = null;
            switch (opcao) {
                case 1:
                    planta = new Milho();
                    break;
                case 2:
                    planta = new Soja();
                    break;
                case 3:
                    planta = new Trigo();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Opção inválida.");
                    continue;
            }

            planta.plantar(lotes, inventario);

            if (lotes.estaCheio()) {
                System.out.println("Todos os lotes estão cheios. Voltando ao menu.");
                return;
            }

            System.out.print("Deseja plantar mais? (s/n): ");
            String resposta = scanner.nextLine();
            if (!resposta.equalsIgnoreCase("s")) {
                break;
            }
        }
    }

    public void regarTudo(Lotes lotes) {
        ArrayList<Ativo>[] todosLotes = lotes.getLotes();
        int totalRegadas = 0;

        for (ArrayList<Ativo> lote : todosLotes) {
            for (Ativo ativo : lote) {
                if (ativo instanceof Planta planta) {
                    if (!planta.isEstado()) { // Se ainda não está pronta para colheita
                        planta.setDiasParaProduzir(planta.getDiasParaProduzir() - 1);
                        System.out.println(planta.getNome() + " regada. Dias restantes: " + planta.getDiasParaProduzir());
                        totalRegadas++;
                    }
                }
            }
        }

        if (totalRegadas == 0) {
            System.out.println("Nenhuma planta para regar.");
        } else {
            System.out.println("Total de plantas regadas: " + totalRegadas);
        }
    }
    public void alimentarAnimais(Inventario inventario, Lotes lotes) {
        System.out.println("Alimentando todos os animais famintos...");

        Galinha galinha = new Galinha();
        Ovelha ovelha = new Ovelha();
        Vaca vaca = new Vaca();

        galinha.alimentar(inventario, lotes);
        ovelha.alimentar(inventario, lotes);
        vaca.alimentar(inventario, lotes);
    }
}
