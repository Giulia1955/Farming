package Fazenda.PlantaEAnimal.Animais;
import Fazenda.Itens.Item;
import Fazenda.Informacoes.Inventario;
import Fazenda.Informacoes.Lotes;
import java.io.Serializable;

public abstract class Animal implements Serializable {
    private Item itemProduzido, comida, filhote;
    private boolean fome;
    private int vida;
    private String nome;
    private int QuantidadeProducao, quantoCome, diasParaProduzir, diasEntreProducoes;

    public Animal(String nome, Item itemProduzido, boolean fome, int vida, Item comida, int QuantidadeProducao, int diasParaProduzir, Item filhote){
        this.nome = nome;
        this.itemProduzido = itemProduzido;
        this.fome = fome;
        this.vida = vida;
        this.comida = comida;
        this.QuantidadeProducao = QuantidadeProducao;
        this.diasParaProduzir = diasParaProduzir;
        this.filhote = filhote;
        this.diasEntreProducoes = diasParaProduzir;
    }

    public Item getItemProduzido() {
        return itemProduzido;
    }

    public void setItemProduzido(Item itemProduzido) {
        this.itemProduzido = itemProduzido;
    }

    public Item getComida() {
        return comida;
    }

    public void setComida(Item comida) {
        this.comida = comida;
    }

    public boolean isFome() {
        return fome;
    }

    public void setFome(boolean fome) {
        this.fome = fome;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getQuantidadeProducao() {
        return QuantidadeProducao;
    }

    public void setQuantidadeProducao(int quantidadeProducao) {
        QuantidadeProducao = quantidadeProducao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Item getFilhote() {
        return filhote;
    }

    public void setFilhote(Item filhote) {
        this.filhote = filhote;
    }

    public int getDiasParaProduzir() {
        return diasParaProduzir;
    }

    public void setDiasParaProduzir(int diasParaProduzir) {
        this.diasParaProduzir = diasParaProduzir;
    }

    public abstract void alimentar(Inventario inventario, Lotes lotes);

    public abstract void colocar(Inventario inventario, Lotes lotes);

    public boolean prontoParaColeta() {
        return this.getDiasParaProduzir() <= 0;
    }

    public int getDiasEntreProducoes() {
        return diasEntreProducoes;
    }
}
