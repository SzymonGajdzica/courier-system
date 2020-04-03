package pl.polsl.courier.system.views;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class ClientPatch {

    private String name;

    private String secondName;

    private String surname;

    private String email;

    private String phoneNumber;

}
