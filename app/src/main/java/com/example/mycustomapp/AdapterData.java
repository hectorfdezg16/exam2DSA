package com.example.mycustomapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

//este es el adaptador que tratará nuestra lista
public class AdapterData extends RecyclerView.Adapter<AdapterData.ViewHolderData>{

    ArrayList<String> listData;

    public AdapterData(ArrayList<String> listData) {
        this.listData = listData;
    }

    @NonNull
    @Override
    public AdapterData.ViewHolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,null,false);
        //instanciamos hemos inflado anterior view
        return new ViewHolderData(view);
    }

    //enlazamos esta función con el item list que lleva nuestros repos de cada usuario
    @Override
    public void onBindViewHolder(@NonNull AdapterData.ViewHolderData holder, int position) {
        holder.addData(listData.get(position));
    }

    @Override
    public int getItemCount() {
        //este get devuelve el tamaño de la array list de repos del usuario
        return listData.size();
    }

    public class ViewHolderData extends RecyclerView.ViewHolder {

        //aqui referenciamos directamente al item list que lleva dentro todos los parametros de los diferentes repos
        //recordemos que los demás datos los pasaremos directamente
        //pero repos hemos de crear si o si recyclerView
        TextView data;


        public ViewHolderData(@NonNull View itemView) {
            super(itemView);
            data = itemView.findViewById(R.id.idData);
        }

        //habiendo creado el nuevo metodo vamos a tratar los campos
        public void addData(String s) {
            data.setText(s);
        }
    }
}
