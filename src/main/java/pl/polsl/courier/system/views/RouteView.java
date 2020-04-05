package pl.polsl.courier.system.views;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@NoArgsConstructor
@ToString
public class RouteView {

    @NotNull
    private Long id;

    @NotNull
    private Date startDate;

    @NotNull
    private LatLng startLatLng;

    private Date endDate;

    private LatLng endLatLng;

    private Long carId;

}
