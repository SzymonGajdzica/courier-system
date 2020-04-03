package pl.polsl.courier.system.services;

import pl.polsl.courier.system.controllers.BaseEntityManager;
import pl.polsl.courier.system.exceptions.FieldAlreadyUsedException;
import pl.polsl.courier.system.models.Client;
import pl.polsl.courier.system.views.ClientPatch;
import pl.polsl.courier.system.views.ClientPost;

import javax.ejb.Stateful;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateful
public class ClientServiceImpl implements ClientService {

    @PersistenceContext
    private BaseEntityManager entityManager;

    @Override
    public Client createClient(ClientPost clientPost) {
        Client client = new Client();
        checkPhoneNumber(clientPost.getPhoneNumber());
        client.setName(clientPost.getName());
        client.setEmail(clientPost.getEmail());
        client.setPhoneNumber(clientPost.getPhoneNumber());
        client.setSurname(clientPost.getSurname());
        entityManager.persist(client);
        return client;
    }

    @Override
    public Client patchClient(Long clientId, ClientPatch clientPatch) {
        Client client = entityManager.findOrThrow(Client.class, clientId);
        if (clientPatch.getPhoneNumber() != null && !clientPatch.getPhoneNumber().equals(client.getPhoneNumber()))
            checkPhoneNumber(clientPatch.getPhoneNumber());
        if (clientPatch.getEmail() != null)
            client.setEmail(clientPatch.getEmail());
        if (clientPatch.getName() != null)
            client.setName(clientPatch.getName());
        if (clientPatch.getPhoneNumber() != null)
            client.setPhoneNumber(clientPatch.getPhoneNumber());
        if (clientPatch.getSurname() != null)
            client.setSurname(clientPatch.getSurname());
        return entityManager.merge(client);
    }

    private void checkPhoneNumber(String phoneNumber) {
        if (phoneNumber != null) {
            int size = entityManager
                    .createNativeQuery("SELECT * FROM clients WHERE phone_number = ?1")
                    .setParameter(1, phoneNumber)
                    .getResultList()
                    .size();
            if (size != 0)
                throw new FieldAlreadyUsedException("phoneNumber", phoneNumber);
        }
    }

    @Override
    public void deleteClient(Long clientId) {
        Client client = entityManager.findOrThrow(Client.class, clientId);
        entityManager.remove(client);
    }

    @Override
    public List<Client> getClients() {
        return entityManager.findAll(Client.class);
    }
}
