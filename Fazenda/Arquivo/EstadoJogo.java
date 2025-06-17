package Fazenda.Arquivo;

import Fazenda.Informacoes.Dinheiro;
import Fazenda.Informacoes.Inventario;
import Fazenda.Informacoes.Lotes;

import java.io.Serializable;

public class EstadoJogo implements Serializable {
    private static final long serialVersionUID = 1L;

    private Inventario inventario;
    private Dinheiro dinheiro;
    private Lotes lotes;
    private int dias;

    public EstadoJogo(Inventario inventario, Dinheiro dinheiro, Lotes lotes, int dias) {
        this.inventario = inventario;
        this.dinheiro = dinheiro;
        this.lotes = lotes;
        this.dias = dias;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public Dinheiro getDinheiro() {
        return dinheiro;
    }

    public Lotes getLotes() {
        return lotes;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    public void setDinheiro(Dinheiro dinheiro) {
        this.dinheiro = dinheiro;
    }

    public void setLotes(Lotes lotes) {
        this.lotes = lotes;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public int getDias() {
        return dias;
    }
}

