package pl.polsl.courier.system.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class WebApplicationExceptionMapper extends CustomExceptionMapper implements ExceptionMapper<WebApplicationException> {

    @Context
    private HttpServletRequest servletRequest;

    @Override
    public Response toResponse(WebApplicationException exception) {
        return getResponse(exception, servletRequest, exception.getResponse().getStatus());
    }

}
