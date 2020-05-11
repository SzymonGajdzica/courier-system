package pl.polsl.courier.system.controllers;

import pl.polsl.courier.system.services.CarService;
import pl.polsl.courier.system.views.CarPatch;
import pl.polsl.courier.system.views.CarPost;
import pl.polsl.courier.system.views.CarView;

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
    public CarView createCar(@Valid @NotNull CarPost CarPost) {
        return carService.createCar(CarPost);
    }

    @Path("/{carId}")
    @PATCH
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public CarView updateCar(@PathParam("carId") Long carId, @Valid @NotNull CarPatch carPatch) {
        return carService.patchCar(carId, carPatch);
    }

    @Path("/{carId}")
    @DELETE
    public void deleteCar(@PathParam("carId") Long carId) {
        carService.deleteCar(carId);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CarView> getCars() {
        return carService.getCars();
    }

    @Path("/{carId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public CarView getCar(@PathParam("carId") Long CarId) {
        return carService.getCar(CarId);
    }

}
