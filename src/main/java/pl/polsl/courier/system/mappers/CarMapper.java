package pl.polsl.courier.system.mappers;

import pl.polsl.courier.system.models.Car;
import pl.polsl.courier.system.views.CarPatch;
import pl.polsl.courier.system.views.CarPost;
import pl.polsl.courier.system.views.CarView;

public interface CarMapper {

    Car map(CarPost carPost);

    CarView map(Car car);

    void map(CarPatch carPatch, Car car);

}
