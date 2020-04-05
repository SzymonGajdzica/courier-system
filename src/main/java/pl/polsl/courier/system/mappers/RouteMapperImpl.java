package pl.polsl.courier.system.mappers;

import pl.polsl.courier.system.models.Route;
import pl.polsl.courier.system.views.LatLng;
import pl.polsl.courier.system.views.RouteFinishPatch;
import pl.polsl.courier.system.views.RoutePost;
import pl.polsl.courier.system.views.RouteView;

import javax.ejb.Stateful;
import java.util.Date;

@Stateful
public class RouteMapperImpl implements RouteMapper {

    @Override
    public Route map(RoutePost routePost) {
        Route route = new Route();
        route.setStartLatitude(routePost.getStartLatLng().getLatitude());
        route.setStartLongitude(routePost.getStartLatLng().getLongitude());
        return route;
    }

    @Override
    public RouteView map(Route route) {
        RouteView routeView = new RouteView();
        routeView.setId(route.getId());
        routeView.setCarId(route.getCar().getId());
        routeView.setStartDate(route.getStartDate());
        routeView.setEndDate(route.getEndDate());
        if (route.getEndLatitude() != null && route.getEndLongitude() != null)
            routeView.setEndLatLng(new LatLng(route.getEndLatitude(), route.getEndLongitude()));
        if (route.getStartLatitude() != null && route.getStartLongitude() != null)
            routeView.setStartLatLng(new LatLng(route.getStartLatitude(), route.getStartLongitude()));
        return routeView;
    }

    @Override
    public void map(RouteFinishPatch routeFinishPatch, Route route) {
        if (routeFinishPatch.getEndLatLng() != null) {
            route.setEndLatitude(routeFinishPatch.getEndLatLng().getLatitude());
            route.setEndLongitude(routeFinishPatch.getEndLatLng().getLongitude());
            route.setEndDate(new Date());
        }
    }

}
