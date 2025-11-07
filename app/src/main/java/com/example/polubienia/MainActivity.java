package com.example.polubienia;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button button_prev;
    private Button button_next;
    private ImageView image_view;
    private ArrayList<Zdjecie> lista;
    private RatingBar rating_bar;
    private int wybrany_obrazek = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        button_prev = findViewById(R.id.buttonPrev);
        button_next = findViewById(R.id.buttonNext);
        image_view = findViewById(R.id.imageView);
        lista = new ArrayList<>();
        rating_bar = findViewById(R.id.ratingBar);

        Zdjecie zdjecie1 = new Zdjecie("R.drawable.kot1", 0.0);
        Zdjecie zdjecie2 = new Zdjecie("R.drawable.kot2", 0.0);
        Zdjecie zdjecie3 = new Zdjecie("R.drawable.kot3", 0.0);
        Zdjecie zdjecie4 = new Zdjecie("R.drawable.kot4", 0.0);
        lista.add(zdjecie1);
        lista.add(zdjecie2);
        lista.add(zdjecie3);
        lista.add(zdjecie4);

        button_prev.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        wybrany_obrazek --;
                        if(wybrany_obrazek == -1){
                            wybrany_obrazek = lista.size()-1;
                        }
                        image_view.setImageResource(lista.get(wybrany_obrazek));
                    }
                }
        );
        button_next.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        wybrany_obrazek ++;
                        if(wybrany_obrazek > lista.size()-1){
                            wybrany_obrazek = 0;
                        }
                        image_view.setImageResource(lista.get(wybrany_obrazek));
                    }
                }
        );

    }
}