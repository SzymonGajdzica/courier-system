package pl.polsl.courier.system.services;

import pl.polsl.courier.system.models.Client;
import pl.polsl.courier.system.views.ClientView;

import javax.ejb.Stateful;

@Stateful
public class SerializerImpl implements Serializer {

    @Override
    public ClientView serialize(Client client) {
        ClientView clientView = new ClientView();
        clientView.setId(client.getId());
        clientView.setName(client.getName());
        clientView.setSecondName(client.getSecondName());
        clientView.setEmail(client.getEmail());
        clientView.setPhoneNumber(client.getPhoneNumber());
        clientView.setSurname(client.getSurname());
        return clientView;
    }
}
