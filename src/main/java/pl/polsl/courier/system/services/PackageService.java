package pl.polsl.courier.system.services;

import pl.polsl.courier.system.views.PackageDeliveryPatch;
import pl.polsl.courier.system.views.PackagePost;
import pl.polsl.courier.system.views.PackageView;

import java.util.List;

public interface PackageService {

    PackageView createPackage(PackagePost packagePost);

    void deletePackage(Long packageId);

    List<PackageView> getPackages();

    PackageView getPackage(Long packageId);

    PackageView startPackageDelivery(Long packageId, PackageDeliveryPatch packageDeliveryPatch);

    PackageView deliverPackage(Long packageId);

}
