package pl.polsl.courier.system.mappers;

import pl.polsl.courier.system.models.Package;
import pl.polsl.courier.system.views.LatLng;
import pl.polsl.courier.system.views.PackagePost;
import pl.polsl.courier.system.views.PackageView;

import javax.ejb.Stateful;

@Stateful
public class PackageMapperImpl implements PackageMapper {

    @Override
    public Package map(PackagePost packagePost) {
        Package mPackage = new Package();
        mPackage.setName(packagePost.getName());
        mPackage.setRegisterLatitude(packagePost.getRegisterLatLng().getLatitude());
        mPackage.setRegisterLongitude(packagePost.getRegisterLatLng().getLongitude());
        mPackage.setDeliveryLatitude(packagePost.getDeliveryLatLng().getLatitude());
        mPackage.setDeliveryLongitude(packagePost.getDeliveryLatLng().getLongitude());
        return mPackage;
    }

    @Override
    public PackageView map(Package mPackage) {
        PackageView packageView = new PackageView();
        if (mPackage.getDeliveryLatitude() != null && mPackage.getDeliveryLongitude() != null)
            packageView.setDeliveryLatLng(new LatLng(mPackage.getDeliveryLatitude(), mPackage.getDeliveryLongitude()));
        if (mPackage.getRegisterLatitude() != null && mPackage.getRegisterLongitude() != null)
            packageView.setRegisterLatLng(new LatLng(mPackage.getRegisterLatitude(), mPackage.getRegisterLongitude()));
        packageView.setId(mPackage.getId());
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
