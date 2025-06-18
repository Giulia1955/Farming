package Fazenda.Informacoes;

import Fazenda.Itens.Item;

import java.io.Serial;
import java.util.*;
import java.io.Serializable;

/**
 * Representa o inventário da fazenda, responsável por armazenar, gerenciar e vender itens.
 * Permite adicionar, remover, verificar a quantidade, listar o inventário e realizar vendas.
 *
 * @author Giulia, Guilherme e Eduardo
 */
public class Inventario implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Map<Item, Integer> itens;

    /**
     * Construtor que inicializa o inventário como um HashMap vazio.
     */
    public Inventario() {
        itens = new HashMap<>();
    }

    /**
     * Retorna o mapa de itens armazenados no inventário.
     * @return Mapa contendo os itens e suas respectivas quantidades.
     */
    public Map<Item, Integer> getItens() {
        return itens;
    }

    /**
     * Define o mapa de itens do inventário.
     * @param itens Novo mapa de itens a ser definido.
     */
    public void setItens(Map<Item, Integer> itens) {
        this.itens = itens;
    }

    /**
     * Adiciona uma quantidade de um item ao inventário.
     * Se o item já existir, a quantidade é somada à existente.
     * @param item Item a ser adicionado.
     * @param qtd Quantidade a ser adicionada.
     */
    public void adicionar(Item item, int qtd) {
        if (itens.containsKey(item)) {
            int novaQtd = itens.get(item) + qtd;
            itens.put(item, novaQtd);
        } else {
            itens.put(item, qtd);
        }
    }

    /**
     * Remove uma quantidade de um item do inventário.
     * Se a quantidade atingir zero, o item é removido completamente.
     * @param item Item a ser removido.
     * @param qtd Quantidade a ser removida.
     * @return true se a remoção foi bem-sucedida, false se o item não existia no inventário.
     */
    public boolean remover(Item item, int qtd) {
        if(!contem(item)){
            System.out.println("Item não existe no inventario.");
            return false;
        }
        int atual = itens.get(item);
        if(atual == qtd){
            itens.remove(item);
        }else{
            itens.put(item, atual - 1);
        }
        return true;
    }

    /**
     * Verifica se o inventário contém determinado item.
     * @param item Item a ser verificado.
     * @return true se o item estiver presente, false caso contrário.
     */
    public boolean contem(Item item) {
        return itens.containsKey(item);
    }

    /**
     * Retorna a quantidade disponível de um determinado item.
     * @param item Item a ser consultado.
     * @return Quantidade disponível no inventário.
     * @exception NullPointerException se o item não estiver presente no inventário.
     */
    public int quantidadeDisponivel(Item item){
        return(itens.get(item));
    }

    /**
     * Imprime no console todos os itens presentes no inventário com suas quantidades e preços unitários.
     * Caso o inventário esteja vazio, exibe uma mensagem informando.
     */
    public void imprimirInventario () {
        if (itens.isEmpty()) {
            System.out.println("📦 Inventário vazio.");
            return;
        }

        int index = 1;

        for (Map.Entry<Item, Integer> entry : itens.entrySet()) {
            Item item = entry.getKey();
            int quantidade = entry.getValue();
            System.out.printf("%d - %s (x%d) - R$%.2f cada%n", index, item.getNome(), quantidade, item.getPreco());
            index++;
        }
    }

    /**
     * Permite ao jogador vender itens do inventário.
     * Exibe os itens disponíveis, solicita a escolha do usuário e realiza a venda,
     * atualizando o saldo de dinheiro.
     * @param scanner Objeto Scanner para entrada de dados do usuário.
     * @param dinheiro Objeto que representa o dinheiro do jogador.
     * @exception InputMismatchException se o usuário digitar valores inválidos.
     */
    public void vender(Scanner scanner, Dinheiro dinheiro) {
        if (itens.isEmpty()) {
            System.out.println("Seu inventário está vazio. Nada para vender.");
            return;
        }

        System.out.println("Itens disponíveis para venda:");
        imprimirInventario();

        System.out.print("Digite o número do item que deseja vender (ou 0 para cancelar): ");
        int escolha = scanner.nextInt();
        scanner.nextLine();

        List<Item> listaItens = new ArrayList<>();

        for (Map.Entry<Item, Integer> entry : itens.entrySet()) {
            Item item = entry.getKey();
            listaItens.add(item);
        }

        if (escolha <= 0 || escolha > listaItens.size()) {
            System.out.println("Venda cancelada.");
            return;
        }

        Item escolhido = listaItens.get(escolha - 1);

        System.out.print("Quantas unidades deseja vender? ");
        int qtdVenda = scanner.nextInt();
        scanner.nextLine();

        int qtdDisponivel = itens.get(escolhido);
        if (qtdVenda <= 0 || qtdVenda > qtdDisponivel) {
            System.out.println("Quantidade inválida. Venda cancelada.");
            return;
        }

        double totalVenda = escolhido.getPreco() * qtdVenda;
        dinheiro.setValor(dinheiro.getValor() + totalVenda);

        if(remover(escolhido, qtdVenda)){
            System.out.printf("Você vendeu %d unidade(s) de %s por R$%.2f.%n",
                    qtdVenda, escolhido.getNome(), totalVenda);
        }
    }
}
