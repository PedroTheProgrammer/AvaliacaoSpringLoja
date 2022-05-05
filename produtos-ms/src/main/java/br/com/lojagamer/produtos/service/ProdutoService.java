package br.com.lojagamer.produtos.service;

import java.util.List;
import java.util.Optional;

import br.com.lojagamer.produtos.compartilhado.ProdutoDto;

public interface ProdutoService {
    ProdutoDto criarProduto(ProdutoDto produto);
    List<ProdutoDto> obterProdutos();
    Optional<ProdutoDto> obterPorId(String id);
    ProdutoDto atualizarProduto(String id, ProdutoDto produto);
    void removerProduto(String id);
}
