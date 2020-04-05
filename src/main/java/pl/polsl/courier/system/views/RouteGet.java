package pl.polsl.courier.system.views;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@NoArgsConstructor
@ToString
public class RouteGet {

    @NotNull
    private Date startDate;

    @NotNull
    private LatLng startLatLng;

    private LatLng endLatLng;

    private Date endDate;

    @NotNull
    private Long carId;

}
