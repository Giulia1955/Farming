package Fazenda;

import java.io.*;

public class Arquivo {


    public static void salvarJogo(EstadoJogo estado, String caminho) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(caminho))) {
            oos.writeObject(estado);
            System.out.println("Jogo salvo com sucesso.");
        } catch (IOException e) {
            System.err.println("Erro ao salvar jogo: " + e.getMessage());
        }
    }

    public static EstadoJogo carregarJogo(String caminho) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(caminho))) {
            return (EstadoJogo) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erro ao carregar jogo: " + e.getMessage());
            return null;
        }
    }
}

