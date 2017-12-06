package br.com.fiap.placarapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {

    private String timeCasa;
    private String timeVisitante;

    private TextView tvTimeCasa;
    private TextView tvVisitante;

    private TextView tvPlacarCasa;
    private TextView tvPlacarVisitante;

    private int golCasa;
    private int golVisitante;


        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_game);

        tvTimeCasa = (TextView) findViewById(R.id.tvTimeCasa);
        tvVisitante = (TextView) findViewById(R.id.tvTimeVisitante);

        tvPlacarCasa = (TextView) findViewById(R.id.tvPlacarCasa);
        tvPlacarVisitante = (TextView) findViewById(R.id.tvPlacarVisitante);

        if (getIntent() != null)
        {
            timeCasa = getIntent().getStringExtra("TIMECASA");
            timeVisitante = getIntent().getStringExtra("TIMEVISITANTE");

            tvTimeCasa.setText(timeCasa);
            tvVisitante.setText(timeVisitante);

            if(savedInstanceState != null) {
                golCasa = savedInstanceState.getInt("GOLCASA");
                golVisitante = savedInstanceState.getInt("GOLVISITANTE");

            }
                tvPlacarCasa.setText(String.valueOf(golCasa));
                tvPlacarVisitante.setText(String.valueOf(golVisitante));

        }
    }


    public void golCasa (View v){
       golCasa++;
        tvPlacarCasa.setText(String.valueOf(golCasa));
    }

    public void golVisitante (View v){
        tvPlacarVisitante.setText(String.valueOf(golVisitante));
        golVisitante++;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("GOLCASA", golCasa);
        outState.putInt("GOLVISITANTE", golVisitante);
    }
}
