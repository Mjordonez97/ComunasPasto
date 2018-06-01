package com.example.sistemas.DatosColombia.DatosColombia;

import com.example.sistemas.DatosColombia.models.Pokemon;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by sistemas on 23/04/18.
 */

public interface DatosColombia {

    @GET("9dsr-qz6q.json")
    Call<ArrayList<Pokemon>> obtenerListaPokemon();
}
