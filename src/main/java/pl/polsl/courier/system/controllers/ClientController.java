package pl.polsl.courier.system.controllers;

import pl.polsl.courier.system.models.Client;
import pl.polsl.courier.system.services.ClientService;
import pl.polsl.courier.system.services.CustomModelMapper;
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
    private CustomModelMapper modelMapper;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ClientView createClient(ClientPost clientPost) {
        Client client = clientService.createClient(modelMapper.map(clientPost, Client.class));
        return modelMapper.map(client, ClientView.class);
    }

    @Path("/{clientId}")
    @PATCH
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ClientView patchClient(@PathParam("clientId") Long clientId, ClientPatch clientPatch) {
        Client client = clientService.getClient(clientId);
        Client patchedClient = clientService.patchClient(client);
        return modelMapper.map(patchedClient, ClientView.class);
    }

    @Path("/{clientId}")
    @DELETE
    public void deleteClient(@PathParam("clientId") Long clientId) {
        Client client = clientService.getClient(clientId);
        clientService.deleteClient(client);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ClientView> getClients() {
        List<Client> clients = clientService.getClients();
        return clients.stream().map(client -> modelMapper.map(client, ClientView.class)).collect(Collectors.toList());
    }

    @Path("/{clientId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ClientView getClient(@PathParam("clientId") Long clientId) {
        Client client = clientService.getClient(clientId);
        return modelMapper.map(client, ClientView.class);
    }

}
