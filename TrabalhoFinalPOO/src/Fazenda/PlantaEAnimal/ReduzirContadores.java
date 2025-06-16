package Fazenda.PlantaEAnimal;

import Fazenda.Informacoes.Lotes;
import Fazenda.PlantaEAnimal.Animais.Animal;
import Fazenda.PlantaEAnimal.Plantas.Planta;

import java.util.ArrayList;

public class ReduzirContadores {
    public void reduzirVidaAnimal (Animal animal){
        animal.setVida(animal.getVida() - 1);
    }

    public void reduzirDiasdeProdPlanta (Planta planta){
        planta.setDiasParaProduzir(planta.getDiasParaProduzir() - 1);
    }

    public void reduzirVidaeDiasdeProd(Lotes lotes) {
        try {
            for (ArrayList<Ativo> lote : lotes.getLotes()) {
                for (Ativo ativo : lote) {
                    if (ativo instanceof Animal animal) {
                        reduzirVidaAnimal(animal);
                        if (animal.getDiasParaProduzir() > 0) {
                            animal.setDiasParaProduzir(animal.getDiasParaProduzir() - 1);
                        }
                    }
                    if (ativo instanceof Planta planta) {
                        reduzirDiasdeProdPlanta(planta);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
