package pl.polsl.courier.system.views;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@NoArgsConstructor
@ToString
public class ErrorMessage {

    @NotNull
    private String path;

    @NotNull
    private String exception;

    @NotNull
    private Date timestamp;

    @NotNull
    private Integer status;

    @NotNull
    private String error;

    @NotNull
    private String message;

    @NotNull
    private String trace;

}
