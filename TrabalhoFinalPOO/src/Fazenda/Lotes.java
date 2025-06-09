package Fazenda;

/**
 * A classe {@code Lotes} representa um lote com uma quantidade disponível,
 * que pode ser utilizada para realizar plantios de plantas ou guardar um animal.
 *
 * Inicialmente, a quantidade disponível é definida como 30 unidades,
 * podendo ser consultada ou alterada através dos métodos {@code getQuantidadeDisponivel}
 * e {@code setQuantidadeDisponivel}.
 *
 * @author Guilherme
 * @version 1.0
 */
public class Lotes {

    /**
     * Quantidade disponível no lote.
     */
    private int quantidadeDisponivel;

    /**
     * Construtor padrão que inicializa a quantidade disponível com o valor 30.
     */
    public Lotes() {
        quantidadeDisponivel = 30;
    }

    /**
     * Retorna a quantidade disponível no lote.
     *
     * @return a quantidade atual disponível
     */
    public int getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    /**
     * Define a quantidade disponível no lote.
     *
     * @param quantidadeDisponivel o novo valor da quantidade disponível
     * @throws IllegalArgumentException se {@code quantidadeDisponivel} for negativo
     */
    public void setQuantidadeDisponivel(int quantidadeDisponivel) {
        if (quantidadeDisponivel < 0) {
            throw new IllegalArgumentException("Quantidade não pode ser negativa.");
        }
        this.quantidadeDisponivel = quantidadeDisponivel;
    }
}
