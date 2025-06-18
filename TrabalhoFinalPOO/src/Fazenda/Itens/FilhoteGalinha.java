package Fazenda.Itens;

import java.io.Serializable;

public class FilhoteGalinha extends Item implements Serializable {
    private static final long serialVersionUID = 1L;
    public FilhoteGalinha(){
        super(20, "Um lindo pintinho", "Filhote de galinha");
    }
}
