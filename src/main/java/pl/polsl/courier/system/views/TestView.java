package pl.polsl.courier.system.views;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class TestView {

    @NonNull
    private String title;

    @NonNull
    private String description;

}
