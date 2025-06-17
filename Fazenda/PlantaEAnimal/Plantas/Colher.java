package Fazenda.PlantaEAnimal.Plantas;

import Fazenda.PlantaEAnimal.Ativo;
import Fazenda.Informacoes.Inventario;
import Fazenda.Informacoes.Lotes;

import java.util.ArrayList;

public class Colher {
    public void colherTudo(Inventario inventario, Lotes lotes) {
        ArrayList<Ativo>[] todosLotes = lotes.getLotes();
        int totalColhido = 0;

        for (ArrayList<Ativo> lote : todosLotes) {
            for (Ativo ativo : new ArrayList<>(lote)) {
                if (ativo instanceof Milho milho) {
                    if (milho.prontoParaColeta()) {
                        milho.coletar(inventario, lotes);
                        totalColhido++;
                    }
                } else if (ativo instanceof Soja soja) {
                    if (soja.prontoParaColeta()) {
                        soja.coletar(inventario, lotes);
                        totalColhido++;
                    }
                } else if (ativo instanceof Trigo trigo) {
                    if (trigo.prontoParaColeta()) {
                        trigo.coletar(inventario, lotes);
                        totalColhido++;
                    }
                }
            }
        }

        if (totalColhido == 0) {
            System.out.println("Nenhuma planta está pronta para colheita.");
        } else {
            System.out.println("🌾 Total de plantações colhidas: " + totalColhido);
        }
    }
}
