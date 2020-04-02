package pl.polsl.views;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class ClientPost {

    @NonNull
    private String name;

}
