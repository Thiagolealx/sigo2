package br.gov.pb.codata.sigo2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.pb.codata.sigo2.domain.Obra;

public interface ObraRepository extends JpaRepository<Obra, Long> {}
