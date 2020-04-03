package pl.polsl.courier.system.services;

import pl.polsl.courier.system.models.Client;
import pl.polsl.courier.system.views.ClientView;

public interface Serializer {

    ClientView serialize(Client client);

}
