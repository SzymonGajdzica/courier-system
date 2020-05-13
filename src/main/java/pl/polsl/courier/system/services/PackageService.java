package pl.polsl.courier.system.services;

import pl.polsl.courier.system.views.PackageDeliveryPatch;
import pl.polsl.courier.system.views.PackageGet;
import pl.polsl.courier.system.views.PackagePost;

import java.util.List;

public interface PackageService {

    PackageGet createPackage(PackagePost packagePost);

    void deletePackage(Long packageId);

    List<PackageGet> getPackages();

    PackageGet startPackageDelivery(Long packageId, PackageDeliveryPatch packageDeliveryPatch);

    PackageGet deliverPackage(Long packageId);

}
