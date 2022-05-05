package br.com.lojagamer.produtos.view.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class ProdutoModeloRequest {
    
    @NotBlank(message = "O nome do produto deve possuir caracteres não brancos")
    @NotEmpty(message = "O nome deve ser preenchido")
    @Size(min = 5, message = "O nome deve ter, no mínimo, 5 caracteres")
    private String nome;

    @NotBlank(message = "O codigo deve possuir caracteres não brancos")
    @NotEmpty(message = "O codigo deve ser preenchido")
    private String codigo;

    @NotBlank(message = "O valor deve possuir caracteres não brancos")
    @NotEmpty(message = "O valor deve ser preenchido")
    private double valor;

    @NotBlank(message = "A quantidade no estoque deve possuir caracteres não brancos")
    @NotEmpty(message = "A quantidade deve ser preenchida")
    private int qtdEstoque;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    public int getQtdEstoque() {
        return qtdEstoque;
    }
    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }
}
