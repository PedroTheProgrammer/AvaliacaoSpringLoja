package br.com.lojagamer.vendas.view.model;

public class VendaResponse {
    
    private String produto_vendido;
    private double quantidadeVendida;
    
    public String getProduto_vendido() {
        return produto_vendido;
    }
    public void setProduto_vendido(String produto_vendido) {
        this.produto_vendido = produto_vendido;
    }
    public double getQuantidadeVendida() {
        return quantidadeVendida;
    }
    public void setQuantidadeVendida(double quantidadeVendida) {
        this.quantidadeVendida = quantidadeVendida;
    }

}
