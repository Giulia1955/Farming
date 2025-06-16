package Fazenda.PlantaEAnimal.Plantas;

import Fazenda.PlantaEAnimal.Ativo;
import Fazenda.Informacoes.Lotes;

import java.util.ArrayList;

public class Regar {
    public void regarTudo(Lotes lotes) {
        ArrayList<Ativo>[] todosLotes = lotes.getLotes();
        int totalRegadas = 0;

        for (ArrayList<Ativo> lote : todosLotes) {
            for (Ativo ativo : lote) {
                if (ativo instanceof Planta planta) {
                    totalRegadas++;
                    planta.regar();
                }
            }
        }

        if (totalRegadas == 0) {
            System.out.println("Nenhuma planta para regar.");
        } else {
            System.out.println("Total de plantas regadas: " + totalRegadas);
        }
    }
}
