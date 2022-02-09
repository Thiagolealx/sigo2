package br.gov.pb.codata.sigo2.web.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.pb.codata.sigo2.domain.Municipio;
import br.gov.pb.codata.sigo2.exception.NotFoundException;
import br.gov.pb.codata.sigo2.service.MunicipioService;
import br.gov.pb.codata.sigo2.web.dto.ResultResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/municipios")
@RequiredArgsConstructor
public class MunicipioController {

    private final MunicipioService service;

    @GetMapping
    public List<Municipio> findAll() {
        return service.findAll();
    }

    @GetMapping("{id}")
    public ResultResponse<Municipio> findOne(@PathVariable long id) {
        var result = service.findById(id).orElseThrow(NotFoundException::new);
        return new ResultResponse<>(result);
    }

    @PostMapping
    public ResultResponse<Municipio> create(@RequestBody Municipio dto) {
        var result = service.save(dto);
        return new ResultResponse<>(result);
    }

    @DeleteMapping("{id}")
    public ResultResponse<Boolean> delete(@PathVariable long id) {
        service.deleteById(id);
        return new ResultResponse<>(true);
    }
}
