package Fazenda.Itens;

import java.io.Serializable;

public abstract class Item implements Serializable {
    private double preco;
    private String descricao, nome;

    public Item(double preco, String descricao, String nome) {
        this.preco = preco;
        this.descricao = descricao;
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Item other = (Item) obj;
        return this.nome.equals(other.nome);
    }

    @Override
    public int hashCode() {
        return nome.hashCode();
    }
}

