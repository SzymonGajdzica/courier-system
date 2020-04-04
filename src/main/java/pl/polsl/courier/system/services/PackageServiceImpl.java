package pl.polsl.courier.system.services;

import pl.polsl.courier.system.models.Car;
import pl.polsl.courier.system.models.Client;
import pl.polsl.courier.system.models.Package;
import pl.polsl.courier.system.views.PackageDeliveryPatch;
import pl.polsl.courier.system.views.PackagePost;
import pl.polsl.courier.system.views.PackageView;

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
    private CustomModelMapper modelMapper;

    @Override
    public PackageView createPackage(PackagePost packagePost) {
        Package mPackage = modelMapper.map(packagePost, Package.class);
        mPackage.setClient(entityManagerHelper.getOne(Client.class, packagePost.getClientId()));
        entityManagerHelper.getEntityManager().persist(mPackage);
        return modelMapper.map(mPackage, PackageView.class);
    }

    @Override
    public void deletePackage(Long packageId) {
        entityManagerHelper.removeById(Package.class, packageId);
    }

    @Override
    public List<PackageView> getPackages() {
        List<Package> packages = entityManagerHelper.findAll(Package.class);
        return packages.stream().map(mPackage -> modelMapper.map(mPackage, PackageView.class)).collect(Collectors.toList());
    }

    @Override
    public PackageView getPackage(Long packageId) {
        Package mPackage = entityManagerHelper.getOne(Package.class, packageId);
        return modelMapper.map(mPackage, PackageView.class);
    }

    @Override
    public PackageView startPackageDelivery(Long packageId, PackageDeliveryPatch packageDeliveryPatch) {
        Package mPackage = entityManagerHelper.getOne(Package.class, packageId);
        if (mPackage.getDeliveryDate() != null)
            throw new BadRequestException("Package already delivered");
        if (mPackage.getCar() != null)
            throw new BadRequestException("Cannot deliver package that is is already being delivered");
        mPackage.setStartOfDeliveryDate(new Date());
        mPackage.setCar(entityManagerHelper.getOne(Car.class, packageDeliveryPatch.getCarId()));
        entityManagerHelper.getEntityManager().merge(mPackage);
        return modelMapper.map(mPackage, PackageView.class);
    }

    @Override
    public PackageView deliverPackage(Long packageId) {
        Package mPackage = entityManagerHelper.getOne(Package.class, packageId);
        if (mPackage.getDeliveryDate() != null)
            throw new BadRequestException("Package already delivered");
        if (mPackage.getCar() == null)
            throw new BadRequestException("Cannot deliver package when car is not assigned to it");
        mPackage.setDeliveryDate(new Date());
        entityManagerHelper.getEntityManager().merge(mPackage);
        return modelMapper.map(mPackage, PackageView.class);
    }
}
