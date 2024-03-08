package fr.norsys.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Util {
    public EntityManager manageEntity(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("User_L");
        return entityManagerFactory.createEntityManager();
    }
}
