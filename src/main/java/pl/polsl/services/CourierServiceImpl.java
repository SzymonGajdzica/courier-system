package pl.polsl.services;

import pl.polsl.models.Courier;
import pl.polsl.views.CourierPost;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CourierServiceImpl implements CourierService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Courier createCourier(CourierPost courierPost) {
        Courier courier = new Courier();
        courier.setName(courierPost.getName());
        entityManager.persist(courier);
        entityManager.flush();
        return courier;
    }
}
