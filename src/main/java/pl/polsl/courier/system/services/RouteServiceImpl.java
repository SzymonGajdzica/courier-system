package pl.polsl.courier.system.services;

import pl.polsl.courier.system.exceptions.BadRequestException;
import pl.polsl.courier.system.mappers.RouteMapper;
import pl.polsl.courier.system.models.Place;
import pl.polsl.courier.system.models.Route;
import pl.polsl.courier.system.views.RouteGet;
import pl.polsl.courier.system.views.RoutePost;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import java.util.List;
import java.util.stream.Collectors;

@Stateful
public class RouteServiceImpl implements RouteService {

    @EJB
    private RouteMapper routeMapper;

    @EJB
    private EntityManagerHelper entityManagerHelper;

    @Override
    public RouteGet createRoute(RoutePost routePost) {
        if (routePost.getEndPlaceId().equals(routePost.getStartPlaceId()))
            throw new BadRequestException("Route has to be between 2 points");
        Route route = routeMapper.map(routePost);
        route.setStartPlace(entityManagerHelper.getOne(Place.class, routePost.getStartPlaceId()));
        route.setEndPlace(entityManagerHelper.getOne(Place.class, routePost.getEndPlaceId()));
        return routeMapper.map(entityManagerHelper.persist(route));
    }

    @Override
    public List<RouteGet> getRoutes() {
        List<Route> routes = entityManagerHelper.findAll(Route.class);
        return routes.stream().map(route -> routeMapper.map(route)).collect(Collectors.toList());
    }

}
