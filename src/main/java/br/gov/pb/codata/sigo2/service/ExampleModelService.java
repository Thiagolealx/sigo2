package br.gov.pb.codata.sigo2.service;

import br.gov.pb.codata.sigo2.domain.ExampleModel;
import br.gov.pb.codata.sigo2.repository.ExampleModelRepository;

import org.springframework.stereotype.Service;

@Service
public class ExampleModelService extends AbstractService<ExampleModel, Integer, ExampleModelRepository> {
    @Override
    public ExampleModel save(ExampleModel entity) {
        entity.getRelated().forEach(s -> s.setParent(entity));
        return super.save(entity);
    }
}
