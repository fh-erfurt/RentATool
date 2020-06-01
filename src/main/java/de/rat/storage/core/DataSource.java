package de.rat.storage.core;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/*
 * A connection to a database is represented by an EntityManager instance,
 * which also provides functionality for performing operations on a database.
 * The main role of an EntityManagerFactory instance is to support instantiation
 * of EntityManager instances. An EntityManagerFactory is constructed for a specific database,
 * and by managing resources efficiently (e.g. a pool of sockets),
 * provides an efficient way to construct multiple EntityManager instances for that database.*
 * */
public class DataSource{
    private static final String PERSISTENCE_UNIT_NAME = "rat-pu";
    private EntityManagerFactory entityManagerFactory;
    private static DataSource dataSourceUniqueInstance;

    private DataSource(){
        this.entityManagerFactory = Persistence.createEntityManagerFactory( PERSISTENCE_UNIT_NAME );
        entityManagerFactory.createEntityManager();
    }
    public static DataSource getDataSource(){
        if(dataSourceUniqueInstance ==null){
            dataSourceUniqueInstance =new DataSource();
        }
        return dataSourceUniqueInstance;
    }
    public EntityManager getEntityManager(){
        return  entityManagerFactory.createEntityManager();
    }

}
