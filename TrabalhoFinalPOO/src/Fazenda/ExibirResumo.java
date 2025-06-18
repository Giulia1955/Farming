package Fazenda;

import Fazenda.Informacoes.Dinheiro;
import Fazenda.Informacoes.Inventario;
import Fazenda.Informacoes.Lotes;

public class ExibirResumo {
    public void exibirResumoDiario(Inventario inventario, Lotes lotes, Loja loja, Dinheiro dinheiro, EventoRandomico evento, Controle controle) {
        String borda = "═".repeat(72);
        System.out.println();
        System.out.println("╔" + borda + "╗");
        System.out.printf("║%-72s║%n", "🌄  RESUMO DO DIA " + controle.dias + " NA BUSFARM");
        System.out.println("╠" + borda + "╣");

        if (controle.dias != 1) {
            evento.executarEvento(dinheiro, inventario);
        }

        System.out.printf("║%-72s║%n", "  Ocorrências do dia:");
        boolean tevePerdas = false;

        String[] mortes = {
                "🐔 " + controle.controleMortes[0] + " galinha(s) morreram",
                "🐑 " + controle.controleMortes[1] + " ovelha(s) morreram",
                "🐄 " + controle.controleMortes[2] + " vaca(s) morreram",
                "🌽 " + controle.controleMortes[3] + " milhos morreram",
                "🌱 " + controle.controleMortes[4] + " sojas morreram",
                "🌾 " + controle.controleMortes[5] + " trigos morreram"
        };

        for (int i = 0; i < mortes.length; i++) {
            if (controle.controleMortes[i] > 0) {
                System.out.printf("║   %-69s║%n", mortes[i]);
                tevePerdas = true;
            }
        }

        if (!tevePerdas) {
            System.out.printf("║   %-69s║%n", "Nenhuma perda registrada hoje! 🎉");
        }

        System.out.println("╠" + borda + "╣");
        System.out.printf("║ 💰 Dinheiro disponível: R$ %-44.2f║%n", dinheiro.getValor());

        System.out.println("╠" + borda + "╣");
        System.out.printf("║ %-72s║%n", "📦  Inventário:");
        System.out.println("╟" + "─".repeat(72) + "╢");
        inventario.imprimirInventario();

        System.out.println("╠" + borda + "╣");
        System.out.printf("║ %-72s║%n", "🚜  Lotes:");
        System.out.println("╟" + "─".repeat(72) + "╢");
        lotes.imprimirLotes(lotes);

        System.out.println("╚" + borda + "╝");
    }
}

