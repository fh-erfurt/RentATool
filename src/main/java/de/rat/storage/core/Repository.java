package de.rat.storage.core;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.lang.module.ModuleFinder;
import java.util.Collection;

public class Repository <T, ID extends Serializable> {

    private final Class<T> persistentClass;
    private EntityManager entityManager;

    public Repository(Class<T> type, EntityManager em){
        this.persistentClass = type;
        this.entityManager = em;
    }

    public T findById(final ID id){
        final T result = getEntityManager().find(persistentClass, id);
        return result;
    }

    public Collection<T> findAll(){
        Query query = getEntitiyManager().createQuery("SELECT e FROM " + getEntityClass().getEntityClass().getCanonicalName() + " e");
        return (Collection<T>) query.getResultList();
    }


}
