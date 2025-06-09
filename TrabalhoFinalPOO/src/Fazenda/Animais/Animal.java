package Fazenda.Animais;

import Fazenda.Itens.Item;
import java.util.ArrayList;
import Fazenda.Inventario;

/**
 * Classe abstrata que representa um animal da fazenda.
 * Cada animal possui um item que pode produzir, uma comida específica, um estado de fome,
 * uma quantidade de vida e um nome identificador.
 *
 * Os animais podem ser alimentados usando itens disponíveis no {@link Inventario}.
 * A classe é base para animais concretos como {@link Galinha}, {@link Vaca} e {@link Ovelha}.
 *
 * @author Giulia
 * @version 1.0
 */
public abstract class Animal {
    private double preco;
    private Item itemProduzido, comida;
    private boolean fome;
    private int vida;
    private String nome;

    /**
     * Construtor da classe Animal.
     *
     * @param nome o nome do animal
     * @param preco o preço de aquisição do animal
     * @param itemProduzido o {@link Item} que o animal pode produzir
     * @param fome estado de fome inicial do animal
     * @param vida quantidade de vida do animal
     * @param comida o {@link Item} necessário para alimentar o animal
     */
    public Animal(String nome, double preco, Item itemProduzido, boolean fome, int vida, Item comida){
        this.nome = nome;
        this.preco = preco;
        this.itemProduzido = itemProduzido;
        this.fome = fome;
        this.vida = vida;
        this.comida = comida;
    }

    /**
     * Retorna o item que o animal consome como comida.
     *
     * @return o {@link Item} usado como comida
     */
    public Item getComida() {
        return comida;
    }

    /**
     * Retorna o nome do animal.
     *
     * @return nome do animal
     */
    public String getNome() {
        return nome;
    }

    /**
     * Retorna o item que este animal produz.
     *
     * @return o {@link Item} produzido
     */
    public Item getItemProduzido() {
        return itemProduzido;
    }

    /**
     * Alimenta o animal, se a comida correta estiver presente no {@link Inventario}.
     *
     * @param inventario o inventário do jogador
     */
    public void alimentar(Inventario inventario) {
        if (inventario.contem(this.getComida())) {
            if (fome) {
                fome = false;
                inventario.remover(this.getComida());
                System.out.println(nome + " foi alimentado.");
            } else {
                System.out.println(nome + " não está com fome.");
            }
        } else {
            System.out.println("Comida de " + nome + " não encontrada no inventário.");
        }
    }
}
