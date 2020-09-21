package com.reto.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.reto.R;
import com.reto.entity.Animales;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GatoAdapter extends BaseAdapter {
    private final List<Animales> listaAnimalesOut;
    private final List<Animales> listaAnimalesIn;
    private final LayoutInflater inflater;


    public GatoAdapter(Context context, List<Animales> listaAnimales) {
        listaAnimalesOut = listaAnimales;
        listaAnimalesIn = listaAnimales;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return listaAnimalesOut.size();
    }

    @Override
    public Animales getItem(int i) {
        return listaAnimalesOut.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        GatoAdapter.ViewHolder holder;
        if (view != null) {
            holder = (GatoAdapter.ViewHolder) view.getTag();
        } else {
            view = inflater.inflate(R.layout.gato_item_layout, viewGroup, false);
            holder = new GatoAdapter.ViewHolder(view);
            view.setTag(holder);
        }

        holder.imagenGato.setImageResource(listaAnimalesOut.get(i).getImagen());
        holder.Gato.setText(listaAnimalesOut.get(i).getNombre());
        holder.DescripcionGato.setText(listaAnimalesOut.get(i).getDescripcion());
        return view;
    }

    class ViewHolder{
        @BindView(R.id.imagenGato)
        ImageView imagenGato;
        @BindView(R.id.Gato)
        TextView Gato;
        @BindView(R.id.DescripcionGato)
        TextView DescripcionGato;

        public ViewHolder(View view) { ButterKnife.bind(this,view); }


    }
}
