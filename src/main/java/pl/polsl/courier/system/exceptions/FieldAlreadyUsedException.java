package pl.polsl.courier.system.exceptions;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

public class FieldAlreadyUsedException extends WebApplicationException {

    public FieldAlreadyUsedException(String parameterName, String parameterValue) {
        super("Parameter " + parameterName + " with value " + parameterValue + " already exists in database", Response.Status.CONFLICT);
    }

}
