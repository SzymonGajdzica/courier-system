package pl.polsl.courier.system.services;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.ws.rs.NotFoundException;
import java.util.List;

@Stateful
public class EntityManagerHelper {

    @PersistenceContext
    private EntityManager entityManager;

    public <T> T getOne(Class<T> entityClass, Long primaryKey) {
        T object = entityManager.find(entityClass, primaryKey);
        if (object == null)
            throw new NotFoundException(entityClass.getSimpleName() + "  with id " + primaryKey + " does not exists");
        return object;
    }

    public <T> List<T> findAll(Class<T> entityClass) {
        CriteriaQuery<T> cq = entityManager.getCriteriaBuilder().createQuery(entityClass);
        return entityManager.createQuery(cq.select(cq.from(entityClass))).getResultList();
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public <T> void removeById(Class<T> entityClass, Long primaryKey) {
        entityManager.remove(getOne(entityClass, primaryKey));
    }
}
