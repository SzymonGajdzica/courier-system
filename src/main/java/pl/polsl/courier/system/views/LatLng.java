package pl.polsl.courier.system.views;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LatLng {

    @Max(90)
    @Min(-90)
    @NotNull
    private Double latitude;

    @Max(180)
    @Min(-180)
    @NotNull
    private Double longitude;

}
