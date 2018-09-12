package estoquesystem.model;

import java.util.Random;

/**
 * @class classe de criação e gerenciamento do objeto produto
 * @attr random, id, valor, nome, categoria, quantidade
 */
public class Produto {

    private Random random = new Random();
    private int id;
    private double valor;
    private String nome;
    private String categoria;
    private int quantidade;

    /**
     * @constructor Construtor composto para a ciração dos produtos.
     * @attr id
     * @param nome,
     * @param categoria
     * @param valor
     * @param quantidade
     */
    public Produto(String nome, String categoria, double valor, int quantidade) {
        this.id = (100 + this.random.nextInt(899));
        this.nome = nome;
        this.categoria = categoria;
        this.valor = valor;
        this.quantidade = quantidade;
    }

    //Getters and Setters dos atributos da Classe
    /**
     *
     * @return
     */
    public double getValor() {
        return this.valor;
    }

    /**
     *
     * @param valor
     */
    public void setValor(double valor) {
        this.valor = valor;
    }

    /**
     *
     * @return
     */
    public int getQuantidade() {
        return this.quantidade;
    }

    /**
     *
     * @param quantidade
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     *
     * @return
     */
    public String getNome() {
        return this.nome;
    }

    /**
     *
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     *
     * @return
     */
    public String getCategoria() {
        return this.categoria;
    }

    /**
     *
     * @param categoria
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     *
     * @return
     */
    public int getId() {
        return this.id;
    }

    /**
     * @method para formatar a apresentação do objeto em string
     * @attr
     * @return uma string formatada.
     */
    @Override
    public String toString() {
        return String.format("|       -->> PRODUTO <<--        |\n"
                + "==================================\n"
                + "Produto: %s\n"
                + "Categoria: %s\n"
                + "Valor: R$ %.2f\n"
                + "Quantidade: %1d",
                this.nome, this.categoria, Double.valueOf(this.valor),
                Integer.valueOf(this.quantidade));
    }

    /**
     * @method Para formatação para o modo lista de cada objeto produto
     * @attr inStr, outStr
     * @return String formatada.
     */
    public String toList() {

        return String.format("    %s    |\t%s", this.id, this.nome);
    }

    public String toFullList() {
        String inStr;
        inStr = String.format("%8s, %8s, %8s, R$ %8.2f, %8d",
                this.id, this.nome, this.categoria, this.valor, this.quantidade);
        String outStr = inStr.replaceAll(", ", "\t|\t");
        return outStr;
    }
}
