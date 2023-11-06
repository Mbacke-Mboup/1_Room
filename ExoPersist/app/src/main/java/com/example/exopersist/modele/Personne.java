package com.example.exopersist.modele;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity
//@Entity(indices = {@Index("artiste")})
public class Personne {

    public enum Sexe{
        HOMME,
        FEMME,
        COMPLEXE
    }
    @PrimaryKey(autoGenerate = true)
    public Long id;

    @ColumnInfo
    public String Nom;

    @ColumnInfo
    public Date DateNaissance;

    @ColumnInfo
    public Sexe sexe;

}
