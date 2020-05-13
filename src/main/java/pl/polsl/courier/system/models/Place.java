package pl.polsl.courier.system.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.LinkedList;
import java.util.List;

@Table(name = "places")
@Entity
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@Data
@NoArgsConstructor
@ToString
public class Place extends IdEntity {

    @Column(name = "name", nullable = false)
    @NotNull
    private String name;

    @Column(name = "latitude", nullable = false)
    @NotNull
    private Double latitude;

    @Column(name = "longitude", nullable = false)
    @NotNull
    private Double longitude;

    @OneToMany(mappedBy = "startPlace")
    private List<Route> startRoutes = new LinkedList<>();

    @OneToMany(mappedBy = "endPlace")
    private List<Route> endRoutes = new LinkedList<>();

}
