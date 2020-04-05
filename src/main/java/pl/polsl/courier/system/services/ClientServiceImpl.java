package pl.polsl.courier.system.services;

import pl.polsl.courier.system.exceptions.FieldAlreadyUsedException;
import pl.polsl.courier.system.mappers.ClientMapper;
import pl.polsl.courier.system.models.Client;
import pl.polsl.courier.system.views.ClientPatch;
import pl.polsl.courier.system.views.ClientPost;
import pl.polsl.courier.system.views.ClientView;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import java.util.List;
import java.util.stream.Collectors;

@Stateful
public class ClientServiceImpl implements ClientService {

    @EJB
    private EntityManagerHelper entityManagerHelper;

    @EJB
    private ClientMapper clientMapper;

    @Override
    public ClientView createClient(ClientPost clientPost) {
        checkPhoneNumber(clientPost.getPhoneNumber());
        Client client = clientMapper.map(clientPost);
        entityManagerHelper.getEntityManager().persist(client);
        return clientMapper.map(client);
    }

    @Override
    public ClientView patchClient(Long clientId, ClientPatch clientPatch) {
        checkPhoneNumber(clientPatch.getPhoneNumber());
        Client client = entityManagerHelper.getOne(Client.class, clientId);
        clientMapper.map(clientPatch, client);
        return clientMapper.map(entityManagerHelper.getEntityManager().merge(client));
    }

    private void checkPhoneNumber(String phoneNumber) {
        if (phoneNumber != null) {
            int size = (int) entityManagerHelper
                    .getEntityManager()
                    .createNativeQuery("SELECT count(*) FROM clients WHERE phone_number = ?1")
                    .setParameter(1, phoneNumber)
                    .getSingleResult();
            if (size != 0)
                throw new FieldAlreadyUsedException("phoneNumber", phoneNumber);
        }
    }

    @Override
    public void deleteClient(Long clientId) {
        entityManagerHelper.removeById(Client.class, clientId);
    }

    @Override
    public ClientView getClient(Long clientId) {
        Client client = entityManagerHelper.getOne(Client.class, clientId);
        return clientMapper.map(client);
    }

    @Override
    public List<ClientView> getClients() {
        List<Client> clients = entityManagerHelper.findAll(Client.class);
        return clients.stream().map(client -> clientMapper.map(client)).collect(Collectors.toList());
    }

}
