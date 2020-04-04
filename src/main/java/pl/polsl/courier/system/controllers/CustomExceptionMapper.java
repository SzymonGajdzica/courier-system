package pl.polsl.courier.system.controllers;

import pl.polsl.courier.system.views.ErrorMessage;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;

public abstract class CustomExceptionMapper {

    protected Response getResponse(Exception exception, HttpServletRequest servletRequest, int statusCode) {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setException(exception.getClass().getSimpleName());
        errorMessage.setMessage(exception.getMessage());
        errorMessage.setTimestamp(new Date());
        errorMessage.setPath(servletRequest.getRequestURI());
        StringWriter sw = new StringWriter();
        exception.printStackTrace(new PrintWriter(sw));
        errorMessage.setTrace(sw.toString());
        errorMessage.setStatus(statusCode);
        return Response
                .status(statusCode)
                .entity(errorMessage)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }

}
