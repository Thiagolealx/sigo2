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
@Table(name = "tb_complexo")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = {"id", "descricao"})
public class Complexo implements Identifiable<Long> {
    
	@Id
	@Column( name = "id", updatable = false, unique = true )
	@SequenceGenerator( name = "complexo_seq_generator", sequenceName = "seq_complexo", allocationSize = 1 )
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "complexo_seq_generator" )
	private Long id;
	
	private String descricao;
	
	private Boolean ativo;
}
