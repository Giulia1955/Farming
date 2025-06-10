package Fazenda.Animais;
import Fazenda.Inventario;
import Fazenda.Itens.Item;
import Fazenda.Dinheiro;
import Fazenda.Ativo;
import Fazenda.Itens.La;
import Fazenda.Itens.sementeTrigo;
import Fazenda.Lotes;

/**
 * Representa uma Ovelha, que é um tipo de {@link Animal}.
 * @author Guilherme
 */
public class Ovelha extends Animal implements Ativo{
    /**
     * Classe para inicializar a classe ovelha
     * @param nome é o nome de cada ovelha
     * @param preco é o valor em dinheiro de cada ovelha
     * @param itemProduzido indica o item {@link Item} que a ovelha vai produzir
     * @param fome diz se a ovelha precisa ou não ser alimentada
     * @param comida mostra que tipo de comida {@link Item} a ovelha come
     */
    public Ovelha() {
        super("Ovelha", 35, new La(), false, 15, new sementeTrigo(), 2, 5);
    }
    @Override
    public Item getComida() {
        return super.getComida();
    }

    @Override
    public String getNome() {
        return super.getNome();
    }

    @Override
    public Item getItemProduzido() {
        return super.getItemProduzido();
    }

    @Override
    public void alimentar(Inventario inventario) {
        super.alimentar(inventario);
    }

    public void coletar(Inventario inventario, Lotes lotes) {
        inventario.adicionar(this.getItemProduzido(), 2);
    }

    public void comprar(Dinheiro dinheiro, Inventario inventario){
        if (dinheiro.getValor() >= this.getItemProduzido().getPreco()) {
            dinheiro.setValor(dinheiro.getValor() - this.getItemProduzido().getPreco());
            inventario.adicionar(this.getItemProduzido(), 1);
        } else {
            System.out.println("Dinheiro insuficiente, trabalhe mais... ou venda um rim!");
        }
    }

    public void vender(Dinheiro dinheiro, Inventario inventario) {
        dinheiro.setValor(dinheiro.getValor() + this.getItemProduzido().getPreco());
        inventario.remover(this.getItemProduzido(), 1);
    }
}
