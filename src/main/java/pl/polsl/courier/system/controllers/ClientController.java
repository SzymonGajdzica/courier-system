package pl.polsl.courier.system.controllers;

import pl.polsl.courier.system.services.ClientService;
import pl.polsl.courier.system.views.ClientGet;
import pl.polsl.courier.system.views.ClientPatch;
import pl.polsl.courier.system.views.ClientPost;

import javax.ejb.EJB;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
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
    public ClientGet createClient(@Valid @NotNull ClientPost clientPost) {
        return clientService.createClient(clientPost);
    }

    @Path("/{clientId}")
    @PATCH
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ClientGet patchClient(@PathParam("clientId") Long clientId, @Valid @NotNull ClientPatch clientPatch) {
        return clientService.patchClient(clientId, clientPatch);
    }

    @Path("/{clientId}")
    @DELETE
    public void deleteClient(@PathParam("clientId") Long clientId) {
        clientService.deleteClient(clientId);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ClientGet> getClients() {
        return clientService.getClients();
    }

    @Path("/{clientId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ClientGet getClient(@PathParam("clientId") Long clientId) {
        return clientService.getClient(clientId);
    }

}
