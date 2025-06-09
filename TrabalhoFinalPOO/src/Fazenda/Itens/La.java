package Fazenda.Itens;

import Fazenda.Animais.Animal;

/**
 * Representa a {@code La}, que é um tipo de {@link Item} produzido por ovelhas.
 * Já vem em forma de novelo e pode ser vendida pelo jogador.
 *
 * Esta classe define um item com preço fixo e nome padrão.
 *
 * @author Giulia
 * @version 1.0
 */
public class La extends Item {

    /**
     * Construtor da classe {@code La}.
     * Inicializa uma lã com valor fixo, descrição e nome padrão.
     */
    public La() {
        super(10, "Já em forma de novelo", "Lã");
    }
}
