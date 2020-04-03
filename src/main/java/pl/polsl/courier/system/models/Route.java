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

@Table(name = "routes")
@Entity
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@Data
@NoArgsConstructor
public class Route extends IdEntity {

    @Column(name = "start_date", nullable = false)
    @NotNull
    private Date startDate = new Date();

    @Column(name = "start_latitude", nullable = false)
    @NotNull
    private Double startLatitude;

    @Column(name = "start_longitude", nullable = false)
    @NotNull
    private Double startLongitude;

    @Column(name = "end_latitude")
    private Double endLatitude;

    @Column(name = "end_longitude")
    private Double endLongitude;

    @Column(name = "end_date")
    private Date endDate;

    @ManyToOne(optional = false)
    @NotNull
    private Car car;

}
