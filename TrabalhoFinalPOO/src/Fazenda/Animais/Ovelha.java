package Fazenda.Animais;
import Fazenda.Itens.Item;

/**
 * Representa uma Ovelha, que é um tipo de {@link Animal}.
 * @author Guilherme
 */
public class Ovelha extends Animal{
    /**
     * Classe para inicializar a classe ovelha
     * @param nome é o nome de cada ovelha
     * @param preco é o valor em dinheiro de cada ovelha
     * @param itemProduzido indica o item {@link Item} que a ovelha vai produzir
     * @param fome diz se a ovelha precisa ou não ser alimentada
     * @param comida mostra que tipo de comida {@link Item} a ovelha come
     */
    public Ovelha(String nome, double preco, Item itemProduzido, boolean fome, int vida, Item comida) {
        super(nome, preco, itemProduzido,  fome, vida, comida);
    }
}
