package Fazenda.Itens;

import Fazenda.Animais.Animal;
/**
 * Representa a {@code Ovo}, que é um tipo de {@link Item} produzido por galinhas.
 * Vem como uma única unidade de ovo e pode ser vendida pelo jogador.
 *
 * Esta classe define um item com preço fixo e nome padrão.
 *
 * @author Giulia
 * @version 1.0
 */

public class Ovo extends Item {
    public Ovo(){
        /**
         * Construtor da classe {@code Ovo}.
         * Inicializa um ovo com valor fixo, descrição e nome padrão.
         */
        super (1, "uma unidade de um único ovo", "Ovo");
    }
}
