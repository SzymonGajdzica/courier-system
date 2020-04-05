package pl.polsl.courier.system.mappers;

import pl.polsl.courier.system.models.Client;
import pl.polsl.courier.system.views.ClientPatch;
import pl.polsl.courier.system.views.ClientPost;
import pl.polsl.courier.system.views.ClientView;

public interface ClientMapper {

    Client map(ClientPost clientPost);

    ClientView map(Client client);

    void map(ClientPatch clientPatch, Client client);

}
