package Fazenda;
public class Dinheiro {
    private double valor;
    public Dinheiro() {
        valor = 50.0;
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
