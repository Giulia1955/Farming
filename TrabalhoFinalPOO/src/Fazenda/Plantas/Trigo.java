package Fazenda.Plantas;

import Fazenda.Ativo;
import Fazenda.Itens.sementeTrigo;
import Fazenda.Inventario;
import Fazenda.Dinheiro;
import Fazenda.Lotes;
import Fazenda.Produto;

/**
 * A classe {@code Trigo} representa uma planta cultivável na fazenda.
 * Possui funcionalidades de coleta, compra e venda, integrando com o inventário e o sistema financeiro.
 * implementando os métodos do {@link Ativo} e {@link Produto}
 *
 * Produz sementes de trigo como item associado.
 *
 * @author SeuNome
 * @version 1.0
 */
public class Trigo extends Planta implements Ativo {

    /**
     * Construtor padrão da Trigo. Define o item produzido e nome.
     */
    public Trigo() {
        super(false, false, new sementeTrigo(), "Trigo", 3);
    }

    /**
     * Coleta o produto da planta e adiciona ao inventário.
     * Libera um lote após a colheita.
     *
     * @param inventario o inventário do jogador
     * @param LotesDisponiveis controle de lotes disponíveis
     */
    public void coletar(Inventario inventario, Lotes LotesDisponiveis) {
        inventario.adicionar(this.getItemProduzido(), getQuantidadeProducao());
        LotesDisponiveis.setQuantidadeDisponivel(LotesDisponiveis.getQuantidadeDisponivel() + 1);
    }

    /**
     * Compra a semente associada, se houver saldo suficiente.
     */
    public void comprar(Dinheiro dinheiro, Inventario inventario) {
        if (dinheiro.getValor() >= this.getItemProduzido().getPreco()) {
            dinheiro.setValor(dinheiro.getValor() - this.getItemProduzido().getPreco());
            inventario.adicionar(this.getItemProduzido(), 1);
        } else {
            System.out.println("Dinheiro insuficiente, trabalhe mais... ou venda um rim!");
        }
    }

    /**
     * Vende a semente associada, se estiver no inventário.
     */
    public void vender(Dinheiro dinheiro, Inventario inventario) {
        dinheiro.setValor(dinheiro.getValor() + this.getItemProduzido().getPreco());
        inventario.remover(this.getItemProduzido(), 1);
    }
}
