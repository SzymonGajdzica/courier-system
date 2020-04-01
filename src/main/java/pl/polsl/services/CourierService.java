package pl.polsl.services;

import pl.polsl.models.Courier;
import pl.polsl.views.CourierPost;

public interface CourierService {

    Courier createCourier(CourierPost courierPost);

}
