package br.com.lojagamer.produtos.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lojagamer.produtos.model.Produto;
import br.com.lojagamer.produtos.repository.ProdutoRepository;
import br.com.lojagamer.produtos.compartilhado.ProdutoDto;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository repositorio;
    ModelMapper ProdutoMapper = new ModelMapper();

    @Override
    public ProdutoDto criarProduto(ProdutoDto produtoDto) {
        Produto produto = ProdutoMapper.map(produtoDto, Produto.class);
        produto = repositorio.save(produto);
        ProdutoDto dtoProduto = ProdutoMapper.map(produto, ProdutoDto.class);
        return dtoProduto;
    }

    @Override
    public List<ProdutoDto> obterProdutos() {
        List<Produto> Produtos = repositorio.findAll();
        List<ProdutoDto> ProdutosDto = Produtos.stream()
        .map(m -> ProdutoMapper.map(m, ProdutoDto.class))
        .collect(Collectors.toList());
        return ProdutosDto;
    }

    @Override
    public Optional<ProdutoDto> obterPorId(String id) {
        Optional<Produto> produto = repositorio.findById(id);

        if(produto.isPresent()) {
            ProdutoDto produtoDto = ProdutoMapper.map(produto.get(), ProdutoDto.class);
            return Optional.of(produtoDto);
        }
        return Optional.empty();
    }

    @Override
    public ProdutoDto atualizarProduto(String id, ProdutoDto produtoDto) {
        Produto ProDto = ProdutoMapper.map(produtoDto, Produto.class);

        ProDto.setId(id);
        ProDto = repositorio.save(ProDto);

        ProdutoDto dtoPro = ProdutoMapper.map(produtoDto, ProdutoDto.class);
        return dtoPro;
    }

    @Override
    public void removerProduto(String id) {
        repositorio.deleteById(id);
    }
}
