package br.gov.pb.codata.application.domain;

import br.gov.pb.codata.application.domain.behavior.Identifiable;
import br.gov.pb.codata.application.domain.behavior.Timestampable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "example_related_model")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(of = "name")
@ToString(exclude = {"parent", "description"})
public class ExampleRelatedModel implements Identifiable<Integer>, Timestampable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull private String name;
    private String description;

    @NonNull
    @JsonIgnore
    @ManyToOne
    private ExampleModel parent;

    @Column(insertable = false, updatable = false)
    public LocalDateTime createdAt;

    @Column(insertable = false, updatable = false)
    public LocalDateTime updatedAt;
}
