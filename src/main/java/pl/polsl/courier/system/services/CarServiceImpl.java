package pl.polsl.courier.system.services;

import pl.polsl.courier.system.exceptions.BadRequestException;
import pl.polsl.courier.system.mappers.CarMapper;
import pl.polsl.courier.system.models.Car;
import pl.polsl.courier.system.views.CarGet;
import pl.polsl.courier.system.views.CarPatch;
import pl.polsl.courier.system.views.CarPost;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import java.util.List;
import java.util.stream.Collectors;

@Stateful
public class CarServiceImpl implements CarService {

    @EJB
    private EntityManagerHelper entityManagerHelper;

    @EJB
    private CarMapper carMapper;

    @Override
    public CarGet createCar(CarPost carPost) {
        Car car = carMapper.map(carPost);
        return carMapper.map(entityManagerHelper.persist(car));
    }

    @Override
    public CarGet patchCar(Long carId, CarPatch carPatch) {
        Car car = entityManagerHelper.getOne(Car.class, carId);
        if (car.getInUse() && carPatch.getInUse() == true)
            throw new BadRequestException("Cannot use car that is already in use");
        carMapper.map(carPatch, car);
        return carMapper.map(entityManagerHelper.getEntityManager().merge(car));
    }

    @Override
    public List<CarGet> getCars() {
        List<Car> cars = entityManagerHelper.findAll(Car.class);
        return cars.stream().map(car -> carMapper.map(car)).collect(Collectors.toList());
    }

    @Override
    public void deleteCar(Long carId) {
        entityManagerHelper.removeById(Car.class, carId);
    }

}
