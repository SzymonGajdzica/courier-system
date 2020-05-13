package pl.polsl.courier.system.controllers;

import pl.polsl.courier.system.services.PlaceService;
import pl.polsl.courier.system.views.PlaceGet;
import pl.polsl.courier.system.views.PlacePost;

import javax.ejb.EJB;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/place")
public class PlaceController {

    @EJB
    private PlaceService placeService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public PlaceGet createPlace(@Valid @NotNull PlacePost PlacePost) {
        return placeService.createPlace(PlacePost);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<PlaceGet> getPlaces() {
        return placeService.getPlaces();
    }

}
