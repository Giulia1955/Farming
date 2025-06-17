package Fazenda.PlantaEAnimal.Animais;

import Fazenda.Informacoes.Inventario;
import Fazenda.Informacoes.Lotes;

public class Alimentar {
    public void alimentarAnimais(Inventario inventario, Lotes lotes) {
        System.out.println("Alimentando todos os animais famintos...");

        Galinha galinha = new Galinha();
        Ovelha ovelha = new Ovelha();
        Vaca vaca = new Vaca();

        galinha.alimentar(inventario, lotes);
        ovelha.alimentar(inventario, lotes);
        vaca.alimentar(inventario, lotes);
    }
}
