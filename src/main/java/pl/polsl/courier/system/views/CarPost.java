package pl.polsl.courier.system.views;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@ToString
public class CarPost {

    @NotNull
    private String name;

    @Valid
    @NotNull
    private LatLng latLng;

}
