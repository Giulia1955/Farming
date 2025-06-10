package Fazenda.Itens;

/**
 * Classe abstrata que representa um item genérico da fazenda.
 * Um item possui um nome, uma descrição e um preço.
 *
 * Essa classe é estendida por itens concretos como {@link Ovo}, {@link Leite}, {@link La}, {@link sementeMilho}, {@link sementeSoja}, {@link sementeTrigo}
 *
 * @author Guilherme
 * @version 1.0
 */
public abstract class Item {
    private double preco;
    private String descricao, nome;

    /**
     * Construtor da classe Item.
     *
     * @param preco o valor monetário do item
     * @param descricao uma descrição breve do item
     * @param nome o nome do item
     */
    public Item(double preco, String descricao, String nome) {
        this.preco = preco;
        this.descricao = descricao;
        this.nome = nome;
    }

    /**
     * Retorna o preço do item.
     *
     * @return preço do item
     */
    public double getPreco() {
        return preco;
    }

    /**
     * Define um novo preço para o item.
     *
     * @param preco novo preço a ser atribuído
     */
    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

