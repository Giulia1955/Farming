package Fazenda;

import Fazenda.Informacoes.Dinheiro;
import Fazenda.Informacoes.Inventario;
import Fazenda.Informacoes.Lotes;
import Fazenda.PlantaEAnimal.Animais.Alimentar;
import Fazenda.PlantaEAnimal.Animais.Coletar;
import Fazenda.PlantaEAnimal.Animais.ColocarAnimalLote;
import Fazenda.PlantaEAnimal.Plantas.Colher;
import Fazenda.PlantaEAnimal.Plantas.Plantar;
import Fazenda.PlantaEAnimal.Plantas.Regar;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Escolhas {
    public void exibirEscolhas(Scanner scanner, Loja loja, Lotes lotes, Inventario inventario, Dinheiro dinheiro) {
        String borda = "═".repeat(45);
        System.out.println();
        System.out.println("╔" + borda + "╗");
        System.out.printf("║ %-43s ║%n", "📋 ESCOLHA UMA AÇÃO:");
        System.out.println("╠" + borda + "╣");

        String[] opcoes = {
                "1 - 🛒 Comprar itens na Loja",
                "2 - 🌱 Plantar",
                "3 - 💧 Regar as plantas",
                "4 - 🐄 Colocar animal no lote",
                "5 - 🍽️ Alimentar animal",
                "6 - 🧺 Colher tudo (plantas)",
                "7 - 🥚 Coletar tudo (animais)",
                "8 - 🎒 Visualizar inventário",
                "9 - 🏡 Visualizar fazenda",
                "10 - 💰 Vender itens",
                "0 - 🌅 Próximo dia"
        };

        for (String opcao : opcoes) {
            System.out.printf("║ %-43s ║%n", opcao);
        }

        System.out.println("╚" + borda + "╝");

        int escolha;
        try {
            System.out.print("Digite o número da opção desejada: ");
            escolha = scanner.nextInt();
            scanner.nextLine(); // consome o '\n' deixado pelo nextInt
        } catch (InputMismatchException e) {
            System.out.println("❌ Entrada inválida. Digite um número.");
            scanner.nextLine(); // limpa entrada inválida
            return;
        }
        tratarEscolha(escolha, scanner, loja, lotes, inventario, dinheiro);
    }

    public void tratarEscolha(int escolha, Scanner scanner, Loja loja, Lotes lotes, Inventario inventario, Dinheiro dinheiro) {
        ColocarAnimalLote colocar = new ColocarAnimalLote();
        Colher colher = new Colher();
        Coletar coletar = new Coletar();
        Plantar plantar = new Plantar();
        Regar regar = new Regar();
        Alimentar alimentar = new Alimentar();
        Controle controle = new Controle();
        switch (escolha){
            case 1:
                loja.imprimirLoja();
                loja.abrirLoja(scanner, loja, dinheiro, inventario);
                break;
            case 2:
                plantar.plantarTudo(scanner,inventario,lotes);
                break;
            case 3:
                regar.regarTudo(lotes);
                break;
            case 4:
                colocar.colocarAnimalLote(scanner,inventario,lotes);
                break;
            case 5:
                alimentar.alimentarAnimais(inventario,lotes);
                break;
            case 6:
                colher.colherTudo(inventario, lotes);
                break;
            case 7:
                coletar.coletarTudo(inventario,lotes);
                break;
            case 8:
                inventario.imprimirInventario();
                break;
            case 9:
                lotes.imprimirLotes(lotes);
                break;
            case 10:
                inventario.vender(scanner,dinheiro);
                break;
            case 0:
                controle.setPulouDia(true);
                break;
        }
    }
}
