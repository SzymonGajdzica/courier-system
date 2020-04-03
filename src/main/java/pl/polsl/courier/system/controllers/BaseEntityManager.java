package pl.polsl.courier.system.controllers;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;
import javax.ws.rs.NotFoundException;
import java.util.List;

public interface BaseEntityManager extends EntityManager {

    default <T> T findOrThrow(Class<T> entityClass, Object primaryKey) {
        T object = find(entityClass, primaryKey);
        if (object == null)
            throw new NotFoundException(entityClass.getSimpleName() + "  with id " + primaryKey + " does not exists");
        return object;
    }

    default <T> List<T> findAll(Class<T> entityClass) {
        CriteriaQuery<T> cq = getCriteriaBuilder().createQuery(entityClass);
        return createQuery(cq.select(cq.from(entityClass))).getResultList();
    }

}
