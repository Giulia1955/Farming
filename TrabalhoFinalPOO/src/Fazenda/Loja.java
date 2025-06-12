package Fazenda;

import Fazenda.Itens.*;

import java.util.HashMap;
import java.util.*;

public class Loja {
    private Map<Item, Integer> itens;

    public Loja() {
        itens = new HashMap<>();
    }

    public Map<Item, Integer> getItens() {
        return itens;
    }

    public void setItens(Map<Item, Integer> itens) {
        this.itens = itens;
    }

    public void Inicializar() {
        itens.put(new FilhoteOvelha(), 1);
        itens.put(new FilhoteGalinha(), 1);
        itens.put(new FilhoteVaca(), 1);
        itens.put(new SementeSoja(), 1);
        itens.put(new SementeMilho(), 1);
        itens.put(new SementeTrigo(), 1);
        itens.put(new La(), 1);
        itens.put(new Leite(), 1);
        itens.put(new Ovo(), 1);
    }

    public boolean ComprarItem(Item item, Dinheiro dinheiro, Inventario inventario) {
        if(!contem(item) ){
            System.out.println("Item já vendido, volte amanhã!");
            return false;
        } else{
            dinheiro.setValor(dinheiro.getValor() - item.getPreco());
            inventario.adicionar(item, 1);
            itens.remove(item);
        }
        return true;
    }

    public boolean contem(Item item) {
        return itens.containsKey(item);
    }

    public void imprimirLoja () {
        for (Map.Entry<Item, Integer> entry : itens.entrySet()) {
            System.out.println(entry.getKey().getNome() + ": " + entry.getValue());
        }
    }
}
