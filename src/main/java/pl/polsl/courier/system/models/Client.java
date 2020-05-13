package pl.polsl.courier.system.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.LinkedList;
import java.util.List;

@Table(name = "clients")
@Entity
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@Data
@NoArgsConstructor
public class Client extends IdEntity {

    @Column(name = "name", nullable = false)
    @NotNull
    private String name;

    @Column(name = "surname", nullable = false)
    @NotNull
    private String surname;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number", nullable = false, unique = true)
    @NotNull
    private String phoneNumber;

    @OneToMany(mappedBy = "client", cascade = CascadeType.DETACH)
    @NotNull
    private List<Package> packages = new LinkedList<>();

}
