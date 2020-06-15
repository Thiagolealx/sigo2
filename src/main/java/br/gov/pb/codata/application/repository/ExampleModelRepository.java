package br.gov.pb.codata.application.repository;

import br.gov.pb.codata.application.domain.ExampleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ExampleModelRepository extends JpaRepository<ExampleModel, Integer> {}
