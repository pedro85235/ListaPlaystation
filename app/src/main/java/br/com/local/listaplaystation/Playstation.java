package br.com.local.listaplaystation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Playstation extends AppCompatActivity {
    ListView listView;

    String nomePlaystations[] = {"ps1", "ps2", "ps3", "ps4", "ps5"};

    int imagemPlaystations[] = {R.drawable.psum, R.drawable.psdois, R.drawable.pstres, R.drawable.psquatro,
            R.drawable.pscinco};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.playstation ); // layout do SuperHerois.java onde você esta localizado

        //a variavel listview está recebendo a listView XML

        //listaHerois é a id que esta localizada dentro de super_herois.xml
        listView = findViewById( R.id.idListaPlastation );

        //Criar o objeto/classe que irá inserir o modelo na listView

        CustomAdapter adapter = new CustomAdapter();

        //Carregar o baseAdapter na listView
        listView.setAdapter( adapter );

        //Criando evento de click na listView
        listView.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent( getApplicationContext(), MostraPlayStation.class );
                //Passando valores de uma janela para outra

                //nomeHerois" deve estar igual no VizualizaHerois nomeHerois é o nome do seu array
                intent.putExtra( "nomePlaystations", nomePlaystations[i] );

                //imagemHerois" deve estar igual no VizualizaHerois nomeHerois é o nome do seu array
                intent.putExtra( "imgPlaystations", imagemPlaystations[i] );

                startActivity( intent );

            }
        } );


    }

    //inner class - Classe dentro de outra Classe
    public class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return imagemPlaystations.length; //aqui tem que deixar o nome igual do seu arrays de imagens
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        //Montar o modelo para ser inserido na lista de planetas - ListView
        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {

            //aqui são as variáveis que você ira usar abaixo em txtNomeHerois e imagemHerois
            TextView NomePlaystations;
            ImageView imgPlaystations;

            //instanciando o modelo com os componentes para inserir na Lista

            //aqui é o nome do layout que ira inflar na tela no caso o lista_superherois.xml
            View carregaView = getLayoutInflater().inflate( R.layout.lista_playstation, null );

            //txtNomeHerois e imagemHerois são as variáveis que você setou a cima

            //txtListaHerois e imgListaHerois ficam detro de lista_superherois.xml
            NomePlaystations = carregaView.findViewById( R.id.txtlistaps );
            imgPlaystations = carregaView.findViewById( R.id.imglistaps );

            //Carregando os valores nos componentes

            //txtNomeHerois e imagemHerois são as variáveis que você setou a cima

            //nomeHerois e imgHerois é o nome dos seus arrays
            NomePlaystations.setText( nomePlaystations[position] );
            imgPlaystations.setImageResource( imagemPlaystations[position] );

            return carregaView;
        }
    }
}