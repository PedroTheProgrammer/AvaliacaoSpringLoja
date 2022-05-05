package br.com.lojagamer.vendas.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lojagamer.vendas.model.Venda;
import br.com.lojagamer.vendas.repository.VendaRepository;
import br.com.lojagamer.vendas.compartilhado.VendaDto;

@Service
public class VendaServiceImpl implements VendaService {

    @Autowired
    private VendaRepository repositorio;
    ModelMapper VendaMapper = new ModelMapper();

    @Override
    public VendaDto criarVenda(VendaDto vendaDto) {
        Venda venda = VendaMapper.map(vendaDto, Venda.class);
        venda = repositorio.save(venda);
        VendaDto dtoVenda = VendaMapper.map(venda, VendaDto.class);
        return dtoVenda;
    }

    @Override
    public List<VendaDto> obterVendas() {
        List<Venda> Vendas = repositorio.findAll();
        List<VendaDto> VendasDto = Vendas.stream()
        .map(m -> VendaMapper.map(m, VendaDto.class))
        .collect(Collectors.toList());
        return VendasDto;
    }

    @Override
    public Optional<VendaDto> obterPorId(String id) {
        Optional<Venda> venda = repositorio.findById(id);

        if(venda.isPresent()) {
            VendaDto vendaDto = VendaMapper.map(venda.get(), VendaDto.class);
            return Optional.of(vendaDto);
        }
        return Optional.empty();
    }

    @Override
    public VendaDto atualizarVenda(String id, VendaDto vendaDto) {
        Venda VenDto = VendaMapper.map(vendaDto, Venda.class);

        VenDto.setId(id);
        VenDto = repositorio.save(VenDto);

       VendaDto dtoVen =VendaMapper.map(vendaDto, VendaDto.class);
        return dtoVen;
    }

    @Override
    public void removerVenda(String id) {
        repositorio.deleteById(id);
    }
}
