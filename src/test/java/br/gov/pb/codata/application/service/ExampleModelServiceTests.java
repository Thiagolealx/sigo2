package br.gov.pb.codata.application.service;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.gov.pb.codata.sigo2.domain.ExampleModel;
import br.gov.pb.codata.sigo2.domain.ExampleRelatedModel;
import br.gov.pb.codata.sigo2.service.ExampleModelService;

@SpringBootTest
public class ExampleModelServiceTests {

    @Autowired
    private ExampleModelService exampleModelService;

    @Test
    public void addProject() {
        var model = new ExampleModel("Example 1");
        model.setDescription("Description 1");
        exampleModelService.save(model);
        assertThat(model.getId()).isNotNull();
    }

    @Test
    public void addProjectWithSteps() {
        var model = new ExampleModel("Example 1");
        model.getRelated().add(new ExampleRelatedModel("Related 1", model));
        model.getRelated().add(new ExampleRelatedModel("Related 2", model));

        var saved = exampleModelService.save(model);
        assertThat(saved.getRelated()).hasSize(2);
    }
}
