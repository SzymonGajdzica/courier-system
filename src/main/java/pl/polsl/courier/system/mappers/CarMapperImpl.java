package pl.polsl.courier.system.mappers;

import pl.polsl.courier.system.models.Car;
import pl.polsl.courier.system.views.CarPatch;
import pl.polsl.courier.system.views.CarPost;
import pl.polsl.courier.system.views.CarView;
import pl.polsl.courier.system.views.LatLng;

import javax.ejb.Stateful;

@Stateful
public class CarMapperImpl implements CarMapper {

    @Override
    public Car map(CarPost carPost) {
        Car car = new Car();
        car.setName(carPost.getName());
        car.setLatitude(carPost.getLatLng().getLatitude());
        car.setLongitude(carPost.getLatLng().getLongitude());
        return car;
    }

    @Override
    public CarView map(Car car) {
        CarView carView = new CarView();
        carView.setAvailable(car.getAvailable());
        carView.setInUse(car.getInUse());
        carView.setId(car.getId());
        carView.setName(car.getName());
        carView.setLatLng(new LatLng(car.getLatitude(), car.getLongitude()));
        return carView;
    }

    @Override
    public void map(CarPatch carPatch, Car car) {
        if (carPatch.getAvailable() != null)
            car.setAvailable(carPatch.getAvailable());
        if (carPatch.getInUse() != null)
            car.setInUse(carPatch.getInUse());
        if (carPatch.getLatLng() != null) {
            car.setLatitude(carPatch.getLatLng().getLatitude());
            car.setLongitude(carPatch.getLatLng().getLongitude());
        }
        if (carPatch.getName() != null)
            car.setName(carPatch.getName());
    }

}
