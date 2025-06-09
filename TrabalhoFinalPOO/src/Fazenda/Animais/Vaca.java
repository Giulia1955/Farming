package Fazenda.Animais;
import Fazenda.Itens.Item;

/**
 * Representa uma vaca, que é um tipo de {@link Animal}.
 * @author Guilherme
 */
public class Vaca extends Animal{
    /**
     * Classe para inicializar a classe vaca
     * @param nome é o nome de cada vaca
     * @param preco é o valor em dinheiro de cada vaca
     * @param itemProduzido indica o item {@link Item} que a vaca vai produzir
     * @param fome diz se a vaca precisa ou não ser alimentada
     * @param comida mostra que tipo de comida {@link Item} a vaca come
     */
    public Vaca(String nome, double preco, Item itemProduzido, boolean fome, int vida, Item comida) {
        super(nome, preco, itemProduzido,  fome, vida, comida);
    }
}
