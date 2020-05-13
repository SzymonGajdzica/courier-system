package pl.polsl.courier.system.mappers;

import pl.polsl.courier.system.models.Client;
import pl.polsl.courier.system.views.ClientGet;
import pl.polsl.courier.system.views.ClientPatch;
import pl.polsl.courier.system.views.ClientPost;

public interface ClientMapper {

    Client map(ClientPost clientPost);

    ClientGet map(Client client);

    void map(ClientPatch clientPatch, Client client);

}
