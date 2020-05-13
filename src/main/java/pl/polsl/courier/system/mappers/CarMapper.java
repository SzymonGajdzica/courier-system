package pl.polsl.courier.system.mappers;

import pl.polsl.courier.system.models.Car;
import pl.polsl.courier.system.views.CarGet;
import pl.polsl.courier.system.views.CarPatch;
import pl.polsl.courier.system.views.CarPost;

public interface CarMapper {

    Car map(CarPost carPost);

    CarGet map(Car car);

    void map(CarPatch carPatch, Car car);

}
