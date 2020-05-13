package pl.polsl.courier.system.controllers;

import pl.polsl.courier.system.services.CarService;
import pl.polsl.courier.system.views.CarGet;
import pl.polsl.courier.system.views.CarPatch;
import pl.polsl.courier.system.views.CarPost;

import javax.ejb.EJB;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/car")
public class CarController {

    @EJB
    private CarService carService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public CarGet createCar(@Valid @NotNull CarPost CarPost) {
        return carService.createCar(CarPost);
    }

    @Path("/{carId}")
    @PATCH
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public CarGet updateCar(@PathParam("carId") Long carId, @Valid @NotNull CarPatch carPatch) {
        return carService.patchCar(carId, carPatch);
    }

    @Path("/{carId}")
    @DELETE
    public void deleteCar(@PathParam("carId") Long carId) {
        carService.deleteCar(carId);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CarGet> getCars() {
        return carService.getCars();
    }

}
