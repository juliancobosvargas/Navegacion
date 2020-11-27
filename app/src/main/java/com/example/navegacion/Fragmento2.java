package com.example.navegacion;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragmento2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragmento2 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Fragmento2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragmento2.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragmento2 newInstance(String param1, String param2) {
        Fragmento2 fragment = new Fragmento2();
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
    private ImageView img1,img2,img3,img4;
    private MediaPlayer miReproductor;
    private ImageButton detener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        vistaPuente = inflater.inflate(R.layout.fragment_fragmento2, container, false);
        img1 = (ImageView)vistaPuente.findViewById(R.id.imgson1);
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicSonido(1);
            }
        });
        img2 = (ImageView)vistaPuente.findViewById(R.id.imgson2);
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicSonido(2);
            }
        });
        img3 = (ImageView)vistaPuente.findViewById(R.id.imgson3);
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicSonido(3);
            }
        });
        img4 = (ImageView)vistaPuente.findViewById(R.id.imgson4);
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicSonido(4);
            }
        });
        //detener
        detener = (ImageButton)vistaPuente.findViewById(R.id.btnSonidoStop);
        detener.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                miStop();
            }
        });
        return vistaPuente;
    }

    private void clicSonido(int numero){
        String mensaje = "Sonido";
        switch (numero){
            case 1:
                mensaje = "Vice City";
                break;
            case 2:
                mensaje = "San Andreas";
                break;
            case 3:
                mensaje = "GTA IV";
                break;
            case 4:
                mensaje = "GTA V";
                break;
        }
        miPlay(numero);
        Toast cuadroMensaje = Toast.makeText(getContext(),mensaje, Toast.LENGTH_SHORT);;
        cuadroMensaje.setGravity(Gravity.TOP|Gravity.RIGHT,50,300);
        cuadroMensaje.show();
    }

    private void miPlay(int num){
        miStop();
        if (miReproductor == null){
            switch (num){
                case 1:
                    miReproductor = MediaPlayer.create(getContext(),R.raw.sonido01);
                    break;
                case 2:
                    miReproductor = MediaPlayer.create(getContext(),R.raw.sonido02);
                    break;
                case 3:
                    miReproductor = MediaPlayer.create(getContext(),R.raw.sonido03);
                    break;
                case 4:
                    miReproductor = MediaPlayer.create(getContext(),R.raw.sonido04);
                    break;
            }
            miReproductor.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    miStop();
                }
            });
        }
        miReproductor.start();
    }

    private void miStop(){
        if (miReproductor != null){
            miReproductor.release();
            miReproductor = null;
        }
    }
}