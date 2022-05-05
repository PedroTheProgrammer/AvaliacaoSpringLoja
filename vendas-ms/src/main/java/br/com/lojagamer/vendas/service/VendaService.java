package br.com.lojagamer.vendas.service;

import java.util.List;
import java.util.Optional;

import br.com.lojagamer.vendas.compartilhado.VendaDto;

public interface VendaService {
    VendaDto criarVenda(VendaDto Venda);
    List<VendaDto> obterVendas();
    Optional<VendaDto> obterPorId(String id);
    VendaDto atualizarVenda(String id, VendaDto Venda);
    void removerVenda(String id);
}
