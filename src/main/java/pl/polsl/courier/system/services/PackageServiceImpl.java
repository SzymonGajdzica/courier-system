package pl.polsl.courier.system.services;

import pl.polsl.courier.system.controllers.BaseEntityManager;
import pl.polsl.courier.system.models.Car;
import pl.polsl.courier.system.models.Client;
import pl.polsl.courier.system.models.Package;
import pl.polsl.courier.system.views.PackageDeliveryPatch;
import pl.polsl.courier.system.views.PackagePost;

import javax.ejb.Stateful;
import javax.persistence.PersistenceContext;
import javax.ws.rs.BadRequestException;
import java.util.Date;
import java.util.List;

@Stateful
public class PackageServiceImpl implements PackageService {

    @PersistenceContext
    private BaseEntityManager entityManager;

    @Override
    public Package createPackage(PackagePost packagePost) {
        Client client = entityManager.findOrThrow(Client.class, packagePost.getClientId());
        Package mPackage = new Package();
        mPackage.setClient(client);
        mPackage.setDeliveryLatitude(packagePost.getDeliveryLocation().getLatitude());
        mPackage.setDeliveryLongitude(packagePost.getDeliveryLocation().getLongitude());
        mPackage.setRegisterLatitude(packagePost.getRegisterLocation().getLatitude());
        mPackage.setRegisterLongitude(packagePost.getRegisterLocation().getLongitude());
        mPackage.setName(packagePost.getName());
        entityManager.persist(mPackage);
        return mPackage;
    }

    @Override
    public void deletePackage(Long packageId) {
        Package mPackage = entityManager.findOrThrow(Package.class, packageId);
        entityManager.remove(mPackage);
    }

    @Override
    public List<Package> getPackages() {
        return entityManager.findAll(Package.class);
    }

    @Override
    public Package startPackageDelivery(Long packageId, PackageDeliveryPatch packageDeliveryPatch) {
        Package mPackage = entityManager.findOrThrow(Package.class, packageId);
        if (mPackage.getDeliveryDate() != null)
            throw new BadRequestException("Package already delivered");
        if (mPackage.getCar() != null)
            throw new BadRequestException("Cannot deliver package that is is already being delivered");
        Car car = entityManager.findOrThrow(Car.class, packageDeliveryPatch.getCarId());
        mPackage.setCar(car);
        mPackage.setStartOfDeliveryDate(new Date());
        entityManager.merge(mPackage);
        return mPackage;
    }

    @Override
    public Package deliverPackage(Long packageId) {
        Package mPackage = entityManager.findOrThrow(Package.class, packageId);
        if (mPackage.getDeliveryDate() != null)
            throw new BadRequestException("Package already delivered");
        if (mPackage.getCar() == null)
            throw new BadRequestException("Cannot deliver package when car is not assigned to it");
        mPackage.setDeliveryDate(new Date());
        entityManager.merge(mPackage);
        return mPackage;
    }
}
