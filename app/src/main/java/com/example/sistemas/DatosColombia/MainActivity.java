package com.example.sistemas.DatosColombia;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.example.sistemas.DatosColombia.models.Adaptador;
import com.example.sistemas.DatosColombia.DatosColombia.DatosColombia;
import com.example.sistemas.DatosColombia.models.Pokemon;
import com.example.sistemas.pokeapp01.Acerca;
import com.example.sistemas.pokeapp01.Contacto;
import com.example.sistemas.pokeapp01.Informacion;
import com.example.sistemas.pokeapp01.Main2Activity;
import com.example.sistemas.pokeapp01.MapaComuna;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private String text_comuna;
    private Retrofit retrofit;
    private RecyclerView recyclerView;
    private Adaptador adaptador;
    private boolean aptoParaCargar;
    final String TAG = "TRANSPORTE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);


        //DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        //ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
       // drawer.addDrawerListener(toggle);
        //toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();

        retrofit = new Retrofit.Builder()
                .baseUrl("https://www.datos.gov.co/resource/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        recyclerView = (RecyclerView) findViewById(R.id.idrecyclerView);
        adaptador = new Adaptador(this,MainActivity.this);
        recyclerView.setAdapter(adaptador);
        recyclerView.setHasFixedSize(true);

        final GridLayoutManager layoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy > 0) {
                    int visibleItemCount = layoutManager.getChildCount();
                    int totalItemCount = layoutManager.getItemCount();
                    int pastVisibleItems = layoutManager.findFirstVisibleItemPosition();

                    if (aptoParaCargar) {
                        if ((visibleItemCount + pastVisibleItems) >= totalItemCount) {
                            Log.i(TAG, " Llegamos al final");
                            aptoParaCargar = false;

                            procesarDatos();
                        }
                    }
                }
            }
        });


        aptoParaCargar = true;
        procesarDatos();


    }

    private void procesarDatos() {

        DatosColombia service = retrofit.create(DatosColombia.class);
        Call<ArrayList<Pokemon>> pokemonRespuestaCall = service.obtenerListaPokemon();
        pokemonRespuestaCall.enqueue(new Callback<ArrayList<Pokemon>>() {
            public static final String TAG = "POKEAPI";

            @Override
            public void onResponse(Call<ArrayList<Pokemon>> call, Response<ArrayList<Pokemon>> response) {
                if (response.isSuccessful()) {
                    ArrayList<Pokemon> pokemonRespuesta = response.body();

                    adaptador.adicionarDato(pokemonRespuesta);
                } else {
                    Log.e(TAG, "onResponse:" + response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Pokemon>> call, Throwable t) {

                Log.e(TAG, "onFailure:" + t.getMessage());
            }
        });
    }

    public void cambiarValor(String pTexto)
    {
        text_comuna = pTexto;
        Log.i("Respuesta", text_comuna);

        ubicacion();
    }

    public void ubicacion()
    {
        Intent i = new Intent(this, MapaComuna.class);
        i.putExtra("texto_comuna", text_comuna);
        startActivity(i);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


        if (id == R.id.acerca)
        {
            Intent intent = new Intent(MainActivity.this, Acerca.class);
            startActivity(intent);
        }
        else if (id == R.id.informacion) {
            Intent intent = new Intent(MainActivity.this, Informacion.class);
            startActivity(intent);

        } else if (id == R.id.contacto) {
            Intent intent = new Intent(MainActivity.this, Contacto.class);
            startActivity(intent);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}