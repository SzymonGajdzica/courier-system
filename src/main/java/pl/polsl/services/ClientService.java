package pl.polsl.services;

import pl.polsl.models.Client;
import pl.polsl.views.ClientPost;

public interface ClientService {

    Client createCourier(ClientPost clientPost);

}
