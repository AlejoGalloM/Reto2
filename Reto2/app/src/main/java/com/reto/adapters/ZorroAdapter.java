package com.reto.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;

import com.reto.R;
import com.reto.entity.Animales;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ZorroAdapter extends BaseAdapter {

    private final List<Animales> listaAnimalesOut;
    private final List<Animales> listaAnimalesIn;
    private final LayoutInflater inflater;


    public ZorroAdapter(Context context, List<Animales> listaAnimales) {
        listaAnimalesOut = listaAnimales;
        listaAnimalesIn = listaAnimales;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() { return listaAnimalesOut.size();}

    @Override
    public Object getItem(int i) {return listaAnimalesOut.get(i);}

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ZorroAdapter.ViewHolder holder;
        if (view != null) {
            holder = (ZorroAdapter.ViewHolder) view.getTag();
        } else {
            view = inflater.inflate(R.layout.zorro_item_layout, viewGroup, false);
            holder = new ZorroAdapter.ViewHolder(view);
            view.setTag(holder);
        }

        holder.imagenZorro.setImageResource(listaAnimalesOut.get(i).getImagen());
        holder.txtZorro.setText(listaAnimalesOut.get(i).getNombre());
        holder.txtDescripcionZorro.setText(listaAnimalesOut.get(i).getDescripcion());
        return view;
    }

    class ViewHolder{
        @BindView(R.id.imagenZorro)
        ImageView imagenZorro;
        @BindView(R.id.txtZorro)
        TextView txtZorro;
        @BindView(R.id.txtDescripcionZorro)
        TextView txtDescripcionZorro;

        public ViewHolder(View view) { ButterKnife.bind(this,view); }
    }
}
