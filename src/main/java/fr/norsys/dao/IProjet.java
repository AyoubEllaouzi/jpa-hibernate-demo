package fr.norsys.dao;

import fr.norsys.entities.Projet;
import fr.norsys.entities.Tache;

import java.util.List;

public interface IProjet {
    List<Projet> rechercherProjets();
    void persistProjet(Projet projet);

}
