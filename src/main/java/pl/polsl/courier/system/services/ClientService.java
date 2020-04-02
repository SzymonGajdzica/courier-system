package pl.polsl.courier.system.services;

import pl.polsl.courier.system.models.Client;
import pl.polsl.courier.system.views.ClientPost;

public interface ClientService {

    Client createCourier(ClientPost clientPost);

}
