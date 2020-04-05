package pl.polsl.courier.system.controllers;

import pl.polsl.courier.system.services.RouteService;
import pl.polsl.courier.system.views.RouteFinishPatch;
import pl.polsl.courier.system.views.RoutePost;
import pl.polsl.courier.system.views.RouteView;

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
    public RouteView createRoute(@Valid @NotNull RoutePost RoutePost) {
        return routeService.createRoute(RoutePost);
    }

    @Path("/{routeId}")
    @PATCH
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public RouteView finishRoute(@PathParam("routeId") Long routeId, @Valid @NotNull RouteFinishPatch routeFinishPatch) {
        return routeService.finishRoute(routeId, routeFinishPatch);
    }

    @Path("/{routeId}")
    @DELETE
    public void deleteRoute(@PathParam("routeId") Long routeId) {
        routeService.deleteRoute(routeId);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<RouteView> getRoutes(@Valid @NotNull @QueryParam("carId") Long carId) {
        return routeService.getRoutes(carId);
    }

    @Path("/{routeId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public RouteView getRoute(@PathParam("routeId") Long RouteId) {
        return routeService.getRoute(RouteId);
    }

}
