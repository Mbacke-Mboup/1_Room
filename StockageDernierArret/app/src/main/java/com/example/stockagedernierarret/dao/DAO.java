package com.example.stockagedernierarret.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.stockagedernierarret.modele.DateAfficher;

import java.util.Date;

@Dao
public abstract class DAO {

    @Insert
    public abstract void ajouterHeure(DateAfficher date);

    @Update
    public abstract void update(DateAfficher date);

    @Query("SELECT * FROM DateAfficher ORDER BY date DESC LIMIT 1")
    public  abstract DateAfficher getHeure();
}
