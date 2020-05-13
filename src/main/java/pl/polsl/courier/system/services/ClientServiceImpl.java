package pl.polsl.courier.system.services;

import pl.polsl.courier.system.exceptions.FieldAlreadyUsedException;
import pl.polsl.courier.system.mappers.ClientMapper;
import pl.polsl.courier.system.models.Client;
import pl.polsl.courier.system.views.ClientGet;
import pl.polsl.courier.system.views.ClientPatch;
import pl.polsl.courier.system.views.ClientPost;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

@Stateful
public class ClientServiceImpl implements ClientService {

    @EJB
    private EntityManagerHelper entityManagerHelper;

    @EJB
    private ClientMapper clientMapper;

    @Override
    public ClientGet createClient(ClientPost clientPost) {
        checkPhoneNumber(clientPost.getPhoneNumber());
        Client client = clientMapper.map(clientPost);
        return clientMapper.map(entityManagerHelper.persist(client));
    }

    @Override
    public ClientGet patchClient(Long clientId, ClientPatch clientPatch) {
        checkPhoneNumber(clientPatch.getPhoneNumber());
        Client client = entityManagerHelper.getOne(Client.class, clientId);
        clientMapper.map(clientPatch, client);
        return clientMapper.map(entityManagerHelper.merge(client));
    }

    private void checkPhoneNumber(String phoneNumber) {
        if (phoneNumber != null) {
            BigInteger size = (BigInteger) entityManagerHelper
                    .getEntityManager()
                    .createNativeQuery("SELECT count(*) FROM clients WHERE phone_number = ?1")
                    .setParameter(1, phoneNumber)
                    .getSingleResult();
            if (size.longValue() != 0)
                throw new FieldAlreadyUsedException("phoneNumber", phoneNumber);
        }
    }

    @Override
    public void deleteClient(Long clientId) {
        entityManagerHelper.removeById(Client.class, clientId);
    }

    @Override
    public ClientGet getClient(Long clientId) {
        return clientMapper.map(entityManagerHelper.getOne(Client.class, clientId));
    }

    @Override
    public List<ClientGet> getClients() {
        List<Client> clients = entityManagerHelper.findAll(Client.class);
        return clients.stream().map(client -> clientMapper.map(client)).collect(Collectors.toList());
    }

}
