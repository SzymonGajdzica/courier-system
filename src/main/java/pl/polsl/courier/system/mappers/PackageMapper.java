package pl.polsl.courier.system.mappers;

import pl.polsl.courier.system.models.Package;
import pl.polsl.courier.system.views.PackagePost;
import pl.polsl.courier.system.views.PackageView;

public interface PackageMapper {

    Package map(PackagePost packagePost);

    PackageView map(Package mPackage);

}
