package pl.polsl.courier.system.services;

import pl.polsl.courier.system.models.Package;
import pl.polsl.courier.system.views.PackageDeliveryPatch;
import pl.polsl.courier.system.views.PackagePost;

import java.util.List;

public interface PackageService {

    Package createPackage(PackagePost packagePost);

    void deletePackage(Long packageId);

    List<Package> getPackages();

    Package startPackageDelivery(Long packageId, PackageDeliveryPatch packageDeliveryPatch);

    Package deliverPackage(Long packageId);

}
