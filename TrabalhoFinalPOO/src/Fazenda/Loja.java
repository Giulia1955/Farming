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
        itens.put(0, new FilhoteOvelha());
        itens.put(1, new FilhoteGalinha());
        itens.put(2, new FilhoteVaca());
        itens.put(3, new SementeSoja());
        itens.put(4, new SementeMilho());
        itens.put(5, new SementeTrigo());
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

    public void imprimirLoja(Dinheiro dinheiro) {
        String borda = "═".repeat(50);
        System.out.println("╔" + borda + "╗");
        System.out.printf("║%-50s║%n", " 🛒 BEM-VINDO À LOJA DA BUSFARM   💰SALDO: R$ " + dinheiro.getValor());
        System.out.println("╠" + borda + "╣");
        System.out.printf("║ %-4s │ %-25s │ %-12s ║%n", "Cód", "Item", "Preço (R$)");
        System.out.println("╟" + "─────┼" + "─────────────────────────┼" + "──────────────╢");

        for (Map.Entry<Integer, Item> entry : itens.entrySet()) {
            int codigo = entry.getKey();
            Item item = entry.getValue();
            System.out.printf("║ %-4d │ %-25s │ %-12.2f ║%n", codigo, item.getNome(), item.getPreco());
        }

        System.out.printf("║ %-4s │ %-25s │ %-12s ║%n", "-1", "Voltar", "-");
        System.out.println("╚" + borda + "╝");
    }

    public void abrirLoja(Scanner scanner, Loja loja, Dinheiro dinheiro, Inventario inventario) {
        System.out.print("Digite os códigos dos itens para comprar (ex: 0 2 5 ou -1 para voltar): ");
        String linha = scanner.nextLine().trim();
        if (linha.equals("-1")) {
            System.out.println("Saindo da loja...");
            return;
        }

        String[] partes = linha.split("\\s+");
        int[] codigos = new int[partes.length];

        try {
            for (int i = 0; i < partes.length; i++) {
                codigos[i] = Integer.parseInt(partes[i]);
            }
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Use apenas números separados por espaço.");
            return;
        }
        loja.comprarVariosItens(dinheiro, inventario, codigos);
    }

}
