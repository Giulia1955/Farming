package Fazenda.Itens;

import Fazenda.Animais.Animal;

/**
 * Representa a {@code Leite}, que é um tipo de {@link Item} produzido por vacas.
 * Vem dentro de uma garrafa e pode ser vendida pelo jogador.
 *
 * Esta classe define um item com preço fixo e nome padrão.
 *
 * @author Giulia
 * @version 1.0
 */
public class Leite extends Item {
    /**
     * Construtor da classe {@code Leite}.
     * Inicializa uma garra de leite com valor fixo, descrição e nome padrão.
     */
    public Leite(){
        super (3.50, "Garrafa de 2l", "Leite");
    }
}


