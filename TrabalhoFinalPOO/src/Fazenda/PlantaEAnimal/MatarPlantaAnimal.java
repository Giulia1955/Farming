package Fazenda.PlantaEAnimal;

import Fazenda.Informacoes.Lotes;
import Fazenda.PlantaEAnimal.Animais.Animal;
import Fazenda.PlantaEAnimal.Plantas.Planta;
import Fazenda.Informacoes.TipoLote;

import java.util.ArrayList;
import java.util.Iterator;

public class MatarPlantaAnimal {
    public int matarAnimal(Lotes lotes, TipoLote tipoLote) {
        int contador = 0;
        int index = tipoLote.ordinal();
        ArrayList<Ativo> arrayTipo = lotes.getLotes()[index];

        Iterator<Ativo> iterator = arrayTipo.iterator();
        while (iterator.hasNext()) {
            Ativo ativo = iterator.next();
            if (ativo instanceof Animal animal) {
                if (animal.getVida() == 0 || animal.isFome()) {
                    iterator.remove();
                    contador++;
                }
            }
        }
        return contador;
    }


    public int matarPlanta(Lotes lotes, TipoLote tipoLote){
        int contador = 0;
        ArrayList<Ativo>[] arrayLotes = lotes.getLotes();

        for (ArrayList<Ativo> arrayTipo : arrayLotes) {
            Iterator<Ativo> iterator = arrayTipo.iterator();
            while (iterator.hasNext()) {
                Ativo ativo = iterator.next();
                if (ativo instanceof Planta planta && planta.isSede()) {
                    iterator.remove();
                    contador++;
                }
            }
        }
        return contador;
    }
}
