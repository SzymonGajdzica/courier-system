package pl.polsl.courier.system.views;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.Valid;

@Data
@NoArgsConstructor
@ToString
public class CarPatch {

    private String name;

    @Valid
    private LatLng latLng;

    private Boolean available;

    private Boolean inUse;

}
