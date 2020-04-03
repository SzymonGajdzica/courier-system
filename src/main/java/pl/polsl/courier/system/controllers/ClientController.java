package pl.polsl.courier.system.controllers;

import pl.polsl.courier.system.models.Client;
import pl.polsl.courier.system.services.ClientService;
import pl.polsl.courier.system.services.Serializer;
import pl.polsl.courier.system.views.ClientPatch;
import pl.polsl.courier.system.views.ClientPost;
import pl.polsl.courier.system.views.ClientView;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.stream.Collectors;

@Path("/client")
public class ClientController {

    @EJB
    private ClientService clientService;

    @EJB
    private Serializer serializer;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ClientView createClient(ClientPost clientPost) {
        Client client = clientService.createClient(clientPost);
        return serializer.serialize(client);
    }

    @Path("/{clientId}")
    @PATCH
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ClientView patchClient(@PathParam("clientId") Long clientId, ClientPatch clientPatch) {
        Client client = clientService.patchClient(clientId, clientPatch);
        return serializer.serialize(client);
    }

    @Path("/{clientId}")
    @DELETE
    public void deleteClient(@PathParam("clientId") Long clientId) {
        clientService.deleteClient(clientId);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ClientView> getClients() {
        List<Client> clients = clientService.getClients();
        return clients.stream().map(serializer::serialize).collect(Collectors.toList());
    }

}
