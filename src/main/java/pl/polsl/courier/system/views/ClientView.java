package pl.polsl.courier.system.views;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class ClientView {

    @NonNull
    private Long id;

    @NonNull
    private String name;

}
