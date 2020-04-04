package pl.polsl.courier.system.services;

import pl.polsl.courier.system.models.Client;

import java.util.List;

public interface ClientService {

    Client createClient(Client client);

    Client patchClient(Client client);

    void deleteClient(Client client);

    Client getClient(Long clientId);

    List<Client> getClients();

}
