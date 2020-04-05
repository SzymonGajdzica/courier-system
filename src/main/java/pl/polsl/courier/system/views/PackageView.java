package pl.polsl.courier.system.views;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@NoArgsConstructor
@ToString
public class PackageView {

    @NotNull
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private Long clientId;

    private Long carId;

    @NotNull
    private LatLng registerLatLng;

    @NotNull
    private LatLng deliveryLatLng;

    @NotNull
    private Date registerDate;

    private Date startOfDeliveryDate;

    private Date deliveryDate;

}
