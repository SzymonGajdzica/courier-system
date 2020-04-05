package pl.polsl.courier.system.services;

import pl.polsl.courier.system.views.RouteFinishPatch;
import pl.polsl.courier.system.views.RoutePost;
import pl.polsl.courier.system.views.RouteView;

import java.util.List;

public interface RouteService {

    RouteView createRoute(RoutePost routePost);

    RouteView finishRoute(Long routeId, RouteFinishPatch routeFinishPatch);

    List<RouteView> getRoutes(Long carId);

    RouteView getRoute(Long routeId);

    void deleteRoute(Long routeId);

}
