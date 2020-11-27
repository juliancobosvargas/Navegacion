package com.example.navegacion;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragmento1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragmento1 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Fragmento1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragmento1.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragmento1 newInstance(String param1, String param2) {
        Fragmento1 fragment = new Fragmento1();
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

    // Mis Variables
    private View vistaPuente;
    private Button b1, b2,b3,b4,b5,b6,b7,b8,b9,b0;
    private TextView cuadroNum;
    private Button bMas,bMenos,bPor,bEntre,bIgual;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        vistaPuente = inflater.inflate(R.layout.fragment_fragmento1, container, false);
        b1 = (Button)vistaPuente.findViewById(R.id.btn1);
        b2 = (Button)vistaPuente.findViewById(R.id.btn2);
        b3 = (Button)vistaPuente.findViewById(R.id.btn3);
        b4 = (Button)vistaPuente.findViewById(R.id.btn4);
        b5 = (Button)vistaPuente.findViewById(R.id.btn5);
        b6 = (Button)vistaPuente.findViewById(R.id.btn6);
        b7 = (Button)vistaPuente.findViewById(R.id.btn7);
        b8 = (Button)vistaPuente.findViewById(R.id.btn8);
        b9 = (Button)vistaPuente.findViewById(R.id.btn9);
        b0 = (Button)vistaPuente.findViewById(R.id.btn0);
        bMas = (Button)vistaPuente.findViewById(R.id.btnmas);
        bMenos = (Button)vistaPuente.findViewById(R.id.btnmenos);
        bPor = (Button)vistaPuente.findViewById(R.id.btnpor);
        bEntre = (Button)vistaPuente.findViewById(R.id.btnentre);
        bIgual = (Button)vistaPuente.findViewById(R.id.btn0);
        cuadroNum = (TextView)vistaPuente.findViewById(R.id.txtcalcuNum);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numero(1);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numero(2);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numero(3);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numero(4);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numero(5);
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numero(6);
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numero(7);
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numero(8);
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numero(9);
            }
        });
        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numero(0);
            }
        });

        bMas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opera(1);
            }
        });
        bMenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opera(2);
            }
        });
        bPor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opera(3);
            }
        });
        bEntre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opera(4);
            }
        });
        bIgual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opera(5);
            }
        });
        return vistaPuente;
    }

    private String numCadena = "";
    private void numero(int num){
        numCadena = numCadena + String.valueOf(num);
        cuadroNum.setText(numCadena);
    }

    private Double primerNumero = 0.0;
    private Double segundoNumero = 0.0;
    private Double resultado = 0.0;
    private int operacionActual = 0;
    private void opera(int ope){
        try {
            if (operacionActual == 0){
                operacionActual = ope;
                primerNumero = Double.parseDouble(numCadena);
            }else{
                segundoNumero = Double.parseDouble(numCadena);
                switch (ope){
                    case 1:
                        resultado = primerNumero + segundoNumero;
                        cuadroNum.setText(resultado.toString());
                        break;

                }
            }


        } catch (NumberFormatException e){

        }

    }
}