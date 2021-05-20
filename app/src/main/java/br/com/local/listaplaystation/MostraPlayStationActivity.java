package br.com.local.listaplaystation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MostraPlayStationActivity extends AppCompatActivity {

    TextView txtPlaystations;
    ImageView imgPlaystations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mostra_playstation_station);

        txtPlaystations = findViewById(R.id.txtlistaps);
        imgPlaystations = findViewById(R.id.imglistaps);

        Intent intent = getIntent();
        String nPlaystations = intent.getStringExtra("nomePlaystations");
        int mPlaystations = intent.getIntExtra("imgPlaystations",0);

        txtPlaystations.setText(nPlaystations);
        imgPlaystations.setImageResource(mPlaystations);
    }

}