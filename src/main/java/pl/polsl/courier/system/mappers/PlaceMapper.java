package pl.polsl.courier.system.mappers;

import pl.polsl.courier.system.models.Place;
import pl.polsl.courier.system.views.PlaceGet;
import pl.polsl.courier.system.views.PlacePost;

public interface PlaceMapper {

    Place map(PlacePost placePost);

    PlaceGet map(Place place);

}
