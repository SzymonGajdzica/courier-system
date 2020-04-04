package pl.polsl.courier.system.exceptions;

import javax.ejb.ApplicationException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

@ApplicationException
public class NotFoundException extends WebApplicationException {

    public NotFoundException(Class<?> entityClass, Long primaryId) {
        super("'" + entityClass.getSimpleName() + "' with id '" + primaryId + "' not found", Response.Status.NOT_FOUND);
    }

}
