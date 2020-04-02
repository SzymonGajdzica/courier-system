package pl.polsl.courier.system.services;

import pl.polsl.courier.system.models.Client;
import pl.polsl.courier.system.views.ClientPost;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ClientServiceImpl implements ClientService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Client createCourier(ClientPost clientPost) {
        Client client = new Client();
        client.setName(clientPost.getName());
        entityManager.persist(client);
        return client;
    }
}
