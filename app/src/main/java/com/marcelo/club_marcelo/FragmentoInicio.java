package com.marcelo.club_marcelo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class FragmentoInicio extends Fragment {

    View view;
    Button botonInicio;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        view = inflater.inflate(R.layout.fragment_inicio, container, false);

        botonInicio= (Button) view.findViewById(R.id.btnInicio);
        botonInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Iniciando...", Toast.LENGTH_LONG).show();

            }
        });

        return view;

    }



}
