package br.gov.pb.codata.sigo2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import br.gov.pb.codata.sigo2.domain.ExampleRelatedModel;

import java.util.Optional;

public interface ExampleRelatedModelRepository extends JpaRepository<ExampleRelatedModel, Integer> {
    Optional<ExampleRelatedModel> findByIdAndParentId(int id, int parentId);
}
