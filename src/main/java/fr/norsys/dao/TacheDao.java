package fr.norsys.dao;

import fr.norsys.entities.Projet;
import fr.norsys.entities.Tache;
import fr.norsys.utils.Util;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class TacheDao implements ITache{
    private final EntityManager entityManager;
    public TacheDao() {
        entityManager = new Util().manageEntity();
    }




    @Override
    public List<Tache> rechercherTaches() {
        TypedQuery<Tache> query = entityManager.createQuery(
                "SELECT t FROM Tache t ORDER BY t.id ASC", Tache.class);
        return query.getResultList();
    }

    @Override
    public void ajouterTacheAProjet(Projet projet, Tache tache) {
        EntityTransaction transaction=entityManager.getTransaction();
        transaction.begin();
        try {
            projet.getTaches().add(tache);
            tache.setProjet(projet);
            entityManager.merge(projet);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void supprimerTachesLieesAProjet(Projet projet) {
        EntityTransaction transaction=entityManager.getTransaction();
        transaction.begin();
        try {
            entityManager.remove(projet);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }


    public void saveTache(Tache tache) {
        EntityTransaction transaction=entityManager.getTransaction();
        transaction.begin();
        try {
            entityManager.persist(tache);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }
}
