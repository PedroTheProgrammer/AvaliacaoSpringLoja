package br.com.lojagamer.produtos.compartilhado;

public class Venda {

    private String id;
    private String produto_vendido;
    private String data_vendida;
    private int quantidade_vendida;
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getProduto_vendido() {
        return produto_vendido;
    }
    public void setProduto_vendido(String produto_vendido) {
        this.produto_vendido = produto_vendido;
    }
    public String getData_vendida() {
        return data_vendida;
    }
    public void setData_vendida(String data_vendida) {
        this.data_vendida = data_vendida;
    }
    public int getQuantidade_vendida() {
        return quantidade_vendida;
    }
    public void setQuantidade_vendida(int quantidade_vendida) {
        this.quantidade_vendida = quantidade_vendida;
    }
    
}
