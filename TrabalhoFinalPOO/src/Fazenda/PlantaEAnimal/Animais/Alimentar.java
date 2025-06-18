package Fazenda.PlantaEAnimal.Animais;

import Fazenda.Informacoes.Inventario;
import Fazenda.Informacoes.Lotes;
import java.util.Scanner;

public class Alimentar {
    public void alimentarAnimais(Scanner scanner, Inventario inventario, Lotes lotes) {
        while (true) {
            System.out.println("\nQual animal você deseja alimentar?");
            System.out.println("1 - Galinha");
            System.out.println("2 - Ovelha");
            System.out.println("3 - Vaca");
            System.out.println("0 - Voltar");

            System.out.print("Escolha: ");
            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1 -> new Galinha().alimentar(inventario, lotes);
                case 2 -> new Ovelha().alimentar(inventario, lotes);
                case 3 -> new Vaca().alimentar(inventario, lotes);
                case 0 -> {
                    return;
                }
                default -> System.out.println("Opção inválida.");
            }
        }
    }
}
