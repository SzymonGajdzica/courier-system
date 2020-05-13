package pl.polsl.courier.system.controllers;

import pl.polsl.courier.system.services.RouteService;
import pl.polsl.courier.system.views.RouteGet;
import pl.polsl.courier.system.views.RoutePost;

import javax.ejb.EJB;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/route")
public class RouteController {

    @EJB
    private RouteService routeService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public RouteGet createRoute(@Valid @NotNull RoutePost RoutePost) {
        return routeService.createRoute(RoutePost);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<RouteGet> getRoutes() {
        return routeService.getRoutes();
    }

}
