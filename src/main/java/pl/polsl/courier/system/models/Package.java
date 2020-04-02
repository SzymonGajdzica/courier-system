package pl.polsl.courier.system.models;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "packages")
@Entity
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@Data
@NoArgsConstructor
@ToString
public class Package extends IdEntity {

    @Column(name = "name", nullable = false)
    @NonNull
    private String name;

    @Column(name = "weight")
    private Double weight;

    @ManyToOne(optional = false)
    @NonNull
    private Client client;

    @ManyToOne
    private Car car;

    @Column(name = "register_latitude", nullable = false)
    @NonNull
    private Double registerLatitude;

    @Column(name = "register_longitude", nullable = false)
    @NonNull
    private Double registerLongitude;

    @Column(name = "register_date", nullable = false)
    @NonNull
    private Date registerDate = new Date();

    @Column(name = "start_of_delivery_date")
    private Date startOfDeliveryDate;

    @Column(name = "delivery_latitude", nullable = false)
    @NonNull
    private Double deliveryLatitude;

    @Column(name = "delivery_longitude", nullable = false)
    @NonNull
    private Double deliveryLongitude;

    @Column(name = "delivery_date")
    private Date deliveryDate;

}
