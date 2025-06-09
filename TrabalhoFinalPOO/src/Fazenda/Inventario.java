package Fazenda;

import Fazenda.Itens.Item;
import java.util.ArrayList;

/**
 * A classe {@code Inventario} representa o inventário de itens da fazenda.
 * Permite adicionar, remover e verificar a presença de itens, bem como obter a lista completa.
 *
 * É utilizado para controlar sementes, produtos colhidos e outros objetos manipuláveis.
 *
 * @author SeuNome
 * @version 1.0
 */
public class Inventario {
    /**
     * Lista de itens presentes no inventário.
     */
    private ArrayList<Item> Itens;

    /**
     * Construtor padrão que inicializa o inventário vazio.
     */
    public Inventario() {
        Itens = new ArrayList<>();
    }

    /**
     * Adiciona um item ao inventário.
     *
     * @param item o item a ser adicionado
     */
    public void adicionar(Item item) {
        Itens.add(item);
    }

    /**
     * Remove um item do inventário, se presente.
     *
     * @param item o item a ser removido
     * @return {@code true} se o item foi removido, {@code false} caso contrário
     */
    public boolean remover(Item item) {
        return Itens.remove(item);
    }

    /**
     * Verifica se um item está presente no inventário.
     *
     * @param item o item a ser verificado
     * @return {@code true} se o item estiver presente, {@code false} caso contrário
     */
    public boolean contem(Item item) {
        return Itens.contains(item);
    }

    /**
     * Retorna a lista de itens do inventário.
     *
     * @return a lista de itens
     */
    public ArrayList<Item> getItens() {
        return Itens;
    }
}
