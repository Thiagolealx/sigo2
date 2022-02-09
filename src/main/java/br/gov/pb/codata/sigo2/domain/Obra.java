package br.gov.pb.codata.sigo2.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.gov.pb.codata.sigo2.domain.behavior.Identifiable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_obra")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = {"id", "nome"})
public class Obra implements Identifiable<Long> {
    
	@Id
	@Column( name = "id", updatable = false, unique = true )
	@SequenceGenerator( name = "obra_seq_generator", sequenceName = "seq_obra", allocationSize = 1 )
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "obra_seq_generator" )
	private Long id;
	
	@Column(name = "tipo_obra")
	private Long tipoObra;
	
	@Column(name = "categoria_obra")
	private Long categoriaObra;
	
	@Column(name = "unidade_medida")
	private Long unidadeMedida;
	
	@Column(name = "situacao")
	private Long situacao;
	
	private String nome;
	
	@Column(name = "matricula_cei")
	private Long matriculaCei;
	
	@Column(name = "dimensao_inicial")
	private Double dimensaoInicial;
	
	@Column(name = "data_inicio")
	private LocalDate dataInicio;
	
	@Column(name = "data_prevista_conclusao")
	private LocalDate dataPrevistaConclusao;
	
	@Column(name = "perc_fisico_executado")
	private Double percFisicoExecutado;
	
	@Column(name = "data_ultimo_registro_execucao")
	private LocalDate dataUltimoRegistroExecucao;
	
	private String logradouro;
	
	private String bairro;
	
	private Long cep;
	
	@Column(name = "referencia_endereco")
	private String referenciaEndereco;
	
	@Column(name = "valor_inicial")
	private Double valorInicial;
	
	@Column(name = "forma_georeferenciamento")
	private Long formaGeoreferenciamento;
	
	@Column(name = "georeferenciamento_atual")
	private String georeferenciamentoAtual;
	
	@Column(name = "data_ordem_servico")
	private LocalDate dataOrdemServico;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_complexo")
	private Complexo complexo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_municipio")
	private Municipio municipio;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_orgao_executor")
	private Orgao orgaoExecutor;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_orgao_demandante")
	private Orgao orgaoDemandante;
}
