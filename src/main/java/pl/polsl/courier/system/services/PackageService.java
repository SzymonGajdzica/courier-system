package pl.polsl.courier.system.services;

import pl.polsl.courier.system.models.Package;

import java.util.List;

public interface PackageService {

    Package createPackage(Package mPackage, Long clientId);

    void deletePackage(Package mPackage);

    List<Package> getPackages();

    Package getPackage(Long packageId);

    Package startPackageDelivery(Package mPackage, Long carId);

    Package deliverPackage(Package mPackage);

}
