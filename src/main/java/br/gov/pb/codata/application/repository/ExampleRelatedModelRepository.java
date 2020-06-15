package br.gov.pb.codata.application.repository;

import br.gov.pb.codata.application.domain.ExampleRelatedModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.Optional;

public interface ExampleRelatedModelRepository extends JpaRepository<ExampleRelatedModel, Integer> {
    Optional<ExampleRelatedModel> findByIdAndParentId(int id, int parentId);
}
