package com.ernestoledesma.cerveceros.view.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ernestoledesma.cerveceros.R;
import com.ernestoledesma.cerveceros.adapter.PictureAdapterRecyclerView;
import com.ernestoledesma.cerveceros.model.Picture;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {


    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        showToolbar("", false, view);

        // Instancimos la clase
        RecyclerView picturesRecycler =  view.findViewById(R.id.picturesProfileRecycler);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        picturesRecycler.setLayoutManager(linearLayoutManager);


        PictureAdapterRecyclerView pictureAdapterRecyclerView =
                new PictureAdapterRecyclerView(buidPictures(),R.layout.cardview_picture, getActivity());
        picturesRecycler.setAdapter(pictureAdapterRecyclerView);

        return view;
    }


    // creamos un metodo constructor para el arraylist
    public ArrayList<Picture>buidPictures(){
        ArrayList<Picture> pictures = new ArrayList<>();
        pictures.add(new Picture("https://viapais.com.ar/media/cache/resolve/small/https://viapais.com.ar/files/2017/08/20170827160014_29573595_0_body.jpg","LAGASH","4 dias","3 Me gusta"));
        pictures.add(new Picture("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSXv_F88gMhjTExoE-GORZEoC4EDy-FsW61aZn68oVQZO-61tk0","Biguá","14 dias","3 Me gusta"));
        pictures.add(new Picture("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR3jI7Y0x37LvpklvluC5GJ1MspkYyIDM2QVh8DzMQt5BHCZNio","Drakar","6 dias","2 Me gusta"));
        pictures.add(new Picture("https://img.gestion.pe/files/article_content_ge_fotos/uploads/2018/03/28/5abc0dc43e169.jpeg","Patio Cervecero","6 dias","2 Me gusta"));
        pictures.add(new Picture("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSPG-4xkkPUscuxR_EohRpq2s60lsC4wYc5k3pbSuBqjOuPe-5vhA","Siete Colinas","6 dias","2 Me gusta"));
        return pictures;
    }

    public void showToolbar(String tittle, boolean upButton, View view){
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(tittle);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);

    }

}
