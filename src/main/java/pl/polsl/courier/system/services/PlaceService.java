package pl.polsl.courier.system.services;

import pl.polsl.courier.system.views.PlaceGet;
import pl.polsl.courier.system.views.PlacePost;

import java.util.List;

public interface PlaceService {

    PlaceGet createPlace(PlacePost placePost);

    List<PlaceGet> getPlaces();

}
