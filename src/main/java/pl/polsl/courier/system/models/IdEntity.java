package pl.polsl.courier.system.models;

import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@EqualsAndHashCode
@MappedSuperclass
@Data
@NoArgsConstructor
@ToString
public abstract class IdEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NonNull
    private Long id;

}
