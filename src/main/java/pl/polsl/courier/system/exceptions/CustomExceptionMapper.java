package pl.polsl.courier.system.exceptions;

import pl.polsl.courier.system.views.ErrorMessage;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.io.PrintWriter;
import java.io.StringWriter;

@Provider
public class CustomExceptionMapper implements ExceptionMapper<WebApplicationException> {

    @Override
    public Response toResponse(WebApplicationException exception) {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setError(exception.getResponse().getStatusInfo().getReasonPhrase());
        errorMessage.setException(exception.getClass().getSimpleName());
        errorMessage.setMessage(exception.getMessage());
        errorMessage.setPath(exception.getResponse().getLocation().getPath());
        errorMessage.setStatus(exception.getResponse().getStatus());
        errorMessage.setTimestamp(exception.getResponse().getDate());
        StringWriter sw = new StringWriter();
        exception.printStackTrace(new PrintWriter(sw));
        errorMessage.setTrace(sw.toString());
        return Response
                .status(exception.getResponse().getStatus())
                .entity(errorMessage)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}
