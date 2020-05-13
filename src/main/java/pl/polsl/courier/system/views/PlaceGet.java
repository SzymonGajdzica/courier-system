package pl.polsl.courier.system.views;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@ToString
public class PlaceGet {

    @NotNull
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private LatLng latLng;

}
