package pl.polsl.courier.system.mappers;

import pl.polsl.courier.system.models.Route;
import pl.polsl.courier.system.views.RouteGet;
import pl.polsl.courier.system.views.RoutePost;

public interface RouteMapper {

    Route map(RoutePost routePost);

    RouteGet map(Route route);

}
