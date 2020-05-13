package pl.polsl.courier.system.services;

import pl.polsl.courier.system.mappers.PackageMapper;
import pl.polsl.courier.system.models.Car;
import pl.polsl.courier.system.models.Client;
import pl.polsl.courier.system.models.Package;
import pl.polsl.courier.system.models.Route;
import pl.polsl.courier.system.views.PackageDeliveryPatch;
import pl.polsl.courier.system.views.PackageGet;
import pl.polsl.courier.system.views.PackagePost;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ws.rs.BadRequestException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Stateful
public class PackageServiceImpl implements PackageService {

    @EJB
    private EntityManagerHelper entityManagerHelper;

    @EJB
    private PackageMapper packageMapper;

    @Override
    public PackageGet createPackage(PackagePost packagePost) {
        Package mPackage = packageMapper.map(packagePost);
        mPackage.setClient(entityManagerHelper.getOne(Client.class, packagePost.getClientId()));
        mPackage.setRoute(entityManagerHelper.getOne(Route.class, packagePost.getRouteId()));
        return packageMapper.map(entityManagerHelper.persist(mPackage));
    }

    @Override
    public void deletePackage(Long packageId) {
        entityManagerHelper.removeById(Package.class, packageId);
    }

    @Override
    public List<PackageGet> getPackages() {
        List<Package> packages = entityManagerHelper.findAll(Package.class);
        return packages.stream().map(mPackage -> packageMapper.map(mPackage)).collect(Collectors.toList());
    }

    @Override
    public PackageGet startPackageDelivery(Long packageId, PackageDeliveryPatch packageDeliveryPatch) {
        Package mPackage = entityManagerHelper.getOne(Package.class, packageId);
        if (mPackage.getDeliveryDate() != null)
            throw new BadRequestException("Package already delivered");
        if (mPackage.getCar() != null)
            throw new BadRequestException("Cannot deliver package that is is already being delivered");
        mPackage.setStartOfDeliveryDate(new Date());
        mPackage.setCar(entityManagerHelper.getOne(Car.class, packageDeliveryPatch.getCarId()));
        return packageMapper.map(entityManagerHelper.merge(mPackage));
    }

    @Override
    public PackageGet deliverPackage(Long packageId) {
        Package mPackage = entityManagerHelper.getOne(Package.class, packageId);
        if (mPackage.getDeliveryDate() != null)
            throw new BadRequestException("Package already delivered");
        if (mPackage.getCar() == null)
            throw new BadRequestException("Cannot deliver package when car is not assigned to it");
        mPackage.setDeliveryDate(new Date());
        return packageMapper.map(entityManagerHelper.merge(mPackage));
    }
}
