package pl.polsl.courier.system.services;

import pl.polsl.courier.system.exceptions.BadRequestException;
import pl.polsl.courier.system.mappers.CarMapper;
import pl.polsl.courier.system.models.Car;
import pl.polsl.courier.system.views.CarPatch;
import pl.polsl.courier.system.views.CarPost;
import pl.polsl.courier.system.views.CarView;

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
    public CarView createCar(CarPost carPost) {
        Car car = carMapper.map(carPost);
        entityManagerHelper.getEntityManager().persist(car);
        return carMapper.map(car);
    }

    @Override
    public CarView patchCar(Long carId, CarPatch carPatch) {
        Car car = entityManagerHelper.getOne(Car.class, carId);
        if (car.getInUse() && carPatch.getInUse() != null && carPatch.getInUse())
            throw new BadRequestException("Cannot use car that is already in use");
        carMapper.map(carPatch, car);
        if (!car.getAvailable() && car.getInUse())
            throw new BadRequestException("Cannot user not available car");
        return carMapper.map(entityManagerHelper.getEntityManager().merge(car));
    }

    @Override
    public CarView getCar(Long carId) {
        Car car = entityManagerHelper.getOne(Car.class, carId);
        return carMapper.map(car);
    }

    @Override
    public List<CarView> getCars() {
        List<Car> cars = entityManagerHelper.findAll(Car.class);
        return cars.stream().map(car -> carMapper.map(car)).collect(Collectors.toList());
    }

    @Override
    public void deleteCar(Long carId) {
        entityManagerHelper.removeById(Car.class, carId);
    }

}
