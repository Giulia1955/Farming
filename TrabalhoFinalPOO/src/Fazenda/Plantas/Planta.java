package Fazenda.Plantas;

import Fazenda.Itens.Item;
import Fazenda.Inventario;
import Fazenda.Lotes;
import java.io.Serializable;

public abstract class Planta {
    private boolean sede, estado;
    private Item itemProduzido;
    private String nome;
    private int QuantidadeProducao, diasParaProduzir;

    public Planta(boolean estado, boolean sede, Item itemProduzido, String nome, int QuantidadeProducao, int diasParaProduzir) {
        this.itemProduzido = itemProduzido;
        this.sede = false;
        this.estado = false;
        this.nome = nome;
        this.QuantidadeProducao = QuantidadeProducao;
        this.diasParaProduzir = diasParaProduzir;
    }

    public int getDiasParaProduzir() {
        return diasParaProduzir;
    }

    public void setDiasParaProduzir(int diasParaProduzir) {
        this.diasParaProduzir = diasParaProduzir;
    }

    public boolean isSede() {
        return sede;
    }

    public void setSede(boolean sede) {
        this.sede = sede;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Item getItemProduzido() {
        return itemProduzido;
    }

    public void setItemProduzido(Item itemProduzido) {
        this.itemProduzido = itemProduzido;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public int getQuantidadeProducao() {
        return QuantidadeProducao;
    }

    public void setQuantidadeProducao(int quantidadeProducao) {
        QuantidadeProducao = quantidadeProducao;
    }

    public void Regar() {
        if (isSede()) {
            this.sede = false;
        }
    }

    public abstract void plantar(Lotes lotes, Inventario inventario);
}
