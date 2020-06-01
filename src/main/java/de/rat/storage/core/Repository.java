package de.rat.storage.core;

import de.rat.model.BaseModel;


import javax.persistence.EntityManager;
import javax.persistence.PreUpdate;
import javax.persistence.Query;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public abstract class Repository<T extends BaseModel> {

    private DataSource dataSource;

    public Repository() {
        dataSource = DataSource.getDataSource();
    }

    //String can be also entire object we want to change
    @PreUpdate
    protected abstract void updateOperation(T model, String argument);


    public Integer create(T model) {
        EntityManager entityManager = dataSource.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(model);
        entityManager.flush();
        entityManager.getTransaction().commit();
        return model.getId();

    }
    public void update(T model, String argument) {
        EntityManager entityManager = dataSource.getEntityManager();
        entityManager.getTransaction().begin();
        updateOperation(model, argument);
        entityManager.merge(model);
        entityManager.getTransaction().commit();
    }

    public void delete(T model) {
        EntityManager entityManager = dataSource.getEntityManager();
        entityManager.getTransaction().begin();
        model=entityManager.merge(model);


        entityManager.remove(model);
        entityManager.getTransaction().commit();
    }

    public T findOne(T model){
        EntityManager entityManager = dataSource.getEntityManager();
        return (T) entityManager.find(model.getClass(), model.getId());
    }


    public List<T> getAll(String className){
        EntityManager entityManager = dataSource.getEntityManager();
        Query query = entityManager.createQuery(
                "SELECT c FROM "+className+" c");
        return (List<T>) query.getResultList();
    }

    public void delete( List<T> entries )
    {
        EntityManager entityManager = dataSource.getEntityManager();
        entityManager.getTransaction().begin();
        for( T entry : entries )
        {
            entityManager.remove( entry );
        }
        entityManager.getTransaction().commit();
    }
}
