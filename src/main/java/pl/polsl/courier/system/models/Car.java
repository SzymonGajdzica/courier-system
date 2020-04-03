package pl.polsl.courier.system.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.LinkedList;
import java.util.List;

@Table(name = "cars")
@Entity
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@Data
@NoArgsConstructor
public class Car extends IdEntity {

    @Column(name = "name", nullable = false)
    @NotNull
    private String name;

    @Column(name = "available", nullable = false)
    @NotNull
    private Boolean available = true;

    @Column(name = "in_use", nullable = false)
    @NotNull
    private Boolean inUse = false;

    @Column(name = "latitude", nullable = false)
    @NotNull
    private Double latitude;

    @Column(name = "longitude", nullable = false)
    @NotNull
    private Double longitude;

    @OneToMany(mappedBy = "car")
    private List<Package> packages = new LinkedList<>();

}
