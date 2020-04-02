package pl.polsl.courier.system.controllers;

import pl.polsl.courier.system.views.TestView;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/test")
public class TestController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public TestView getTest() {
        TestView testView = new TestView();
        testView.setTitle("Courier system");
        testView.setDescription("Simple backend application for couriers");
        return testView;
    }


}