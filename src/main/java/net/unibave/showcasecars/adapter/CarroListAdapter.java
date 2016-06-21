package net.unibave.showcasecars.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import net.unibave.showcasecars.R;
import net.unibave.showcasecars.model.Carro;

import java.util.List;

public class CarroListAdapter extends BaseAdapter {

    private Context context;
    private List<Carro> carros;
    private LayoutInflater layoutInflater;

    public CarroListAdapter(Context context, List<Carro> carros) {
        if (carros == null) {
            throw new IllegalArgumentException("A variável carros não pode ser nulo");
        }
        this.context = context;
        this.carros = carros;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return carros.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO: 10/06/16 Implementar View Holder Pattern
        final View view;
        if (convertView != null) {
            view = convertView;
        } else {
            view = layoutInflater.inflate(R.layout.activity_lista_carro_item, parent, false);
        }
        Carro carro = carros.get(position);
        final ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
        Picasso.with(context).load(carro.getUrlFoto()).into(imageView);
        final TextView textView = (TextView) view.findViewById(R.id.textView);
        textView.setText(carro.getNome());
        return view;
    }

    @Override
    public Object getItem(int position) {
        return carros.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
