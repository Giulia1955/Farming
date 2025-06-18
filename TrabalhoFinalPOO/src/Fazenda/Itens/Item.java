package Fazenda.Itens;

import java.io.Serializable;

/**
 * Classe abstrata que representa um item genérico da fazenda.
 * Cada item possui um preço, uma descrição e um nome.
 * Implementa Serializable para permitir a serialização dos objetos.
 * @author Giulia, Guilherme e Eduardo
 */
public abstract class Item implements Serializable {
    private static final long serialVersionUID = 1L;
    private double preco;
    private String descricao, nome;

    /**
     * Constrói um item com preço, descrição e nome especificados.
     *
     * @param preco valor do preço do item
     * @param descricao texto que descreve o item
     * @param nome nome do item, utilizado para identificação
     */
    public Item(double preco, String descricao, String nome) {
        this.preco = preco;
        this.descricao = descricao;
        this.nome = nome;
    }

    /**
     * Retorna o preço do item.
     *
     * @return preço do item
     */
    public double getPreco() {
        return preco;
    }

    /**
     * Define o preço do item.
     *
     * @param preco novo preço a ser definido
     */
    public void setPreco(double preco) {
        this.preco = preco;
    }

    /**
     * Retorna o nome do item.
     *
     * @return nome do item
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do item.
     *
     * @param nome novo nome a ser definido
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna a descrição do item.
     *
     * @return descrição do item
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Define a descrição do item.
     *
     * @param descricao nova descrição a ser definida
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Verifica se este item é igual a outro objeto.
     * A comparação é feita com base no nome do item.
     *
     * @param obj objeto a ser comparado
     * @return true se os nomes forem iguais, false caso contrário
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Item other = (Item) obj;
        return this.nome.equals(other.nome);
    }

    /**
     * Retorna o código hash baseado no nome do item.
     *
     * @return código hash do item
     */
    @Override
    public int hashCode() {
        return nome.hashCode();
    }
}

