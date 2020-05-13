package pl.polsl.courier.system.mappers;

import pl.polsl.courier.system.models.Package;
import pl.polsl.courier.system.views.PackageGet;
import pl.polsl.courier.system.views.PackagePost;

public interface PackageMapper {

    Package map(PackagePost packagePost);

    PackageGet map(Package mPackage);

}
