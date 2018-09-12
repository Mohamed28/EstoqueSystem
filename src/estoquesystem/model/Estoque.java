package estoquesystem.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @class Estoque classe que gerencia as entradas e saídas do estoque, classe
 * especialista no estoque e seus atributos.
 * @attr List, ArrayList
 */
public class Estoque {

    private List<Produto> produtos = new ArrayList();

    /**
     * @constructor construtor inicial que já lança alguns produtos na lista
     */
    public Estoque() {
        Produto pd1 = new Produto("Lapiseira", "Material", 3.99D, 300);
        Produto pd2 = new Produto("Caderno", "Material", 13.59D, 200);
        Produto pd3 = new Produto("Caneta", "Material", 1.69D, 150);
        Produto pd4 = new Produto("Agenda", "Material", 8.99D, 100);
        Produto pd5 = new Produto("Tesoura", "Material", 2.99D, 300);

        this.produtos.add(pd1);
        this.produtos.add(pd2);
        this.produtos.add(pd3);
        this.produtos.add(pd4);
        this.produtos.add(pd5);
    }

    /**
     * @method para adicionar novos produtos a lista
     * @param novoProduto
     * @return verdadeiro ou falso se foi possivel adicionar ou não o produto
     */
    public boolean adicionar(Produto novoProduto) {
        if (this.buscar(novoProduto.getNome()) == null) {
            this.produtos.add(novoProduto);
            return true;
        } else {
            return false;
        }
    }

    /**
     * @method responsável formatar a lista de produtos
     * @attr inStr, outStr
     */
    public void listaCompleta() {
        String inStr = String.format("%8s,%8s,%8s,%8s,%8s\n", "ID", "PRODUTO", "CATEGORIA", "VALOR", "QTD");
        String outStr = inStr.replaceAll(",", "\t|\t");
        System.out.print(outStr);

        for (Produto produto : this.produtos) {
            System.out.println(produto.toList());
        }
    }

    public void listar() {
        for (Produto produto : this.produtos) {
            System.out.println(produto.toList());
        }
    }
    /**
     * @method que percorre a lista e tenta retornar um produto de acordo com o
     * id informado como parametro
     * @param id
     * @return Produto
     */
    public Produto buscar(int id) {
        for (Produto produto : this.produtos) {
            if (produto.getId() == id) {
                return produto;
            }
        }  
        return null ;
    }

    /**
     * @method que percorre a lista e tenta retornar um produto de acordo com o
     * nome informado como parametro
     * @param nome
     * @return Produto
     */
    public Produto buscar(String nome) {
        for (Produto produto : this.produtos) {
            if (produto.getNome().equals(nome)) {
                return produto;
            }
        }
        return null;
    }

    /**
     * @param novoProduto
     * @method usado para substituir/subscrever um produto na lista
     */
    public void substituir(Produto novoProduto) {
        Produto produto = buscar(novoProduto.getNome());
        this.produtos.remove(produto);
        adicionar(novoProduto);
    }

    /**
     * @param produto
     * @method que percorre a lista e deletar o produto de acordo com o id
     * @param id
     * @return true or false
     */
    public boolean deletar(Produto produto) {
        return this.produtos.remove(produto);
    }
}
