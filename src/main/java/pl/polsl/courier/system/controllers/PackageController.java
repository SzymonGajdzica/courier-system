package pl.polsl.courier.system.controllers;

import pl.polsl.courier.system.models.Package;
import pl.polsl.courier.system.services.PackageService;
import pl.polsl.courier.system.services.Serializer;
import pl.polsl.courier.system.views.PackageDeliveryPatch;
import pl.polsl.courier.system.views.PackagePost;
import pl.polsl.courier.system.views.PackageView;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.stream.Collectors;

@Path("/package")
public class PackageController {

    @EJB
    private PackageService packageService;

    @EJB
    private Serializer serializer;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public PackageView createPackage(PackagePost packagePost) {
        Package mPackage = packageService.createPackage(packagePost);
        return serializer.serialize(mPackage);
    }

    @Path("/{packageId}")
    @DELETE
    public void deleteClient(@PathParam("packageId") Long packageId) {
        packageService.deletePackage(packageId);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<PackageView> getPackages() {
        List<Package> packages = packageService.getPackages();
        return packages.stream().map(serializer::serialize).collect(Collectors.toList());
    }

    @Path("/{packageId}")
    @PATCH
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public PackageView deliverPackage(@PathParam("packageId") Long packageId) {
        Package mPackage = packageService.deliverPackage(packageId);
        return serializer.serialize(mPackage);
    }

    @Path("/{packageId}")
    @PATCH
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public PackageView startOfPackageDelivery(@PathParam("packageId") Long packageId,
                                              PackageDeliveryPatch packageDeliveryPatch) {
        Package mPackage = packageService.startPackageDelivery(packageId, packageDeliveryPatch);
        return serializer.serialize(mPackage);
    }

}
