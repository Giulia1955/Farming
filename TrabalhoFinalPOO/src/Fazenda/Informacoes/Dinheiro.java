package Fazenda.Informacoes;
import java.io.Serializable;

public class Dinheiro  implements Serializable {
    private static final long serialVersionUID = 1L;

    private double valor;
    public Dinheiro() {
        valor = 500.0;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public boolean temSuficiente(double qtd){
        return((this.getValor() - qtd) >= 0);
    }
}
