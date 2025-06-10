package Fazenda.Animais;
import Fazenda.Inventario;
import Fazenda.Itens.Item;
import Fazenda.Dinheiro;
import Fazenda.Ativo;
import Fazenda.Itens.Leite;
import Fazenda.Itens.sementeSoja;
import Fazenda.Lotes;

/**
 * Representa uma vaca, que é um tipo de {@link Animal}.
 * @author Guilherme
 */
public class Vaca extends Animal implements Ativo{
    /**
     * Classe para inicializar a classe vaca
     * @param nome é o nome de cada vaca
     * @param preco é o valor em dinheiro de cada vaca
     * @param itemProduzido indica o item {@link Item} que a vaca vai produzir
     * @param fome diz se a vaca precisa ou não ser alimentada
     * @param comida mostra que tipo de comida {@link Item} a vaca come
     */
    public Vaca() {
        super("Vaca", 50, new Leite(), false, 20, new sementeSoja(), 5, 7);
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
        inventario.adicionar(this.getItemProduzido(), 3);
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
