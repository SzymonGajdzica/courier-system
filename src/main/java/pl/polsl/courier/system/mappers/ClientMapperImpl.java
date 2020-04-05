package pl.polsl.courier.system.mappers;

import pl.polsl.courier.system.models.Client;
import pl.polsl.courier.system.views.ClientPatch;
import pl.polsl.courier.system.views.ClientPost;
import pl.polsl.courier.system.views.ClientView;

import javax.ejb.Stateful;

@Stateful
public class ClientMapperImpl implements ClientMapper {

    @Override
    public Client map(ClientPost clientPost) {
        Client client = new Client();
        client.setSurname(clientPost.getSurname());
        client.setPhoneNumber(clientPost.getPhoneNumber());
        client.setName(clientPost.getName());
        client.setEmail(clientPost.getEmail());
        return client;
    }

    @Override
    public ClientView map(Client client) {
        ClientView clientView = new ClientView();
        clientView.setSurname(client.getSurname());
        clientView.setPhoneNumber(client.getPhoneNumber());
        clientView.setEmail(client.getEmail());
        clientView.setName(client.getName());
        clientView.setId(client.getId());
        return clientView;
    }

    @Override
    public void map(ClientPatch clientPatch, Client client) {
        if (clientPatch.getSurname() != null)
            client.setSurname(clientPatch.getSurname());
        if (clientPatch.getPhoneNumber() != null)
            client.setPhoneNumber(clientPatch.getPhoneNumber());
        if (clientPatch.getEmail() != null)
            client.setEmail(clientPatch.getEmail());
        if (clientPatch.getName() != null)
            client.setName(clientPatch.getName());
    }

}
