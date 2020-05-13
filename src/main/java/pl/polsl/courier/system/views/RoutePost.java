package pl.polsl.courier.system.views;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@ToString
public class RoutePost {

    @NotNull
    private Long startPlaceId;

    @NotNull
    private Long endPlaceId;

}
