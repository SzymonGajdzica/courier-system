package pl.polsl.courier.system.views;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@ToString
public class CarView {

    @NotNull
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private Boolean available;

    @NotNull
    private Boolean inUse;

    @NotNull
    private LatLng latLng;

}
