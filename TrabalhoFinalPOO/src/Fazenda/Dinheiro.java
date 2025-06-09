package Fazenda;

/**
 * A classe {@code Dinheiro} representa o valor monetário disponível na fazenda.
 * Utilizada para transações de compra e venda de produtos ou eventos aleatórios.
 *
 * O valor inicial é de R$ 50,00.
 *
 * @author SeuNome
 * @version 1.0
 */
public class Dinheiro {
    /**
     * Valor em dinheiro disponível.
     */
    private double valor;

    /**
     * Construtor padrão que inicializa o valor com R$ 50,00.
     */
    public Dinheiro() {
        valor = 50.0;
    }

    /**
     * Retorna o valor atual de dinheiro disponível.
     *
     * @return o valor atual
     */
    public double getValor() {
        return valor;
    }

    /**
     * Define um novo valor de dinheiro disponível.
     *
     * @param valor o novo valor
     */
    public void setValor(double valor) {
        this.valor = valor;
    }
}
