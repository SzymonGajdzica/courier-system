package pl.polsl.courier.system.mappers;

import pl.polsl.courier.system.models.Route;
import pl.polsl.courier.system.views.RouteFinishPatch;
import pl.polsl.courier.system.views.RoutePost;
import pl.polsl.courier.system.views.RouteView;

public interface RouteMapper {

    Route map(RoutePost routePost);

    RouteView map(Route route);

    void map(RouteFinishPatch routeFinishPatch, Route route);

}
