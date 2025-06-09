package Fazenda;
import Fazenda.Produto;
/**
 * Interface que define operações básicas de um ser vivo na fazenda.
 * Extendem a interface {@link Produto}
 *
 * Implementada por classes de itens/plantas que podem ser transacionados e produzem itens para a fazenda.
 *
 * @author SeuNome
 * @version 1.0
 */

public interface Ativo extends Produto {
    /**
     * Coletam itens dos seres e os adicionam no inventário.
     *
     * @param inventario para adicionar um item ao inventario
     * @param LotesDisponiveis para liberar espaço após colheitas
     */
    public void coletar(Inventario inventario, Lotes LotesDisponiveis);
}
