package pl.polsl.courier.system.services;

import pl.polsl.courier.system.exceptions.BadRequestException;
import pl.polsl.courier.system.mappers.RouteMapper;
import pl.polsl.courier.system.models.Car;
import pl.polsl.courier.system.models.Route;
import pl.polsl.courier.system.views.RouteFinishPatch;
import pl.polsl.courier.system.views.RoutePost;
import pl.polsl.courier.system.views.RouteView;

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
    public RouteView createRoute(RoutePost routePost) {
        Route route = routeMapper.map(routePost);
        Car car = entityManagerHelper.getOne(Car.class, routePost.getCarId());
        if (!car.getInUse())
            throw new BadRequestException("Cannot add route to car that is not in use");
        if (car.getRoutes().stream().anyMatch(mRoute -> mRoute.getEndDate() != null))
            throw new BadRequestException("Cannot start new route when old is still in progress");
        route.setCar(car);
        entityManagerHelper.getEntityManager().persist(route);
        car.setLatitude(routePost.getStartLatLng().getLatitude());
        car.setLongitude(routePost.getStartLatLng().getLongitude());
        entityManagerHelper.getEntityManager().merge(car);
        return routeMapper.map(route);
    }

    @Override
    public RouteView finishRoute(Long routeId, RouteFinishPatch routeFinishPatch) {
        Route route = entityManagerHelper.getOne(Route.class, routeId);
        if (route.getEndDate() != null)
            throw new BadRequestException("Cannot finish already finished route");
        routeMapper.map(routeFinishPatch, route);
        Car car = route.getCar();
        car.setLatitude(routeFinishPatch.getEndLatLng().getLatitude());
        car.setLongitude(routeFinishPatch.getEndLatLng().getLongitude());
        entityManagerHelper.getEntityManager().merge(car);
        return routeMapper.map(entityManagerHelper.getEntityManager().merge(route));
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<RouteView> getRoutes(Long carId) {
        List<Route> routes = entityManagerHelper.getEntityManager()
                .createNativeQuery("SELECT * FROM routes WHERE car_id = ?1", Route.class)
                .setParameter(1, carId)
                .getResultList();
        return routes.stream().map(route -> routeMapper.map(route)).collect(Collectors.toList());
    }

    @Override
    public RouteView getRoute(Long routeId) {
        Route route = entityManagerHelper.getOne(Route.class, routeId);
        return routeMapper.map(route);
    }

    @Override
    public void deleteRoute(Long routeId) {
        entityManagerHelper.removeById(Route.class, routeId);
    }

}
