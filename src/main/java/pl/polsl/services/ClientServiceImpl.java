package pl.polsl.services;

import pl.polsl.models.Client;
import pl.polsl.views.ClientPost;

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
