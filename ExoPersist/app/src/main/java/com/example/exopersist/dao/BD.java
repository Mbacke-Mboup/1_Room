package com.example.exopersist.dao;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.exopersist.modele.Personne;


@Database(entities = {Personne.class}, version = 2)
@TypeConverters({Converters.class})
public abstract class BD extends RoomDatabase {
    public abstract DAO dao();
}


