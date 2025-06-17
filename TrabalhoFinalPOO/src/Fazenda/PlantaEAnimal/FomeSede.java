package Fazenda.PlantaEAnimal;

import Fazenda.Informacoes.Lotes;
import Fazenda.PlantaEAnimal.Animais.Animal;
import Fazenda.PlantaEAnimal.Plantas.Planta;

import java.util.ArrayList;

public class FomeSede {
    public void colocarSede(Lotes lotes){
        ArrayList<Ativo>[] todosLotes = lotes.getLotes();

        for (ArrayList<Ativo> lote : todosLotes) {
            for (Ativo ativo : lote) {
                if (ativo instanceof Planta planta) {
                    planta.setSede(true);
                }
            }
        }
    }

    public void colocarFome(Lotes lotes){
        ArrayList<Ativo>[] todosLotes = lotes.getLotes();

        for (ArrayList<Ativo> lote : todosLotes) {
            for (Ativo ativo : lote) {
                if (ativo instanceof Animal animal) {
                    animal.setFome(true);
                }
            }
        }
    }
}
