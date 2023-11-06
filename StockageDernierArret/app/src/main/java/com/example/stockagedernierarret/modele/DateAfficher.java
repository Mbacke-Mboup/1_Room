package com.example.stockagedernierarret.modele;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity
public class DateAfficher {
    @PrimaryKey(autoGenerate = true)
    public Long id;

    @ColumnInfo
    public Date date;
}
