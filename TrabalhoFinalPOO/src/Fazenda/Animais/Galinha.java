package Fazenda.Animais;
import Fazenda.Itens.Item;

/**
 * Representa uma galinha, que é um tipo de {@link Animal}.
 * @author Guilherme
 */
public class Galinha extends Animal{
    /**
     * Classe para inicializar a classe galinha
     * @param nome é o nome de cada galinha
     * @param preco é o valor em dinheiro de cada galinha
     * @param itemProduzido indica o item {@link Item} que a galinha vai produzir
     * @param fome diz se a galinha precisa ou não ser alimentada
     * @param comida mostra que tipo de comida {@link Item} a galinha come
     */
    public Galinha(String nome, double preco, Item itemProduzido, boolean fome, int vida, Item comida) {
        super(nome, preco, itemProduzido,  fome, vida, comida);
    }
}
