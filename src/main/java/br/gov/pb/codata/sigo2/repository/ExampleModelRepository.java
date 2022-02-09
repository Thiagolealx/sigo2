package br.gov.pb.codata.sigo2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import br.gov.pb.codata.sigo2.domain.ExampleModel;

public interface ExampleModelRepository extends JpaRepository<ExampleModel, Integer> {}
