package pl.polsl.courier.system.services;

import pl.polsl.courier.system.views.ClientPatch;
import pl.polsl.courier.system.views.ClientPost;
import pl.polsl.courier.system.views.ClientView;

import java.util.List;

public interface ClientService {

    ClientView createClient(ClientPost clientPost);

    ClientView patchClient(Long clientId, ClientPatch clientPatch);

    void deleteClient(Long clientId);

    ClientView getClient(Long clientId);

    List<ClientView> getClients();

}
