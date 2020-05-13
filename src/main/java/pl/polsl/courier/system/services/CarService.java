package pl.polsl.courier.system.services;

import pl.polsl.courier.system.views.CarGet;
import pl.polsl.courier.system.views.CarPatch;
import pl.polsl.courier.system.views.CarPost;

import java.util.List;

public interface CarService {

    CarGet createCar(CarPost carPost);

    CarGet patchCar(Long carId, CarPatch carPatch);

    List<CarGet> getCars();

    void deleteCar(Long carId);

}
