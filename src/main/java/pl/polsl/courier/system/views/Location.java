package pl.polsl.courier.system.views;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Location {

    @NotNull
    private Double latitude;

    @NotNull
    private Double longitude;

}
