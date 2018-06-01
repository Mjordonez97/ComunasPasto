package com.example.sistemas.DatosColombia.models;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.example.sistemas.DatosColombia.MainActivity;
import com.example.sistemas.DatosColombia.R;
import com.example.sistemas.pokeapp01.Main2Activity;

import java.util.ArrayList;

public class Adaptador extends RecyclerView.Adapter<Adaptador.DireccionViewHolder>{

    private MainActivity principal;

    ArrayList<Pokemon> datos;

    private Pokemon datos1;
    private Context context;


    public Adaptador(Context context, MainActivity pPrincpal){
        principal = pPrincpal;
        this.context = context;
        datos = new ArrayList<>();
    }


    public Adaptador(ArrayList<Pokemon> datos){
        this.datos = datos;
    }


    public class DireccionViewHolder extends RecyclerView.ViewHolder {

        private TextView text1;
        private TextView text2;
        private TextView text3;
        private TextView text4;
        private TextView text5;
        private TextView text6;
        private Button btnUbicacion;

        CardView cv;
        TextView direccion;

        DireccionViewHolder(View itemView)
        {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            direccion = (TextView)itemView.findViewById(R.id.txt1);

            text1 = (TextView) itemView.findViewById(R.id.txt1);
            text2 = (TextView) itemView.findViewById(R.id.txt2);
            text3 = (TextView) itemView.findViewById(R.id.txt3);
            text4 = (TextView) itemView.findViewById(R.id.txt4);
            text5 = (TextView) itemView.findViewById(R.id.txt5);
            text6 = (TextView) itemView.findViewById(R.id.txt6);
            btnUbicacion = (Button) itemView.findViewById(R.id.button);
        }
    }
    @Override
    public int getItemCount() {
        return datos.size();
    }

    @Override
    public DireccionViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false); //item
        DireccionViewHolder pvh = new DireccionViewHolder(v);
        return pvh;
    }
    @Override
    public void onBindViewHolder(final DireccionViewHolder direccionViewHolder, int i) {
        datos1 = datos.get(i);
        direccionViewHolder.text1.setText(""+ datos1.getComuna());
        direccionViewHolder.text2.setText("Numero JAC: " +datos1.getNMeroDeJac());
        direccionViewHolder.text3.setText("Masculino: "+datos1.getMasculino());
        direccionViewHolder.text4.setText("Femenino: " +datos1.getFemenino());
        direccionViewHolder.text5.setText("Total: " +datos1.getTotal());
        direccionViewHolder.text6.setText("Ubicación: " +datos1.getUbicaciN());

        Glide.with(context);

        direccionViewHolder.btnUbicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Prueba", direccionViewHolder.text1.getText().toString());
                principal.cambiarValor(direccionViewHolder.text1.getText().toString());
            }
        });
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public void adicionarDato(ArrayList <Pokemon> listaDatos){
        datos.addAll(listaDatos);
        notifyDataSetChanged();
    }
}
