package br.gov.pb.codata.application.web.controller;

import br.gov.pb.codata.application.domain.ExampleRelatedModel;
import br.gov.pb.codata.application.exception.NotFoundException;
import br.gov.pb.codata.application.service.ExampleModelService;
import br.gov.pb.codata.application.service.ExampleRelatedModelService;
import br.gov.pb.codata.application.web.dto.ResultResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/example/{parentId}/related")
@RequiredArgsConstructor
public class ExampleRelatedModelController {

    private ExampleRelatedModelService service;
    private ExampleModelService exampleModelService;

    @GetMapping
    public List<ExampleRelatedModel> findAll(@PathVariable int parentId) {
        var model = exampleModelService.findById(parentId).orElseThrow(NotFoundException::new);
        return model.getRelated();
    }

    @GetMapping("{id}")
    public ResultResponse<ExampleRelatedModel> findOne(@PathVariable int parentId, @PathVariable int id) {
        var result = service.findByParentId(parentId, id).orElseThrow(NotFoundException::new);
        return new ResultResponse<>(result);
    }

    @PostMapping
    public ResultResponse<ExampleRelatedModel> create(@PathVariable int parentId, @RequestBody ExampleRelatedModel dto) {
        var project = exampleModelService.findById(parentId).orElseThrow(NotFoundException::new);

        dto.setParent(project);
        var result = service.save(dto);
        return new ResultResponse<>(result);
    }

    @PutMapping("{id}")
    public ResultResponse<ExampleRelatedModel> update(@PathVariable int parentId, @PathVariable int id, @RequestBody ExampleRelatedModel dto) {
        var step = service.findByParentId(parentId, id).orElseThrow(NotFoundException::new);

        step.setName(dto.getName());
        step.setDescription(dto.getDescription());

        var result = service.save(step);
        return new ResultResponse<>(result);
    }

    @DeleteMapping("{id}")
    public ResultResponse<Boolean> delete(@PathVariable int parentId, @PathVariable int id) {
        var step = service.findByParentId(parentId, id).orElseThrow(NotFoundException::new);
        service.delete(step);
        return new ResultResponse<>(true);
    }
}
