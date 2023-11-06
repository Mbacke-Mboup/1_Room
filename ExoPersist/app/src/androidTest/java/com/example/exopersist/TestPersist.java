package com.example.exopersist;

import android.content.Context;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import com.example.exopersist.dao.BD;
import com.example.exopersist.modele.Personne;

import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class TestPersist {
    @Test
    public void creerPeuPersonne() {
        int size = 10;
        // Context of the app under test.
        Context context = ApplicationProvider.getApplicationContext();
        BD bd = Room.inMemoryDatabaseBuilder(context, BD.class).build();

        for(int i= 0; i< size; i++){
            Personne personne = new Personne();
            personne.Nom = "La Personne "+ String.valueOf(i);
            personne.DateNaissance = new Date();
            int random = new Random().nextInt(2);
            if(random == 0) personne.sexe = Personne.Sexe.FEMME;
            if(random == 1) personne.sexe = Personne.Sexe.HOMME;
            if(random == 2) personne.sexe = Personne.Sexe.COMPLEXE;
            bd.dao().creerPersonne(personne);
        }
        List<Personne> ps = bd.dao().ToutesPersonnes();
        assertEquals(size, ps.size());
        bd.close();
    }

    @Test
    public void creerBeaucoupPersonnes() {
        int size = 100;
        // Context of the app under test.
        Context context = ApplicationProvider.getApplicationContext();
        BD bd = Room.inMemoryDatabaseBuilder(context, BD.class).build();

        for(int i= 0; i < size; i++){
            Personne personne = new Personne();
            personne.Nom = "La Personne "+ String.valueOf(i);
            personne.DateNaissance = new Date();
            int random = new Random().nextInt(2);
            if(random == 0) personne.sexe = Personne.Sexe.FEMME;
            if(random == 1) personne.sexe = Personne.Sexe.HOMME;
            if(random == 2) personne.sexe = Personne.Sexe.COMPLEXE;
            bd.dao().creerPersonne(personne);
        }
        List<Personne> ps = bd.dao().ToutesPersonnes();
        assertEquals(size, ps.size());
        bd.close();
    }

    @Test
    public void FiltrePersonneGenreHomme() {
        int size = 10;
        int hommes = 0;

        // Context of the app under test.
        Context context = ApplicationProvider.getApplicationContext();
        BD bd = Room.inMemoryDatabaseBuilder(context, BD.class).build();

        for(int i= 0; i < size; i++){
            Personne personne = new Personne();
            personne.Nom = "La Personne "+ String.valueOf(i);
            personne.DateNaissance = new Date();
            int random = new Random().nextInt(2);
            if(random == 0) {
                personne.sexe = Personne.Sexe.FEMME;

            };
            if(random == 1) {
                personne.sexe = Personne.Sexe.HOMME;
                hommes++;
            };
            if(random == 2) {
                personne.sexe = Personne.Sexe.COMPLEXE;

            }
            bd.dao().creerPersonne(personne);
        }
        List<Personne> pHommes = bd.dao().personneSelonSexe(Personne.Sexe.HOMME);

        assertEquals(hommes,pHommes.size() );
        bd.close();
    }

    @Test
    public void FiltrePersonneGenreFemmes() {
        int size = 10;
        int femmes = 0;
        // Context of the app under test.
        Context context = ApplicationProvider.getApplicationContext();
        BD bd = Room.inMemoryDatabaseBuilder(context, BD.class).build();

        for(int i= 0; i < size; i++){
            Personne personne = new Personne();
            personne.Nom = "La Personne "+ String.valueOf(i);
            personne.DateNaissance = new Date();
            int random = new Random().nextInt(2);
            if(random == 0) {
                personne.sexe = Personne.Sexe.FEMME;
                femmes++;
            };
            if(random == 1) {
                personne.sexe = Personne.Sexe.HOMME;

            };
            if(random == 2) {
                personne.sexe = Personne.Sexe.COMPLEXE;

            }
            bd.dao().creerPersonne(personne);
        }
        List<Personne> pFemmes = bd.dao().personneSelonSexe(Personne.Sexe.FEMME);
        assertEquals(femmes,pFemmes.size() );
        bd.close();
    }

    @Test
    public void FiltrePersonneGenreComplexe() {
        int size = 10;
        int complexes = 0;
        // Context of the app under test.
        Context context = ApplicationProvider.getApplicationContext();
        BD bd = Room.inMemoryDatabaseBuilder(context, BD.class).build();

        for(int i= 0; i < size; i++){
            Personne personne = new Personne();
            personne.Nom = "La Personne "+ String.valueOf(i);
            personne.DateNaissance = new Date();
            int random = new Random().nextInt(2);
            if(random == 0) {
                personne.sexe = Personne.Sexe.FEMME;

            };
            if(random == 1) {
                personne.sexe = Personne.Sexe.HOMME;

            };
            if(random == 2) {
                personne.sexe = Personne.Sexe.COMPLEXE;
                complexes++;
            }
            bd.dao().creerPersonne(personne);
        }
        List<Personne> pComplexes = bd.dao().personneSelonSexe(Personne.Sexe.COMPLEXE);
        assertEquals(complexes,pComplexes.size() );
        bd.close();
    }
}