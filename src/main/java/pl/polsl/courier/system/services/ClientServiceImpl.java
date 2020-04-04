package pl.polsl.courier.system.services;

import pl.polsl.courier.system.exceptions.FieldAlreadyUsedException;
import pl.polsl.courier.system.models.Client;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import java.util.List;

@Stateful
public class ClientServiceImpl implements ClientService {

    @EJB
    private EntityManagerHelper entityManagerHelper;

    @Override
    public Client createClient(Client client) {
        checkPhoneNumber(client.getPhoneNumber());
        entityManagerHelper.getEntityManager().persist(client);
        return client;
    }

    @Override
    public Client patchClient(Client client) {
        checkPhoneNumber(client.getPhoneNumber());
        return entityManagerHelper.getEntityManager().merge(client);
    }

    private void checkPhoneNumber(String phoneNumber) {
        if (phoneNumber != null) {
            int size = entityManagerHelper
                    .getEntityManager()
                    .createNativeQuery("SELECT * FROM clients WHERE phone_number = ?1")
                    .setParameter(1, phoneNumber)
                    .getResultList()
                    .size();
            if (size != 0)
                throw new FieldAlreadyUsedException("phoneNumber", phoneNumber);
        }
    }

    @Override
    public void deleteClient(Client client) {
        entityManagerHelper.getEntityManager().remove(client);
    }

    @Override
    public Client getClient(Long clientId) {
        return entityManagerHelper.find(Client.class, clientId);
    }

    @Override
    public List<Client> getClients() {
        return entityManagerHelper.findAll(Client.class);
    }

}
