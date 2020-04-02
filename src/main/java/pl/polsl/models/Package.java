package pl.polsl.models;

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

    @Column(name = "register_date", nullable = false)
    @NonNull
    private Date registerDate = new Date();

    @Column(name = "start_of_delivery_date")
    private Date startOfDeliveryDate;

    @Column(name = "delivery_date")
    private Date deliveryDate;

    @ManyToOne
    private Client client;

    @ManyToOne
    private Car car;

}
