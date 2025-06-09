package Fazenda;

import Fazenda.Inventario;

/**
 * Interface que define operações básicas de um produto comercializável.
 * Produtos podem ser comprados e vendidos com base em valor monetário e inventário.
 *
 * Implementada por classes de itens/plantas que podem ser transacionados.
 *
 * @author SeuNome
 * @version 1.0
 */
public interface Produto {

    /**
     * Compra o produto, descontando o valor e adicionando ao inventário.
     *
     * @param dinheiro o objeto que representa o dinheiro do jogador
     * @param inventario o inventário do jogador
     */
    void comprar(Dinheiro dinheiro, Inventario inventario);

    /**
     * Vende o produto, aumentando o valor em dinheiro e removendo do inventário.
     *
     * @param dinheiro o objeto que representa o dinheiro do jogador
     * @param inventario o inventário do jogador
     */
    void vender(Dinheiro dinheiro, Inventario inventario);
}
