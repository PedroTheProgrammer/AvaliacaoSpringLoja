package br.com.lojagamer.vendas.compartilhado;

public class VendaDto {

    private String produto_vendido;
    private String data_Venda;
    private double quantidade_Vendida;

    public String getProduto_vendido() {
        return produto_vendido;
    }
    public void setProduto_vendido(String produto_vendido) {
        this.produto_vendido = produto_vendido;
    }
    public String getData_Venda() {
        return data_Venda;
    }
    public void setData_Venda(String data_Venda) {
        this.data_Venda = data_Venda;
    }
    public double getQuantidade_Vendida() {
        return quantidade_Vendida;
    }
    public void setQuantidade_Vendida(double quantidade_Vendida) {
        this.quantidade_Vendida = quantidade_Vendida;
    }
}
