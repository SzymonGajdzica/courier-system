package pl.polsl.courier.system.controllers;

import pl.polsl.courier.system.services.ClientService;
import pl.polsl.courier.system.views.ClientPatch;
import pl.polsl.courier.system.views.ClientPost;
import pl.polsl.courier.system.views.ClientView;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/client")
public class ClientController {

    @EJB
    private ClientService clientService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ClientView createClient(ClientPost clientPost) {
        return clientService.createClient(clientPost);
    }

    @Path("/{clientId}")
    @PATCH
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ClientView patchClient(@PathParam("clientId") Long clientId, ClientPatch clientPatch) {
        return clientService.patchClient(clientId, clientPatch);
    }

    @Path("/{clientId}")
    @DELETE
    public void deleteClient(@PathParam("clientId") Long clientId) {
        clientService.deleteClient(clientId);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ClientView> getClients() {
        return clientService.getClients();
    }

    @Path("/{clientId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ClientView getClient(@PathParam("clientId") Long clientId) {
        return clientService.getClient(clientId);
    }

}
