package br.gov.pb.codata.sigo2.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.gov.pb.codata.sigo2.domain.behavior.Identifiable;
import br.gov.pb.codata.sigo2.domain.behavior.Timestampable;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "example_model")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(of = {"id", "name"})
@ToString(exclude = {"description", "related"})
public class ExampleModel implements Identifiable<Integer>, Timestampable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull private String name;

    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "parent", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<ExampleRelatedModel> related = new ArrayList<>();

    @Column(insertable = false, updatable = false)
    public LocalDateTime createdAt;

    @Column(insertable = false, updatable = false)
    public LocalDateTime updatedAt;
}
