package Fazenda.Itens;
import java.io.Serializable;

public class Ovo extends Item implements Serializable {
    private static final long serialVersionUID = 1L;
    public Ovo(){
        super (4, "uma unidade de um único ovo", "Ovo");
    }
}
