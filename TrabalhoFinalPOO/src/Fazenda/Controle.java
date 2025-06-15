package Fazenda;

import java.util.*;
import java.util.Scanner;
import Fazenda.Animais.*;
import Fazenda.EventoRandomico;
import Fazenda.Inventario.*;
import Fazenda.Plantas.*;


public class Controle {
    boolean jogoAcontecendo, pulouDia;
    EventoRandomico evento = new EventoRandomico();

    public Controle(){
        jogoAcontecendo = true;
        pulouDia = false;
    }

    public void ChamaMetodo(boolean jogoAcontecendo, boolean puloudia, Lotes lotes, Loja loja, Inventario inventario, Scanner scanner, Animal animal, Dinheiro dinheiro){
        isJogoAcontecendo();
        isPulouDia();
        //atualizarDados(lotes, loja);
        exibirResumoDiario(inventario, lotes, loja, dinheiro);
        exibirEscolhas();
        tratarEscolha(scanner, inventario, lotes, loja);
        reduzirVidaAnimal(animal);
        reduzirVidaDeTodosAnimais(lotes);
        evento.executarEvento(dinheiro, inventario);
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

    /*public void atualizarDados(Lotes lotes, Loja loja){
        loja.Inicializar();
    }*/

    public void exibirResumoDiario(Inventario inventario, Lotes lotes, Loja loja, Dinheiro dinheiro){
        System.out.println("Dinheiro R$:" + dinheiro.getValor());
        System.out.println();
        System.out.println("Inventario: " );
        inventario.imprimirInventario();
        System.out.println();
        System.out.println("Lotes: " );
        lotes.imprimirTodosLotes(lotes);
    }

    public void exibirEscolhas(){
        switch ()

    }

    public void tratarEscolha(Scanner scanner, Inventario inventario, Lotes lotes, Loja loja) {

    }

    public void reduzirVidaAnimal (Animal animal){
        animal.setVida(animal.getVida() - 1);
    }

    public void reduzirDiasdeProdPlanta (Planta planta){
        planta.setDiasParaProduzir(planta.getDiasParaProduzir() - 1);
    }

    public void reduzirVidaDeTodosAnimais(Lotes lotes) {
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

    public void perguntarSalvar(Scanner scanner, Inventario inventario, Dinheiro dinheiro, Lotes lotes) {
        System.out.print("Deseja salvar o jogo antes de sair? (s/n): ");
        String resposta = scanner.nextLine();
        if (resposta.equalsIgnoreCase("s")) {
            EstadoJogo estado = new EstadoJogo(inventario, dinheiro, lotes);
            Arquivo.salvarJogo(estado, "fazenda.sav");
        } else {
            System.out.println("Jogo não salvo.");
        }
    }
    public EstadoJogo iniciarOuCarregarJogo(Scanner scanner) {
        System.out.print("Deseja carregar jogo salvo? (s/n): ");
        String resposta = scanner.nextLine();

        if (resposta.equalsIgnoreCase("s")) {
            EstadoJogo estado = Arquivo.carregarJogo("fazenda.sav");
            if (estado != null) {
                System.out.println("Jogo carregado com sucesso!");
                return estado;
            } else {
                System.out.println("Nenhum jogo salvo encontrado. Iniciando novo jogo...");
            }
        }

        // Novo jogo se não carregar
        Inventario inventario = new Inventario();
        Lotes lotes = new Lotes();
        Dinheiro dinheiro = new Dinheiro();
        return new EstadoJogo(inventario, dinheiro, lotes);
    }
}
