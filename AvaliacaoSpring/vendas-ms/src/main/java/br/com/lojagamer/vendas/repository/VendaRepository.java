package br.com.lojagamer.vendas.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.lojagamer.vendas.model.Venda;

public interface VendaRepository extends MongoRepository<Venda, String> {
    
}
