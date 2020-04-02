package pl.polsl.courier.system.models;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.LinkedList;
import java.util.List;

@Table(name = "cars")
@Entity
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@Data
@NoArgsConstructor
@ToString
public class Car extends IdEntity {

    @Column(name = "name", nullable = false)
    @NonNull
    private String name;

    @Column(name = "available", nullable = false)
    @NonNull
    private Boolean available = true;

    @Column(name = "in_use", nullable = false)
    @NonNull
    private Boolean inUse = false;

    @Column(name = "latitude", nullable = false)
    @NonNull
    private Double latitude;

    @Column(name = "longitude", nullable = false)
    @NonNull
    private Double longitude;

    @OneToMany(mappedBy = "car")
    private List<Package> packages = new LinkedList<>();

}
