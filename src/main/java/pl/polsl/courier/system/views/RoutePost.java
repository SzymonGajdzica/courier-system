package pl.polsl.courier.system.views;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@ToString
public class RoutePost {

    @Valid
    @NotNull
    private LatLng startLatLng;

    @NotNull
    private Long carId;

}
