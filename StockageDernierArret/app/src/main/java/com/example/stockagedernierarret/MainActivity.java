package com.example.stockagedernierarret;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.stockagedernierarret.dao.BD;
import com.example.stockagedernierarret.databinding.ActivityMainBinding;
import com.example.stockagedernierarret.modele.DateAfficher;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

ActivityMainBinding binding;
BD bd;
    public Date heure;
    int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        heure = new Date();
        View view = binding.getRoot();
        setContentView(view);

        bd = Room.inMemoryDatabaseBuilder(getApplicationContext(), BD.class)
                .allowMainThreadQueries()
                .build();
        Toast.makeText(getApplicationContext(), "Premiere Fois", Toast.LENGTH_LONG).show();


    }

    @Override
    protected void onStop() {
        super.onStop();
        i++;
        DateAfficher dateAfficher = new DateAfficher();
        dateAfficher.date = new Date();
        bd.dao().ajouterHeure(dateAfficher);


    }

    @Override
    protected void onResume() {
        super.onResume();
        if(i != 0){
            DateAfficher dateAfficher = bd.dao().getHeure();
            binding.textView.setText(dateAfficher.date.toString());
        }


    }
}