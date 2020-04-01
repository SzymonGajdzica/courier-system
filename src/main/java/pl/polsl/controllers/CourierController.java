package pl.polsl.controllers;

import pl.polsl.models.Courier;
import pl.polsl.services.CourierService;
import pl.polsl.views.CourierPost;
import pl.polsl.views.CourierView;

import javax.ejb.EJB;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/courier")
public class CourierController {

    @EJB
    private CourierService courierService;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public CourierView createCourier(CourierPost courierPost) {
        Courier courier = courierService.createCourier(courierPost);
        CourierView courierView = new CourierView();
        courierView.setId(courier.getId());
        courierView.setName(courier.getName());
        return courierView;
    }

}
