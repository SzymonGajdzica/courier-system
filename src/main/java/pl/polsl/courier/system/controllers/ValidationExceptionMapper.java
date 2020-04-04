package pl.polsl.courier.system.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ValidationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ValidationExceptionMapper extends CustomExceptionMapper implements ExceptionMapper<ValidationException> {

    @Context
    private HttpServletRequest servletRequest;

    @Override
    public Response toResponse(ValidationException exception) {
        return getResponse(exception, servletRequest, Response.Status.BAD_REQUEST.getStatusCode());
    }

}