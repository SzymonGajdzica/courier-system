package pl.polsl.courier.system.exceptions;

import javax.ejb.ApplicationException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

@ApplicationException
public class BadRequestException extends WebApplicationException {

    public BadRequestException(String message) {
        super(message, Response.Status.BAD_REQUEST);
    }

}
