package Fazenda.PlantaEAnimal.Plantas;

import Fazenda.Informacoes.Inventario;
import Fazenda.Informacoes.Lotes;

import java.util.Scanner;

public class Plantar {
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
}
