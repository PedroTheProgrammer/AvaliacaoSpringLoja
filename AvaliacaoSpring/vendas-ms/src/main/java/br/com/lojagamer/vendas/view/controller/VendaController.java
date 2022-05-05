package br.com.lojagamer.vendas.view.controller;

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

import br.com.lojagamer.vendas.service.VendaService;
import br.com.lojagamer.vendas.compartilhado.VendaDto;
import br.com.lojagamer.vendas.view.model.VendaModeloRequest;
import br.com.lojagamer.vendas.view.model.VendaResponse;

@RestController
@RequestMapping("/api/produtos")
public class VendaController {

    @Autowired
    private VendaService servico;
    ModelMapper mapperVenda = new ModelMapper();

    @GetMapping
    public ResponseEntity<List<VendaResponse>> obterVendas() {
        List<VendaDto> VendDto = servico.obterVendas();
        List<VendaResponse> VenResponse = VendDto.stream()
        .map(d -> mapperVenda.map(d, VendaResponse.class))
        .collect(Collectors.toList());

        return new ResponseEntity<>(VenResponse, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<VendaResponse> criarProduto(@RequestBody VendaModeloRequest VendaRequest) {
        VendaDto Vdto = mapperVenda.map(VendaRequest, VendaDto.class);
        Vdto = servico.criarVenda(Vdto);
        VendaResponse responseVenda = mapperVenda.map(Vdto, VendaResponse.class);
        return new ResponseEntity<>(responseVenda, HttpStatus.CREATED);
    }
    
    @GetMapping(value="/{id2}")
    public ResponseEntity<VendaResponse> obterPorId(@PathVariable String id) {
        Optional<VendaDto> vendaDto = servico.obterPorId(id);

        if(vendaDto.isPresent()) {
            VendaResponse VenResponse = mapperVenda.map(vendaDto.get(), VendaResponse.class);
            return new ResponseEntity<>(VenResponse, HttpStatus.FOUND);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<VendaResponse> atualizarVenda(@PathVariable String id, @RequestBody VendaModeloRequest request) {
        VendaDto VendaDto = mapperVenda.map(request, VendaDto.class);
        VendaDto = servico.atualizarVenda(id, VendaDto);
        VendaResponse response = mapperVenda.map(VendaDto,VendaResponse.class);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<String> removerProduto(@PathVariable String id) {
        servico.removerVenda(id);
        return new ResponseEntity<String>("Removido com sucesso!", HttpStatus.OK);
    }
}