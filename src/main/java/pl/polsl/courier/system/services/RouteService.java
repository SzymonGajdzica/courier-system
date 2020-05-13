package pl.polsl.courier.system.services;

import pl.polsl.courier.system.views.RouteGet;
import pl.polsl.courier.system.views.RoutePost;

import java.util.List;

public interface RouteService {

    RouteGet createRoute(RoutePost routePost);

    List<RouteGet> getRoutes();

}
