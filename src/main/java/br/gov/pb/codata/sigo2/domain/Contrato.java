package br.gov.pb.codata.sigo2.domain;

import br.gov.pb.codata.sigo2.domain.behavior.Identifiable;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tb_contrato")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = {"id","registroCge"})
public class Contrato  implements Identifiable<Long> {

    @Id
    @Column( name = "id", updatable = false, unique = true )
    @SequenceGenerator( name = "obra_seq_generator", sequenceName = "seq_obra", allocationSize = 1 )
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "obra_seq_generator" )
    private Long id;

    @NonNull
    @Column(name = "registro_cge")
    private String registroCge;

    private String objeto;

    private Integer exercicio;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "data_inicio_vigencia")
    private LocalDate dataInicioVigencia;

    @NonNull
    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "data_fim_vigencia")
    private LocalDate dataFimVigencia;

    @Column(name = "valor_contrato")
    private Double valorContrato;

    @Column(name = "valor_atual")
    private Double valorAtual;

    @Column(name = "contrato_orgao")
    private String contratoOrgao;

    @NonNull
    @Column(name = "valor_aditivos")
    private Double valorAditivos;

    @NonNull
    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "data_fim_vigencia_aditivos")
    private LocalDate dataFimVigenciaAditivo;

    @Column(name = "modalidade_licitacao")
    private Integer modalidadeLicitacao;

    
}
