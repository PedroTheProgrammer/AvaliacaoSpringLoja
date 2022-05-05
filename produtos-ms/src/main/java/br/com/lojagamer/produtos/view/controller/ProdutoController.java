package br.com.lojagamer.produtos.view.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lojagamer.produtos.service.ProdutoService;
import br.com.lojagamer.produtos.compartilhado.ProdutoDto;
import br.com.lojagamer.produtos.view.model.ProdutoModeloRequest;
import br.com.lojagamer.produtos.view.model.ProdutoResponse;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService servico;
    ModelMapper mapperProduto = new ModelMapper();

    @GetMapping
    public ResponseEntity<List<ProdutoResponse>> obterProdutos() {
        List<ProdutoDto> ProduDto = servico.obterProdutos();
        List<ProdutoResponse> ProdResponse = ProduDto.stream()
        .map(d -> mapperProduto.map(d, ProdutoResponse.class))
        .collect(Collectors.toList());

        return new ResponseEntity<>(ProdResponse, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProdutoResponse> criarProduto(@RequestBody ProdutoModeloRequest ProdutoRequest) {
        ProdutoDto Pdto = mapperProduto.map(ProdutoRequest, ProdutoDto.class);
        Pdto = servico.criarProduto(Pdto);
        ProdutoResponse responseMusic = mapperProduto.map(Pdto, ProdutoResponse.class);
        return new ResponseEntity<>(responseMusic, HttpStatus.CREATED);
    }
    
    @GetMapping(value="/{id2}")
    public ResponseEntity<ProdutoResponse> obterPorId(@PathVariable String id) {
        Optional<ProdutoDto> produtoDto = servico.obterPorId(id);

        if(produtoDto.isPresent()) {
            ProdutoResponse ProdResponse = mapperProduto.map(produtoDto.get(), ProdutoResponse.class);
            return new ResponseEntity<>(ProdResponse, HttpStatus.FOUND);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<ProdutoResponse> atualizarProduto(@PathVariable String id, @RequestBody ProdutoModeloRequest request) {
        ProdutoDto ProdutoDto = mapperProduto.map(request, ProdutoDto.class);
        ProdutoDto = servico.atualizarProduto(id, ProdutoDto);
        ProdutoResponse response = mapperProduto.map(ProdutoDto, ProdutoResponse.class);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<String> removerProduto(@PathVariable String id) {
        servico.removerProduto(id);
        return new ResponseEntity<String>("Removido com sucesso!", HttpStatus.OK);
    }
}