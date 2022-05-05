package br.com.lojagamer.vendas.model;

public class Venda {
    
    private String id;
    private String produto_vendido;
    private int data_venvida;
    private int quantidadeVendida;

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
    public int getData_venvida() {
        return data_venvida;
    }
    public void setData_venvida(int data_venvida) {
        this.data_venvida = data_venvida;
    }
    public int getQuantidadeVendida() {
        return quantidadeVendida;
    }
    public void setQuantidadeVendida(int quantidadeVendida) {
        this.quantidadeVendida = quantidadeVendida;
    }
}
