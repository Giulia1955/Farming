package Fazenda.Informacoes;

import Fazenda.Itens.Item;

import java.io.Serial;
import java.util.*;
import java.io.Serializable;


public class Inventario implements Serializable {
    @Serial
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
        if (itens.isEmpty()) {
            System.out.println("📦 Inventário vazio.");
            return;
        }

        int index = 1;

        for (Map.Entry<Item, Integer> entry : itens.entrySet()) {
            Item item = entry.getKey();
            int quantidade = entry.getValue();
            System.out.printf("%d - %s (x%d) - R$%.2f cada%n", index, item.getNome(), quantidade, item.getPreco());
            index++;
        }
    }

    public void vender(Scanner scanner, Dinheiro dinheiro) {
        if (itens.isEmpty()) {
            System.out.println("Seu inventário está vazio. Nada para vender.");
            return;
        }

        System.out.println("Itens disponíveis para venda:");
        imprimirInventario();

        System.out.print("Digite o número do item que deseja vender (ou 0 para cancelar): ");
        int escolha = scanner.nextInt();
        scanner.nextLine();

        List<Item> listaItens = new ArrayList<>();

        for (Map.Entry<Item, Integer> entry : itens.entrySet()) {
            Item item = entry.getKey();
            listaItens.add(item);
        }

        if (escolha <= 0 || escolha > listaItens.size()) {
            System.out.println("Venda cancelada.");
            return;
        }

        Item escolhido = listaItens.get(escolha - 1);

        System.out.print("Quantas unidades deseja vender? ");
        int qtdVenda = scanner.nextInt();
        scanner.nextLine();

        int qtdDisponivel = itens.get(escolhido);
        if (qtdVenda <= 0 || qtdVenda > qtdDisponivel) {
            System.out.println("Quantidade inválida. Venda cancelada.");
            return;
        }

        double totalVenda = escolhido.getPreco() * qtdVenda;
        dinheiro.setValor(dinheiro.getValor() + totalVenda);

        if(remover(escolhido, qtdVenda)){
            System.out.printf("Você vendeu %d unidade(s) de %s por R$%.2f.%n",
                    qtdVenda, escolhido.getNome(), totalVenda);
        }
    }
}
