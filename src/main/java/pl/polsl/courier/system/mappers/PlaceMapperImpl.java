package pl.polsl.courier.system.mappers;

import pl.polsl.courier.system.models.Place;
import pl.polsl.courier.system.views.LatLng;
import pl.polsl.courier.system.views.PlaceGet;
import pl.polsl.courier.system.views.PlacePost;

import javax.ejb.Stateful;

@Stateful
public class PlaceMapperImpl implements PlaceMapper {

    @Override
    public Place map(PlacePost placePost) {
        Place place = new Place();
        place.setLatitude(placePost.getLatLng().getLatitude());
        place.setLongitude(placePost.getLatLng().getLongitude());
        place.setName(placePost.getName());
        return place;
    }

    @Override
    public PlaceGet map(Place place) {
        PlaceGet placeGet = new PlaceGet();
        placeGet.setId(place.getId());
        placeGet.setName(place.getName());
        placeGet.setLatLng(new LatLng(place.getLatitude(), place.getLongitude()));
        return placeGet;
    }

}
