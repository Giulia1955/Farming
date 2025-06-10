package Fazenda.Animais;
import Fazenda.Inventario;
import Fazenda.Itens.Item;
import Fazenda.Ativo;
import Fazenda.Itens.sementeMilho;
import Fazenda.Lotes;
import Fazenda.Dinheiro;
import Fazenda.Itens.Ovo;


/**
 * Representa uma galinha, que é um tipo de {@link Animal}.
 * @author Guilherme
 */
public class Galinha extends Animal implements Ativo{
    /**
     * Classe para inicializar a classe galinha
     * @param nome é o nome de cada galinha
     * @param preco é o valor em dinheiro de cada galinha
     * @param itemProduzido indica o item {@link Item} que a galinha vai produzir
     * @param fome diz se a galinha precisa ou não ser alimentada
     * @param comida mostra que tipo de comida {@link Item} a galinha come
     */



    public Galinha() {
        super("Galinha", 20, new Ovo(), false, 10, new sementeMilho(), 1, 3);
    }



    @Override
    public void alimentar(Inventario inventario) {
        if (inventario.contem(this.getComida())) {
            if (isFome()) {
                setFome(false);
                inventario.remover(this.getComida(), getQuantoCome());
                System.out.println(getNome() + " foi alimentado.");
            } else {
                System.out.println(getNome() + " não está com fome.");
            }
        } else {
            System.out.println("Comida de " + getNome() + " não encontrada no inventário.");
        }
    }

    public void coletar(Inventario inventario, Lotes lotes) {
        inventario.adicionar(this.getItemProduzido(), getQuantidadeProducao());
    }

    public void comprar(Dinheiro dinheiro, Inventario inventario, Lotes LotesDisponiveis){
        if ((dinheiro.getValor() >= this.getPreco()) && (LotesDisponiveis.getQuantidadeDisponivel() > 0) ) {
            dinheiro.setValor(dinheiro.getValor() - this.getPreco());
            LotesDisponiveis.setQuantidadeDisponivel(LotesDisponiveis.getQuantidadeDisponivel() - 1);
        } else {
            System.out.println("Dinheiro insuficiente, trabalhe mais... ou venda um rim!");
        }
    }

    public void vender(Dinheiro dinheiro, Inventario inventario) {
        dinheiro.setValor(dinheiro.getValor() + this.getItemProduzido().getPreco());
        inventario.remover(this.getItemProduzido(), 1);
    }
}
