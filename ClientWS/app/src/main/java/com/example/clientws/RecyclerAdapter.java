package com.example.clientws;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.Collections;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    List<Contact> data= Collections.emptyList();
    Contact current;
    int currentPos=0;

    // create constructor to innitilize context and data sent from MainActivity
    public RecyclerAdapter(Context context, List<Contact> data){
        this.context=context;
        inflater= LayoutInflater.from(context);
        this.data=data;
    }

    // Inflate the layout when viewholder created
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_view, parent, false);
        MyHolder holder=new MyHolder(view);
        return holder;
    }

    // Bind data
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        // Get current position of item in recyclerview to bind data and assign values from list
        MyHolder myHolder= (MyHolder) holder;
        Contact current=data.get(position);
        myHolder.textId.setText("ID: " + current.idcontact);
        myHolder.textNom.setText("Nom: " + current.nom);
        myHolder.textPrenom.setText("Prenom: " + current.prenom);


    }

    // return total item from List
    @Override
    public int getItemCount() {
        return data.size();
    }


    class MyHolder extends RecyclerView.ViewHolder{

        TextView textId;
        TextView textNom;
        TextView textPrenom;

        // create constructor to get widget reference
        public MyHolder(View itemView) {
            super(itemView);
            textId= (TextView) itemView.findViewById(R.id.id);
            textNom = (TextView) itemView.findViewById(R.id.nom);
            textPrenom = (TextView) itemView.findViewById(R.id.prenom);
        }

    }

}
