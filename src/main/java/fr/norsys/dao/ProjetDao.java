package fr.norsys.dao;

import fr.norsys.entities.Projet;
import fr.norsys.entities.Tache;
import fr.norsys.utils.Util;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class ProjetDao implements IProjet{
    private final EntityManager entityManager;
    public ProjetDao() {
        entityManager = new Util().manageEntity();
    }


    @Override
    public List<Projet> rechercherProjets() {
        TypedQuery<Projet> query = entityManager.createQuery(
                "SELECT p FROM Projet p ORDER BY p.id ASC", Projet.class);
        return query.getResultList();    }

    @Override
    public void persistProjet(Projet projet) {
        EntityTransaction transaction=entityManager.getTransaction();
        transaction.begin();
        try {
            entityManager.persist(projet);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }

}
