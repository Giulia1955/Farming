package Fazenda.Itens;
import java.io.Serializable;

public class FilhoteOvelha extends Item implements Serializable {
    private static final long serialVersionUID = 1L;
    public FilhoteOvelha(){
        super(40, "Uma linda novilha", "Filhote de ovelha");
    }
}
