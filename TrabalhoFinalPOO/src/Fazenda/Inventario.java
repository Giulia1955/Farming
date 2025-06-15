package Fazenda;

import Fazenda.Itens.Item;
import java.util.*;
import java.io.Serializable;


public class Inventario implements Serializable {
    private static final long serialVersionUID = 1L;

    private Map<Item, Integer> itens;

    public Inventario() {
        itens = new HashMap<>();
    }

    public Map<Item, Integer> getItens() {
        return itens;
    }

    public void setItens(Map<Item, Integer> itens) {
        this.itens = itens;
    }

    public void adicionar(Item item, int qtd) {
        if (itens.containsKey(item)) {
            int novaQtd = itens.get(item) + qtd;
            itens.put(item, novaQtd);
        } else {
            itens.put(item, qtd);
        }
    }

    public boolean remover(Item item, int qtd) {
        if(!contem(item)){
            System.out.println("Item não existe no inventario.");
            return false;
        }
        int atual = itens.get(item);
        if(atual == qtd){
            itens.remove(item);
        }else{
            itens.put(item, atual - 1);
        }
        return true;
    }

    public boolean contem(Item item) {
        return itens.containsKey(item);
    }

    public int quantidadeDisponivel(Item item){
        return(itens.get(item));
    }

    public void imprimirInventario () {
        for (Map.Entry<Item, Integer> entry : itens.entrySet()) {
            System.out.println(entry.getKey().getNome() + ": " + entry.getValue());
        }
    }
}
