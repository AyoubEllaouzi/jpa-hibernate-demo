package fr.norsys.dao;

import fr.norsys.entities.Utilisateur;

import java.util.List;

public interface IUtilisateur {
    List<Utilisateur> rechercherUtilisateurs();
}
