package com.example.navegacion;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragmento5#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragmento5 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Fragmento5() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragmento5.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragmento5 newInstance(String param1, String param2) {
        Fragmento5 fragment = new Fragmento5();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    //variables
    private View vistaPuente;
    private Button btn1;
    private EditText nom, ape, ing;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        vistaPuente = inflater.inflate(R.layout.fragment_fragmento5, container, false);
        btn1 = (Button)vistaPuente.findViewById(R.id.btnModifica);
        nom = (EditText)vistaPuente.findViewById(R.id.txtNom);
        ape = (EditText)vistaPuente.findViewById(R.id.txtApe);
        ing = (EditText)vistaPuente.findViewById(R.id.txtIng);

        Lector();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modificar();
            }
        });
        return vistaPuente;
    }

    private void modificar(){
        Escritor(nom.getText().toString(),ape.getText().toString(),ing.getText().toString());
    }

    //El Lector
    private void Lector() {
        SharedPreferences preferencias = getActivity().getSharedPreferences("datos", Context.MODE_PRIVATE);
        nom.setText(preferencias.getString("nombre",""));
        ape.setText(preferencias.getString("apellido",""));
        ing.setText(preferencias.getString("ingeniero",""));
    }

    //el Escritor
    private void Escritor(String nombre,String apelli,String inge) {
        SharedPreferences preferencias = getActivity().getSharedPreferences("datos",Context.MODE_PRIVATE);
        SharedPreferences.Editor objEscritor = preferencias.edit();
        objEscritor.putString("nombre",nombre);
        objEscritor.putString("apellido",apelli);
        objEscritor.putString("ingeniero",inge);
        objEscritor.commit();
    }
}