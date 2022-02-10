package br.gov.pb.codata.sigo2.domain;

import br.gov.pb.codata.sigo2.domain.behavior.Identifiable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name = "tb_programa")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = {"id", "descricao"})

public class Programa implements Identifiable<Long> {

    @Id
    @Column( name = "id", updatable = false, unique = true )
    @SequenceGenerator( name = "programa_seq_generator", sequenceName = "seq_programa", allocationSize = 1 )
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "programa_seq_generator" )
    private Long id;

    private String descricao;

    private Integer ano;

    private String codigo;

    private Boolean ativo;
}
