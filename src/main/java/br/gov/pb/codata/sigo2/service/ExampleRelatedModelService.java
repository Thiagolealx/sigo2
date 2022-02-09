package br.gov.pb.codata.sigo2.service;

import br.gov.pb.codata.sigo2.domain.ExampleRelatedModel;
import br.gov.pb.codata.sigo2.repository.ExampleRelatedModelRepository;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExampleRelatedModelService extends AbstractService<ExampleRelatedModel, Integer, ExampleRelatedModelRepository> {
    public Optional<ExampleRelatedModel> findByParentId(int parentId, int id) {
        return repository.findByIdAndParentId(id, parentId);
    }
}
