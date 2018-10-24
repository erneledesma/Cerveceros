package com.ernestoledesma.cerveceros.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ernestoledesma.cerveceros.R;
import com.ernestoledesma.cerveceros.model.Picture;
import com.ernestoledesma.cerveceros.view.PictureDetailActivity;
import com.squareup.picasso.Picasso;


import java.util.ArrayList;

// El adapter recibe una coleccion de objetos
public class PictureAdapterRecyclerView extends RecyclerView.Adapter<PictureAdapterRecyclerView.PictureViewHolder>{

   // Estas tres variables manejan los elementos de objetos pictures
    private ArrayList<Picture> pictures;
    //aqui pasamos como paramentro el obejto activity
    private  int resource;
    private Activity activity;


    // Generamos el constructor de estos tres elementos
    public PictureAdapterRecyclerView(ArrayList<Picture> pictures, int resource, FragmentActivity activity) {
        this.pictures = pictures;
        this.resource = resource;
        this.activity = activity;
    }

    /// - > Se implementan todos los metodos, estos son obligatorios
    @Override
    public  PictureViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        // inicializamos la clase viewHolder paa que encuentre todos las vistas
        View view = LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);
        return new PictureViewHolder(view);
    }

    @Override
    public void onBindViewHolder( PictureViewHolder holder, int position) {

        // Aqui trabajamos con la lista de objetos, va ir cacheando las cards que se van creando
        Picture picture = pictures.get(position);
        // a travez del objeto holder, obtengo los datos
        holder.usernameCard.setText(picture.getUserName());
        holder.timeCard.setText(picture.getTime());
        holder.likeNumberCard.setText(picture.getLike_number());


        //Modificamos el contexto, y llamamos a picture para insertar laas imagenes desde nuestra card
        Picasso.with(activity).load(picture.getPicture()).into(holder.pictureCard);

        holder.pictureCard.setOnClickListener(new View.OnClickListener() { //Implementamos el metodo onClick
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, PictureDetailActivity.class); //Le pasomos el contexto de la atividad
                activity.startActivity(intent);

            }
        });
    }

    @Override
    // Devuelve el conteo de cuantas cards tengo
    public int getItemCount() {
        return pictures.size();
    }

    // Esta clase  PictureViewHolder trabaja con todos los view de las cardView que la componen
    public class PictureViewHolder extends RecyclerView.ViewHolder{


        // Encapsulamos los objetos
        private ImageView pictureCard;
        private TextView usernameCard;
        private TextView timeCard;
        private TextView likeNumberCard;


        public PictureViewHolder(View itemView) {
            super(itemView);

            // Instanciamos sobre las clases inners

            pictureCard    =   itemView.findViewById(R.id.pictureCard);
            usernameCard   = itemView.findViewById(R.id.userNameCard);
            timeCard       =  itemView.findViewById(R.id.timeCard);
            likeNumberCard =  itemView.findViewById(R.id.likeNumberCard);


        }
    }
}
