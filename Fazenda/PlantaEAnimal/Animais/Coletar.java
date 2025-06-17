package Fazenda.PlantaEAnimal.Animais;

import Fazenda.PlantaEAnimal.Ativo;
import Fazenda.Informacoes.Inventario;
import Fazenda.Informacoes.Lotes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Coletar {
    public void coletarTudo(Inventario inventario, Lotes lotes) {
        ArrayList<Ativo>[] todosLotes = lotes.getLotes();
        Map<String, Integer> itensColetados = new HashMap<>();
        int totalColetado = 0;

        for (ArrayList<Ativo> lote : todosLotes) {
            for (Ativo ativo : lote) {
                if (ativo instanceof Animal animal && animal.prontoParaColeta()) {
                    inventario.adicionar(animal.getItemProduzido(), animal.getQuantidadeProducao());
                    animal.setDiasParaProduzir(animal.getDiasEntreProducoes());
                    String nomeItem = animal.getItemProduzido().getNome();
                    int quantidade = animal.getQuantidadeProducao();

                    itensColetados.put(nomeItem, itensColetados.getOrDefault(nomeItem, 0) + quantidade);
                    totalColetado++;
                }
            }
        }

        if (totalColetado == 0) {
            System.out.println("Nenhum animal estava pronto para coleta.");
        } else {
            System.out.println("Itens coletados dos animais:");
            for (Map.Entry<String, Integer> entry : itensColetados.entrySet()) {
                System.out.println("- " + entry.getKey() + ": " + entry.getValue() + " unidade(s)");
            }
        }
    }
}
