package pl.polsl.courier.system.models;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.LinkedList;
import java.util.List;

@Table(name = "clients")
@Entity
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@Data
@NoArgsConstructor
@ToString
public class Client extends IdEntity {

    @Column(name = "name", nullable = false)
    @NonNull
    private String name;

    @Column(name = "second_name")
    private String secondName;

    @Column(name = "surname", nullable = false)
    @NonNull
    private String surname;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number", nullable = false, unique = true)
    private String phoneNumber;

    @OneToMany(mappedBy = "client")
    private List<Package> packages = new LinkedList<>();

}
