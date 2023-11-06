package com.example.stockagedernierarret.dao;

import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;


import com.example.stockagedernierarret.modele.DateAfficher;

@Database(entities = {DateAfficher.class, }, version = 2)
@TypeConverters({Converters.class})
public abstract class BD extends RoomDatabase {
    public abstract DAO dao();
}