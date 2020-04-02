package pl.polsl.courier.system.models;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "routes")
@Entity
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@Data
@NoArgsConstructor
@ToString
public class Route extends IdEntity {

    @Column(name = "start_date", nullable = false)
    @NonNull
    private Date startDate = new Date();

    @Column(name = "start_latitude", nullable = false)
    @NonNull
    private Double startLatitude;

    @Column(name = "start_longitude", nullable = false)
    @NonNull
    private Double startLongitude;

    @Column(name = "end_latitude")
    private Double endLatitude;

    @Column(name = "end_longitude")
    private Double endLongitude;

    @Column(name = "end_date")
    private Date endDate;

    @ManyToOne(optional = false)
    @NonNull
    private Car car;

}
