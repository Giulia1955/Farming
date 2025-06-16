package Fazenda;

import Fazenda.Informacoes.Dinheiro;
import Fazenda.Informacoes.Inventario;
import Fazenda.Itens.*;

import java.util.HashMap;
import java.util.*;

public class Loja {
    private Map<Integer, Item> itens;

    public Loja() {
        itens = new HashMap<>();
    }

    public Map<Integer, Item> getItens() {
        return itens;
    }

    public void setItens(Map<Integer, Item> itens) {
        this.itens = itens;
    }

    public void Inicializar() {
        itens.put(0, new filhoteOvelha());
        itens.put(1, new filhoteGalinha());
        itens.put(2, new filhoteVaca());
        itens.put(3, new sementeSoja());
        itens.put(4, new sementeMilho());
        itens.put(5, new sementeTrigo());
        itens.put(6, new La());
        itens.put(7, new Leite());
        itens.put(8, new Ovo());
    }

    public void comprarVariosItens(Dinheiro dinheiro, Inventario inventario, int... opcoes) {
        for (int codigo : opcoes) {
            Item item = itens.get(codigo);

            if (item == null) {
                System.out.println("Item com código " + codigo + " não está disponível.");
                continue;
            }

            double preco = item.getPreco();

            if (dinheiro.getValor() >= preco) {
                dinheiro.setValor(dinheiro.getValor() - preco);
                inventario.adicionar(item, 1);
                itens.remove(codigo);
                System.out.println("Comprou: " + item.getNome() + " por R$" + preco);
            } else {
                System.out.println("Dinheiro insuficiente para comprar " + item.getNome());
            }
        }
    }

    public boolean contem(Item item) {
        return itens.containsKey(item);
    }

    public void imprimirLoja() {
        String borda = "═".repeat(50);
        System.out.println("╔" + borda + "╗");
        System.out.printf("║%-50s║%n", " 🛒 BEM-VINDO À LOJA DA BUSFARM ");
        System.out.println("╠" + borda + "╣");
        System.out.printf("║ %-4s │ %-25s │ %-12s ║%n", "Cód", "Item", "Preço (R$)");
        System.out.println("╟" + "─────┼" + "─────────────────────────┼" + "──────────────╢");

        for (Map.Entry<Integer, Item> entry : itens.entrySet()) {
            int codigo = entry.getKey();
            Item item = entry.getValue();
            System.out.printf("║ %-4d │ %-25s │ %-12.2f ║%n", codigo, item.getNome(), item.getPreco());
        }

        System.out.println("╚" + borda + "╝");
    }
    public void abrirLoja(Scanner scanner, Loja loja, Dinheiro dinheiro, Inventario inventario){
        System.out.print("Digite os códigos dos itens para comprar (ex: 0 2 5): ");
        String linha = scanner.nextLine();
        String[] partes = linha.trim().split("\\s+");
        int[] codigos = new int[partes.length];

        for (int i = 0; i < partes.length; i++) {
            codigos[i] = Integer.parseInt(partes[i]);
        }

        loja.comprarVariosItens(dinheiro, inventario, codigos);
    }
}
