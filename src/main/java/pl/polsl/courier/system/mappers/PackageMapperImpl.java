package pl.polsl.courier.system.mappers;

import pl.polsl.courier.system.models.Package;
import pl.polsl.courier.system.views.PackageGet;
import pl.polsl.courier.system.views.PackagePost;

import javax.ejb.Stateful;

@Stateful
public class PackageMapperImpl implements PackageMapper {

    @Override
    public Package map(PackagePost packagePost) {
        Package mPackage = new Package();
        mPackage.setName(packagePost.getName());
        return mPackage;
    }

    @Override
    public PackageGet map(Package mPackage) {
        PackageGet packageView = new PackageGet();
        packageView.setId(mPackage.getId());
        packageView.setRouteId(mPackage.getRoute().getId());
        packageView.setRegisterDate(mPackage.getRegisterDate());
        packageView.setName(mPackage.getName());
        packageView.setClientId(mPackage.getClient().getId());
        if (mPackage.getCar() != null)
            packageView.setCarId(mPackage.getCar().getId());
        packageView.setStartOfDeliveryDate(mPackage.getStartOfDeliveryDate());
        packageView.setDeliveryDate(mPackage.getDeliveryDate());
        return packageView;
    }

}
