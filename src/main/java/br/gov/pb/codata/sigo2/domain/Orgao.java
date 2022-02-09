package br.gov.pb.codata.sigo2.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.gov.pb.codata.sigo2.domain.behavior.Identifiable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_orgao")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = {"id", "nome"})
public class Orgao implements Identifiable<Long> {
    
	@Id
	@Column( name = "id", updatable = false, unique = true )
	@SequenceGenerator( name = "orgao_seq_generator", sequenceName = "seq_orgao", allocationSize = 1 )
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "orgao_seq_generator" )
	private Long id;
	
	private String nome;
	
	private String codigo;
	
	private String sigla;
	
	private Boolean ativo;
}
