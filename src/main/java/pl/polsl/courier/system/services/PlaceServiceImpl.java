package pl.polsl.courier.system.services;

import pl.polsl.courier.system.mappers.PlaceMapper;
import pl.polsl.courier.system.models.Place;
import pl.polsl.courier.system.views.PlaceGet;
import pl.polsl.courier.system.views.PlacePost;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import java.util.List;
import java.util.stream.Collectors;

@Stateful
public class PlaceServiceImpl implements PlaceService {

    @EJB
    private PlaceMapper placeMapper;

    @EJB
    private EntityManagerHelper entityManagerHelper;

    @Override
    public PlaceGet createPlace(PlacePost placePost) {
        Place place = placeMapper.map(placePost);
        return placeMapper.map(entityManagerHelper.persist(place));
    }

    @Override
    public List<PlaceGet> getPlaces() {
        List<Place> places = entityManagerHelper.findAll(Place.class);
        return places.stream().map(placeMapper::map).collect(Collectors.toList());
    }

}
