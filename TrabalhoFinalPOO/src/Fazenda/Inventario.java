package Fazenda;

import Fazenda.Itens.Item;
import java.util.*;


public class Inventario {

    private Map<Item, Integer> Itens;

    public Inventario() {
        Itens = new HashMap<>();
    }

    public void adicionar(Item item, int quantidade) {
        if (Itens.containsKey(item)) {
            int novaQuantidade = Itens.get(item) + quantidade;
            Itens.put(item, novaQuantidade);
        } else {
            Itens.put(item, quantidade);
        }
    }

    public boolean remover(Item item, int quantidade) {
        int atual = Itens.get(item);

        if (!Itens.containsKey(item) || (atual < quantidade)) {
            return false;
        }
        if (atual == quantidade) {
            Itens.remove(item);
        } else {
            Itens.put(item, atual - quantidade);
        }
        return true;
    }

    public boolean contem(Item item) {
        return Itens.containsKey(item);
    }


    public void imprimirInventario() {
        for (Map.Entry<Item, Integer> entry : Itens.entrySet()) {
            System.out.println(entry.getKey().getNome() + ": " + entry.getValue());
        }
    }
}
