package Fazenda.Plantas;

import Fazenda.Itens.Item;
import Fazenda.Ativo;
import Fazenda.Itens.sementeMilho;
import Fazenda.Inventario;
import Fazenda.Dinheiro;
import Fazenda.Lotes;

/**
 * Classe abstrata que representa uma planta cultivável na fazenda.
 * Cada planta possui um nome, estado de crescimento, sede e um {@link Item} que ela produz quando colhida.
 *
 * As plantas podem ser regadas e plantadas em {@link Lotes} disponíveis, desde que o jogador possua o item correspondente no {@link Inventario}.
 *
 * Essa classe serve como base para plantas específicas como {@link Milho}, {@link Soja} e {@link Trigo}.
 *
 * @author Guilherme e Giulia
 * @version 1.0
 */
public abstract class Planta {
    private boolean sede, estado;
    private Item itemProduzido;
    private String nome;

    /**
     * Construtor da classe Planta.
     *
     * @param estado indica se a planta já está plantada (true) ou não (false)
     * @param sede indica se a planta está com sede (true) ou não (false)
     * @param itemProduzido o {@link Item} que será produzido por essa planta
     * @param nome o nome da planta
     */
    public Planta(boolean estado, boolean sede, Item itemProduzido, String nome) {
        this.itemProduzido = itemProduzido;
        this.sede = false;
        this.estado = false;
        this.nome = nome;
    }

    /**
     * Retorna o item que será produzido por esta planta ao final do seu crescimento.
     *
     * @return o {@link Item} produzido
     */
    public Item getItemProduzido() {
        return itemProduzido;
    }

    /**
     * Rega a planta, removendo seu estado de sede.
     * Caso a planta não esteja com sede, o método não faz nada.
     */
    public void Regar() {
        if (sede) {
            this.sede = false;
        }
    }

    /**
     * Planta esta planta em um lote disponível, caso haja espaço.
     * Remove o item correspondente do inventário do jogador.
     *
     * @param LotesDisponiveis o conjunto de {@link Lotes} disponíveis para plantio
     * @param inventario o {@link Inventario} do jogador, de onde será removido o item plantado
     */
    public void Plantar(Lotes LotesDisponiveis, Inventario inventario) {
        if (LotesDisponiveis.getQuantidadeDisponivel() > 0) {
            LotesDisponiveis.setQuantidadeDisponivel(LotesDisponiveis.getQuantidadeDisponivel() - 1);
            inventario.remover(this.itemProduzido);
        } else {
            System.out.println("Não há lotes disponíveis");
        }
    }
}
