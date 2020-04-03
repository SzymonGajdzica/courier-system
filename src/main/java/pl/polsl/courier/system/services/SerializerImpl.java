package pl.polsl.courier.system.services;

import pl.polsl.courier.system.models.Client;
import pl.polsl.courier.system.models.Package;
import pl.polsl.courier.system.views.ClientView;
import pl.polsl.courier.system.views.Location;
import pl.polsl.courier.system.views.PackageView;

import javax.ejb.Stateful;

@Stateful
public class SerializerImpl implements Serializer {

    @Override
    public ClientView serialize(Client client) {
        ClientView clientView = new ClientView();
        clientView.setId(client.getId());
        clientView.setName(client.getName());
        clientView.setEmail(client.getEmail());
        clientView.setPhoneNumber(client.getPhoneNumber());
        clientView.setSurname(client.getSurname());
        return clientView;
    }

    @Override
    public PackageView serialize(Package mPackage) {
        PackageView packageView = new PackageView();
        if (mPackage.getCar() != null)
            packageView.setCarId(mPackage.getCar().getId());
        packageView.setClientId(mPackage.getClient().getId());
        packageView.setDeliveryDate(mPackage.getDeliveryDate());
        packageView.setName(mPackage.getName());
        packageView.setRegisterDate(mPackage.getRegisterDate());
        packageView.setStartOfDeliveryDate(mPackage.getStartOfDeliveryDate());
        packageView.setDeliveryLocation(new Location(mPackage.getDeliveryLatitude(), mPackage.getDeliveryLongitude()));
        packageView.setRegisterLocation(new Location(mPackage.getRegisterLatitude(), mPackage.getRegisterLongitude()));
        return packageView;
    }
}
