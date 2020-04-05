package pl.polsl.courier.system.services;

import pl.polsl.courier.system.views.CarPatch;
import pl.polsl.courier.system.views.CarPost;
import pl.polsl.courier.system.views.CarView;

import java.util.List;

public interface CarService {

    CarView createCar(CarPost carPost);

    CarView patchCar(Long carId, CarPatch carPatch);

    CarView getCar(Long carId);

    List<CarView> getCars();

    void deleteCar(Long carId);

}
