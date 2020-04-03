package pl.polsl.courier.system.services;

import pl.polsl.courier.system.models.Client;
import pl.polsl.courier.system.models.Package;
import pl.polsl.courier.system.views.ClientView;
import pl.polsl.courier.system.views.PackageView;

public interface Serializer {

    ClientView serialize(Client client);

    PackageView serialize(Package mPackage);

}
