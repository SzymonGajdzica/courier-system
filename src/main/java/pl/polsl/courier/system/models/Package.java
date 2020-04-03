package pl.polsl.courier.system.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Table(name = "packages")
@Entity
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@Data
@NoArgsConstructor
public class Package extends IdEntity {

    @Column(name = "name", nullable = false)
    @NotNull
    private String name;

    @Column(name = "weight")
    private Double weight;

    @ManyToOne(optional = false)
    @NotNull
    private Client client;

    @ManyToOne
    private Car car;

    @Column(name = "register_latitude", nullable = false)
    @NotNull
    private Double registerLatitude;

    @Column(name = "register_longitude", nullable = false)
    @NotNull
    private Double registerLongitude;

    @Column(name = "register_date", nullable = false)
    @NotNull
    private Date registerDate = new Date();

    @Column(name = "start_of_delivery_date")
    private Date startOfDeliveryDate;

    @Column(name = "delivery_latitude", nullable = false)
    @NotNull
    private Double deliveryLatitude;

    @Column(name = "delivery_longitude", nullable = false)
    @NotNull
    private Double deliveryLongitude;

    @Column(name = "delivery_date")
    private Date deliveryDate;

}
