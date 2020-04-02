package pl.polsl.controllers;

import pl.polsl.models.Client;
import pl.polsl.services.ClientService;
import pl.polsl.views.ClientPost;
import pl.polsl.views.ClientView;

import javax.ejb.EJB;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/courier")
public class ClientController {

    @EJB
    private ClientService clientService;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public ClientView createCourier(ClientPost clientPost) {
        Client client = clientService.createCourier(clientPost);
        ClientView clientView = new ClientView();
        clientView.setId(client.getId());
        clientView.setName(client.getName());
        return clientView;
    }

}
