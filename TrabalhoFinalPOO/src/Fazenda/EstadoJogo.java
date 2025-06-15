package Fazenda;

import java.io.Serializable;

public class EstadoJogo implements Serializable {
    private static final long serialVersionUID = 1L;

    private Inventario inventario;
    private Dinheiro dinheiro;
    private Lotes lotes;

    public EstadoJogo(Inventario inventario, Dinheiro dinheiro, Lotes lotes) {
        this.inventario = inventario;
        this.dinheiro = dinheiro;
        this.lotes = lotes;
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
}

