package com.example.exopersist.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import com.example.exopersist.modele.Personne;


import java.util.List;

@Dao
public abstract class DAO {

    @Insert
    public abstract Long creerPersonne(Personne personne);

    @Query("SELECT * FROM Personne WHERE sexe = :sexe")
    public abstract List<Personne> personneSelonSexe(Personne.Sexe sexe);

    @Query("SELECT * FROM Personne")
    public abstract List<Personne> ToutesPersonnes();


}
