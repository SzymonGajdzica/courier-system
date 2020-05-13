package pl.polsl.courier.system.services;

import pl.polsl.courier.system.views.ClientGet;
import pl.polsl.courier.system.views.ClientPatch;
import pl.polsl.courier.system.views.ClientPost;

import java.util.List;

public interface ClientService {

    ClientGet createClient(ClientPost clientPost);

    ClientGet patchClient(Long clientId, ClientPatch clientPatch);

    void deleteClient(Long clientId);

    ClientGet getClient(Long clientId);

    List<ClientGet> getClients();

}
