package Fazenda.Itens;
import java.io.Serializable;

public class FilhoteVaca extends Item implements Serializable{
    private static final long serialVersionUID = 1L;
    public FilhoteVaca(){
        super(60, "Uma vaquinha!", "Filhote de vaca");
    }
}
