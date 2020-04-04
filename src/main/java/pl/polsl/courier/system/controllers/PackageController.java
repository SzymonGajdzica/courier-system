package pl.polsl.courier.system.controllers;

import pl.polsl.courier.system.models.Package;
import pl.polsl.courier.system.services.CustomModelMapper;
import pl.polsl.courier.system.services.PackageService;
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
    private CustomModelMapper modelMapper;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public PackageView createPackage(PackagePost packagePost) {
        Package mPackage = modelMapper.map(packagePost, Package.class);
        Package createdPackage = packageService.createPackage(mPackage, packagePost.getClientId());
        return modelMapper.map(createdPackage, PackageView.class);
    }

    @Path("/{packageId}")
    @DELETE
    public void deleteClient(@PathParam("packageId") Long packageId) {
        Package mPackage = packageService.getPackage(packageId);
        packageService.deletePackage(mPackage);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<PackageView> getPackages() {
        List<Package> packages = packageService.getPackages();
        return packages.stream().map(mPackage -> modelMapper.map(mPackage, PackageView.class)).collect(Collectors.toList());
    }

    @Path("/{packageId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public PackageView getPackages(@PathParam("packageId") Long packageId) {
        Package mPackage = packageService.getPackage(packageId);
        return modelMapper.map(mPackage, PackageView.class);
    }

    @Path("/{packageId}")
    @PATCH
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public PackageView deliverPackage(@PathParam("packageId") Long packageId) {
        Package mPackage = packageService.getPackage(packageId);
        Package deliveredPackage = packageService.deliverPackage(mPackage);
        return modelMapper.map(deliveredPackage, PackageView.class);
    }

    @Path("/{packageId}")
    @PATCH
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public PackageView startOfPackageDelivery(@PathParam("packageId") Long packageId,
                                              PackageDeliveryPatch packageDeliveryPatch) {
        Package mPackage = packageService.getPackage(packageId);
        Package updatedPackage = packageService.startPackageDelivery(mPackage, packageDeliveryPatch.getCarId());
        return modelMapper.map(updatedPackage, PackageView.class);
    }


}
