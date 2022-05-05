package br.com.lojagamer.vendas.view.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class VendaModeloRequest {
    
    @NotBlank(message = "O nome do produto deve possuir caracteres não brancos")
    @NotEmpty(message = "O nome deve ser preenchido")
    @Size(min = 5, message = "O nome deve ter, no mínimo, 5 caracteres")
    private String produto_vendido;

    @NotBlank(message = "A data deve possuir caracteres não brancos(Formato da data dd/mm/yyyy)")
    @NotEmpty(message = "O data deve ser preenchida")
    private String data_venda;

    @NotBlank(message = "O quantiade vendida deve possuir caracteres não brancos")
    @NotEmpty(message = "O quantidade vendida deve ser preenchida")
    private double quantidadeVendida;

    public String getProduto_vendido() {
        return produto_vendido;
    }

    public void setProduto_vendido(String produto_vendido) {
        this.produto_vendido = produto_vendido;
    }

    public String getData_venda() {
        return data_venda;
    }

    public void setData_venda(String data_venda) {
        this.data_venda = data_venda;
    }

    public double getQuantidadeVendida() {
        return quantidadeVendida;
    }

    public void setQuantidadeVendida(double quantidadeVendida) {
        this.quantidadeVendida = quantidadeVendida;
    }

    
    
}
