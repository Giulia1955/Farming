package Fazenda;

import Fazenda.Inventario;

public interface Produto {
    void comprar(Dinheiro dinheiro, Inventario inventario, Lotes lotes, int qtd);

    void vender(Dinheiro dinheiro, Inventario inventario, Lotes lotes, int qtd);
}
