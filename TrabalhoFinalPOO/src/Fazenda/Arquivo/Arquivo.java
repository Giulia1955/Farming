package Fazenda.Arquivo;

import java.io.*;

import Fazenda.*;
import Fazenda.Informacoes.Dinheiro;
import Fazenda.Informacoes.Inventario;
import Fazenda.Informacoes.Lotes;

import java.util.Scanner;

/**
 * A classe {@code Arquivo} é responsável por operações de salvamento e carregamento do estado do jogo.
 *
 * Ela permite:
 *
 *   Salvar o progresso do jogador em um arquivo.
 *   Carregar um estado de jogo previamente salvo.
 *   Perguntar ao usuário se deseja salvar o jogo antes de sair.
 *
 *
 * Utiliza serialização de objetos para armazenar o estado completo do jogo.
 *
 * @author Giulia, Guilherme e Eduardo
 */
public class Arquivo {

    /**
     * Salva o estado atual do jogo em um arquivo.
     *
     * @param estado  Objeto {@code EstadoJogo} contendo todas as informações necessárias para restaurar o jogo.
     * @param caminho Caminho do arquivo onde o jogo será salvo (exemplo: "fazenda.sav").
     */
    public static void salvarJogo(EstadoJogo estado, String caminho) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(caminho))) {
            oos.writeObject(estado);
            System.out.println("Jogo salvo com sucesso.");
        } catch (IOException e) {
            System.err.println("Erro ao salvar jogo: " + e.getMessage());
        }
    }

    /**
     * Pergunta ao jogador se deseja salvar o jogo antes de encerrar.
     *
     * Se o jogador escolher salvar, o estado atual é armazenado em um arquivo chamado "fazenda.sav".
     *
     * @param inventario Instância atual do inventário do jogador.
     * @param dinheiro   Instância atual de dinheiro do jogador.
     * @param lotes      Instância atual dos lotes da fazenda.
     * @param controle   Controle geral da execução do jogo.
     * @param scanner    Objeto {@code Scanner} usado para ler a resposta do jogador.
     * @param dias       Quantidade de dias jogados até o momento.
     */
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

    /**
     * Carrega um estado de jogo previamente salvo a partir de um arquivo.
     *
     * @param caminho Caminho do arquivo de salvamento (exemplo: "fazenda.sav").
     * @return Um objeto {@code EstadoJogo} com os dados carregados, ou {@code null} se ocorrer um erro.
     *  @exception IOException Se ocorrer um erro ao salvar o jogo
     */
    public static EstadoJogo carregarJogo (String caminho) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(caminho))) {
            return (EstadoJogo) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erro ao carregar jogo: " + e.getMessage());
            return null;
        }
    }
}

