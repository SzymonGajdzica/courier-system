package pl.polsl.courier.system.views;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@ToString
public class PackagePost {

    @NotNull
    private String name;

    @NotNull
    private Long clientId;

    @NotNull
    private Location registerLocation;

    @NotNull
    private Location deliveryLocation;

}
