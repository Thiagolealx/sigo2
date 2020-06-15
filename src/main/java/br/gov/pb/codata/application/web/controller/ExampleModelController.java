package br.gov.pb.codata.application.web.controller;

import br.gov.pb.codata.application.domain.ExampleModel;
import br.gov.pb.codata.application.exception.NotFoundException;
import br.gov.pb.codata.application.service.ExampleModelService;
import br.gov.pb.codata.application.web.dto.ResultResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/example")
@RequiredArgsConstructor
public class ExampleModelController {

    private final ExampleModelService service;

    @GetMapping
    public List<ExampleModel> findAll() {
        return service.findAll();
    }

    @GetMapping("{id}")
    public ResultResponse<ExampleModel> findOne(@PathVariable int id) {
        var result = service.findById(id).orElseThrow(NotFoundException::new);
        return new ResultResponse<>(result);
    }

    @PostMapping
    public ResultResponse<ExampleModel> create(@RequestBody ExampleModel dto) {
        var result = service.save(dto);
        return new ResultResponse<>(result);
    }

    @PutMapping("{id}")
    public ResultResponse<ExampleModel> update(@PathVariable int id, @RequestBody ExampleModel dto) {
        var model = service.findById(id).orElseThrow(NotFoundException::new);

        model.setName(dto.getName());
        model.setDescription(dto.getDescription());
        var result = service.save(model);
        return new ResultResponse<>(result);
    }

    @DeleteMapping("{id}")
    public ResultResponse<Boolean> delete(@PathVariable int id) {
        service.deleteById(id);
        return new ResultResponse<>(true);
    }
}
