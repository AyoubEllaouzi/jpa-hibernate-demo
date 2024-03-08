package fr.norsys;


import fr.norsys.dao.ProjetDao;
import fr.norsys.dao.TacheDao;
import fr.norsys.dao.UtilisateurDao;
import fr.norsys.entities.Projet;
import fr.norsys.entities.Tache;
import fr.norsys.entities.Utilisateur;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProjetDao projetDao = new ProjetDao();
        TacheDao tacheDao = new TacheDao();
        UtilisateurDao utilisateurDao = new UtilisateurDao();
        // Create users
        Utilisateur utilisateur1 = new Utilisateur();
        utilisateur1.setNom("Ayoub");
        utilisateur1.setAdresseEmail("ayoub@example.com");

        Utilisateur utilisateur2 = new Utilisateur();
        utilisateur2.setNom("khalid");
        utilisateur2.setAdresseEmail("khalid@example.com");

        Utilisateur utilisateur3 = new Utilisateur();
        utilisateur3.setNom("Ahmed");
        utilisateur3.setAdresseEmail("ahmed@example.com");

        utilisateurDao.saveUser(utilisateur1);
        utilisateurDao.saveUser(utilisateur2);
        utilisateurDao.saveUser(utilisateur3);



        // Create projects
        Projet projet1 = new Projet();
        projet1.setTitre("Project 1");
        projet1.setDescription("Description of Project 1");
        projet1.setCreateur(utilisateur1);

        Projet projet2 = new Projet();
        projet2.setTitre("Project 2");
        projet2.setDescription("Description of Project 2");
        projet2.setCreateur(utilisateur2);

        Projet projet3 = new Projet();
        projet3.setTitre("Project 3");
        projet3.setDescription("Description of Project 3");
        projet3.setCreateur(utilisateur3);

        List<Projet> projets = new ArrayList<>();
        projets.add(projet1);
        projets.add(projet2);
        projets.add(projet3);

        // Persist projects
        for (Projet projet : projets) {
            projetDao.persistProjet(projet);
        }

        // Add tasks to projects
        Tache tache1 = new Tache();
        tache1.setTitre("Task 1 for Project 1");
        tache1.setDescription("Description of Task 1 for Project 1");
        tache1.setProjet(projet1);

        Tache tache2 = new Tache();
        tache2.setTitre("Task 2 for Project 1");
        tache2.setDescription("Description of Task 2 for Project 1");
        tache2.setProjet(projet1);

        Tache tache3 = new Tache();
        tache3.setTitre("Task 1 for Project 2");
        tache3.setDescription("Description of Task 1 for Project 2");
        tache3.setProjet(projet2);

        Tache tache4 = new Tache();
        tache4.setTitre("Task 1 for Project 3");
        tache4.setDescription("Description of Task 1 for Project 3");
        tache4.setProjet(projet3);



        tacheDao.saveTache(tache1);
        tacheDao.saveTache(tache2);
        tacheDao.saveTache(tache3);
        tacheDao.saveTache(tache4);
        // Output success message
        System.out.println("Projects persisted successfully!");


    }
}