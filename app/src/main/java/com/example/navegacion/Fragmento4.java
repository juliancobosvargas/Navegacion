package com.example.navegacion;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragmento4#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragmento4 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Fragmento4() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragmento4.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragmento4 newInstance(String param1, String param2) {
        Fragmento4 fragment = new Fragmento4();
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
    private Button bt1,bt2,bt3,bt4;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        vistaPuente = inflater.inflate(R.layout.fragment_fragmento4, container, false);
        bt1 = (Button)vistaPuente.findViewById(R.id.btnFace);
        bt2 = (Button)vistaPuente.findViewById(R.id.btnYutu);
        bt3 = (Button)vistaPuente.findViewById(R.id.btnInsta);
        bt4 = (Button)vistaPuente.findViewById(R.id.btnGogle);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirApp(1);
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirApp(2);
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirApp(3);
            }
        });
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirApp(4);
            }
        });
        return vistaPuente;
    }

    private void abrirApp(int num){
        Intent intento = null;
        switch (num){
            case 1:
                intento = getActivity().getPackageManager().getLaunchIntentForPackage("com.facebook.katana");
                startActivity(intento);
                break;
            case 2:
                intento = getActivity().getPackageManager().getLaunchIntentForPackage("com.google.android.youtube");
                startActivity(intento);
                break;
            case 3:
                intento = getActivity().getPackageManager().getLaunchIntentForPackage("com.instagram.android");
                startActivity(intento);
                break;
            case 4:
                Uri ruta = Uri.parse("https://www.google.com");
                intento = new Intent(Intent.ACTION_VIEW,ruta);
                startActivity(intento);
                break;
        }
    }
}