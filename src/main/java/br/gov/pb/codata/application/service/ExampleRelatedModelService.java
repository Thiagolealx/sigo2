package br.gov.pb.codata.application.service;

import br.gov.pb.codata.application.domain.ExampleRelatedModel;
import br.gov.pb.codata.application.repository.ExampleRelatedModelRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExampleRelatedModelService extends AbstractService<ExampleRelatedModel, Integer, ExampleRelatedModelRepository> {
    public Optional<ExampleRelatedModel> findByParentId(int parentId, int id) {
        return repository.findByIdAndParentId(id, parentId);
    }
}
