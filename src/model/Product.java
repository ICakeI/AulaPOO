package model;

public class Product {
    private int code;
    private String nome;
    private String descricao;
    private double quantidade;
    private double preco;

    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return  "Código = " + code + "\n" +
                "Nome = " + nome + "\n" +
                "Descrição = " + descricao + "\n" +
                "Quantidade = " + quantidade +  "\n" +
                "Preço unitário = " + preco + "\n";
    }

    public String total(){
        return  "Código = " + code + "\n" +
                "Nome = " + nome + "\n" +
                "Descrição = " + descricao + "\n" +
                "Quantidade = " + quantidade +  "\n" +
                "Preço unitário = " + preco + "\n" +
                "Preço total em estoque = " + (preco * quantidade) + "\n";
    }

    public boolean addProduto(double qtd){
        if(qtd > 0){
            quantidade += qtd;
            return true;
            }
            return false;
        }

    public boolean reduce(double qtd){
        if(quantidade <= qtd){
            qtd -= quantidade;
            return true;
            }
            return false;
        }

    }
