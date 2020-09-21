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

public class OsoAdapter extends BaseAdapter {
    private final List<Animales> listaAnimalesOut;
    private final List<Animales> listaAnimalesIn;
    private final LayoutInflater inflater;


    public OsoAdapter(Context context, List<Animales> listaAnimales) {
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

        OsoAdapter.ViewHolder holder;
        if (view != null) {
            holder = (OsoAdapter.ViewHolder) view.getTag();
        } else {
            view = inflater.inflate(R.layout.oso_item_layout, viewGroup, false);
            holder = new OsoAdapter.ViewHolder(view);
            view.setTag(holder);
        }

        holder.imagenOso.setImageResource(listaAnimalesOut.get(i).getImagen());
        holder.Oso.setText(listaAnimalesOut.get(i).getNombre());
        holder.DescripcionOso.setText(listaAnimalesOut.get(i).getDescripcion());
        return view;
    }

    class ViewHolder{
        @BindView(R.id.imagenOso)
        ImageView imagenOso;
        @BindView(R.id.Oso)
        TextView Oso;
        @BindView(R.id.DescripcionOso)
        TextView DescripcionOso;

        public ViewHolder(View view) { ButterKnife.bind(this,view); }
    }
}
