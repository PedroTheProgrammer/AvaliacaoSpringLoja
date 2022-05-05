package br.com.lojagamer.produtos.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.lojagamer.produtos.model.Produto;

public interface ProdutoRepository extends MongoRepository<Produto, String> {
    
}
