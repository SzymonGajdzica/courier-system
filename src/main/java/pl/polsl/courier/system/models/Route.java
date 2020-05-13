package pl.polsl.courier.system.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.LinkedList;
import java.util.List;

@Table(name = "routes")
@Entity
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@Data
@NoArgsConstructor
@ToString
public class Route extends IdEntity {

    @ManyToOne
    private Place startPlace;

    @ManyToOne
    private Place endPlace;

    @OneToMany(mappedBy = "route")
    private List<Package> packages = new LinkedList<>();

}
