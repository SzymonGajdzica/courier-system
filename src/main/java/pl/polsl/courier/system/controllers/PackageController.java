package pl.polsl.courier.system.controllers;

import pl.polsl.courier.system.services.PackageService;
import pl.polsl.courier.system.views.PackageDeliveryPatch;
import pl.polsl.courier.system.views.PackageGet;
import pl.polsl.courier.system.views.PackagePost;

import javax.ejb.EJB;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/package")
public class PackageController {

    @EJB
    private PackageService packageService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public PackageGet createPackage(@Valid @NotNull PackagePost packagePost) {
        return packageService.createPackage(packagePost);
    }

    @Path("/{packageId}")
    @DELETE
    public void deletePackage(@PathParam("packageId") Long packageId) {
        packageService.deletePackage(packageId);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<PackageGet> getPackages() {
        return packageService.getPackages();
    }

    @Path("/deliver/{packageId}")
    @PATCH
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public PackageGet deliverPackage(@PathParam("packageId") Long packageId) {
        return packageService.deliverPackage(packageId);
    }

    @Path("/start_delivery/{packageId}")
    @PATCH
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public PackageGet startOfPackageDelivery(@PathParam("packageId") Long packageId,
                                             @Valid @NotNull PackageDeliveryPatch packageDeliveryPatch) {
        return packageService.startPackageDelivery(packageId, packageDeliveryPatch);
    }

}
