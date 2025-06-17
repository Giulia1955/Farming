package Fazenda.Arquivo;

import java.io.*;

import Fazenda.*;
import Fazenda.Informacoes.Dinheiro;
import Fazenda.Informacoes.Inventario;
import Fazenda.Informacoes.Lotes;

import java.util.Scanner;

public class Arquivo {

    public static void salvarJogo(EstadoJogo estado, String caminho) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(caminho))) {
            oos.writeObject(estado);
            System.out.println("Jogo salvo com sucesso.");
        } catch (IOException e) {
            System.err.println("Erro ao salvar jogo: " + e.getMessage());
        }
    }

    public void perguntarSalvar(Inventario inventario, Dinheiro dinheiro, Lotes lotes, Controle controle, Scanner scanner, int dias) {
        System.out.print("Deseja salvar o jogo e sair? (s/n): ");
        String resposta = scanner.nextLine();

        if (resposta.equalsIgnoreCase("s")) {
            EstadoJogo estado = new EstadoJogo(inventario, dinheiro, lotes, dias);
            Arquivo.salvarJogo(estado, "fazenda.sav");
            controle.setJogoAcontecendo(false);
        } else {
            System.out.println("Jogo não salvo.");
        }
    }


    public static EstadoJogo carregarJogo (String caminho) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(caminho))) {
            return (EstadoJogo) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erro ao carregar jogo: " + e.getMessage());
            return null;
        }
    }
}

