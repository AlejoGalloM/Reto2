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

public class JirafaAdapter extends BaseAdapter {
    private final List<Animales> listaAnimalesOut;
    private final List<Animales> listaAnimalesIn;
    private final LayoutInflater inflater;


    public JirafaAdapter(Context context, List<Animales> listaAnimales) {
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

        JirafaAdapter.ViewHolder holder;
        if (view != null) {
            holder = (JirafaAdapter.ViewHolder) view.getTag();
        } else {
            view = inflater.inflate(R.layout.perro_item_layout, viewGroup, false);
            holder = new JirafaAdapter.ViewHolder(view);
            view.setTag(holder);
        }

        holder.imagenJirafa.setImageResource(listaAnimalesOut.get(i).getImagen());
        holder.Jirafa.setText(listaAnimalesOut.get(i).getNombre());
        holder.DescripcionJirafa.setText(listaAnimalesOut.get(i).getDescripcion());
        return view;
    }

    class ViewHolder{
        @BindView(R.id.imagenJirafa)
        ImageView imagenJirafa;
        @BindView(R.id.Jirafa)
        TextView Jirafa;
        @BindView(R.id.DescripcionJirafa)
        TextView DescripcionJirafa;

        public ViewHolder(View view) { ButterKnife.bind(this,view); }
    }
}
