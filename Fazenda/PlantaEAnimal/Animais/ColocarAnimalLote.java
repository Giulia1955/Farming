package Fazenda.PlantaEAnimal.Animais;

import Fazenda.Informacoes.Inventario;
import Fazenda.Informacoes.Lotes;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ColocarAnimalLote {
    public void colocarAnimalLote(Scanner scanner, Inventario inventario, Lotes lotes){
        System.out.println("Qual animal deseja colocar?");
        System.out.println("1 - 🐔 Galinha");
        System.out.println("2 - 🐄 Vaca");
        System.out.println("3 - 🐑 Ovelha");
        int opcao;
        try {
            System.out.print("Opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // limpa o '\n'
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida.");
            scanner.nextLine();
            return;
        }
        switch (opcao) {
            case 1 -> new Galinha().colocar(inventario, lotes);
            case 2 -> new Vaca().colocar(inventario, lotes);
            case 3 -> new Ovelha().colocar(inventario, lotes);
            default -> System.out.println("Opção inválida.");
        }
    }
}
