package pl.polsl.courier.system.services;

import pl.polsl.courier.system.models.Car;
import pl.polsl.courier.system.models.Client;
import pl.polsl.courier.system.models.Package;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ws.rs.BadRequestException;
import java.util.Date;
import java.util.List;

@Stateful
public class PackageServiceImpl implements PackageService {

    @EJB
    private EntityManagerHelper entityManagerHelper;

    @Override
    public Package createPackage(Package mPackage, Long clientId) {
        Client client = entityManagerHelper.find(Client.class, clientId);
        mPackage.setClient(client);
        entityManagerHelper.getEntityManager().persist(mPackage);
        return mPackage;
    }

    @Override
    public void deletePackage(Package mPackage) {
        entityManagerHelper.getEntityManager().remove(mPackage);
    }

    @Override
    public List<Package> getPackages() {
        return entityManagerHelper.findAll(Package.class);
    }

    @Override
    public Package getPackage(Long packageId) {
        return entityManagerHelper.find(Package.class, packageId);
    }

    @Override
    public Package startPackageDelivery(Package mPackage, Long carId) {
        if (mPackage.getDeliveryDate() != null)
            throw new BadRequestException("Package already delivered");
        if (mPackage.getCar() != null)
            throw new BadRequestException("Cannot deliver package that is is already being delivered");
        Car car = entityManagerHelper.find(Car.class, carId);
        mPackage.setStartOfDeliveryDate(new Date());
        mPackage.setCar(car);
        entityManagerHelper.getEntityManager().merge(mPackage);
        return mPackage;
    }

    @Override
    public Package deliverPackage(Package mPackage) {
        if (mPackage.getDeliveryDate() != null)
            throw new BadRequestException("Package already delivered");
        if (mPackage.getCar() == null)
            throw new BadRequestException("Cannot deliver package when car is not assigned to it");
        mPackage.setDeliveryDate(new Date());
        entityManagerHelper.getEntityManager().merge(mPackage);
        return mPackage;
    }
}
