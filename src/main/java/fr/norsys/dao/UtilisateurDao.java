package fr.norsys.dao;

import fr.norsys.entities.Tache;
import fr.norsys.entities.Utilisateur;
import fr.norsys.utils.Util;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class UtilisateurDao implements IUtilisateur{
    private final EntityManager entityManager;
    public UtilisateurDao() {
        entityManager = new Util().manageEntity();
    }

    @Override
    public List<Utilisateur> rechercherUtilisateurs() {
        TypedQuery<Utilisateur> query = entityManager.createQuery(
                "SELECT u FROM Utilisateur u ORDER BY u.id ASC", Utilisateur.class);
        return query.getResultList();
    }


    public void saveUser(Utilisateur utilisateur) {
        EntityTransaction transaction=entityManager.getTransaction();
        transaction.begin();
        try {
            entityManager.persist(utilisateur);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }
}
