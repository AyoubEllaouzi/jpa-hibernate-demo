package fr.norsys.dao;

import fr.norsys.entities.Projet;
import fr.norsys.entities.Tache;
import fr.norsys.entities.Utilisateur;

import java.util.List;

public interface ITache {
    List<Tache> rechercherTaches();
    void ajouterTacheAProjet(Projet projet, Tache tache);
    void supprimerTachesLieesAProjet(Projet projet);

}
