package pl.polsl.courier.system.services;

import pl.polsl.courier.system.models.Client;
import pl.polsl.courier.system.views.ClientPatch;
import pl.polsl.courier.system.views.ClientPost;

import java.util.List;

public interface ClientService {

    Client createClient(ClientPost clientPost);

    Client patchClient(Long clientId, ClientPatch clientPatch);

    void deleteClient(Long clientId);

    List<Client> getClients();

}
