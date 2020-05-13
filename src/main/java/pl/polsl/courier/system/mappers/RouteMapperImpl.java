package pl.polsl.courier.system.mappers;

import pl.polsl.courier.system.models.Route;
import pl.polsl.courier.system.views.RouteGet;
import pl.polsl.courier.system.views.RoutePost;

import javax.ejb.Stateful;

@Stateful
public class RouteMapperImpl implements RouteMapper {

    @Override
    public Route map(RoutePost routePost) {
        return new Route();
    }

    @Override
    public RouteGet map(Route route) {
        RouteGet routeGet = new RouteGet();
        routeGet.setId(route.getId());
        routeGet.setStartPlaceId(route.getStartPlace().getId());
        routeGet.setEndPlaceId(route.getEndPlace().getId());
        return routeGet;
    }

}
