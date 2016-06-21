package net.unibave.showcasecars.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

import net.unibave.showcasecars.R;
import net.unibave.showcasecars.adapter.CarroListAdapter;
import net.unibave.showcasecars.model.Carro;
import net.unibave.showcasecars.service.CarroService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListaCarroFragment extends Fragment {

    public static final String TAG = ListaCarroFragment.class.getSimpleName();
    private ListView listView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lista_carro, container, false);
        listView = (ListView) view.findViewById(R.id.listView);
        refreshListView();
        return view;
    }

    private void refreshListView() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://unibave-schambeck.rhcloud.com/showcase-web/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CarroService service = retrofit.create(CarroService.class);
        long idCategoria = getArguments().getLong("idCategoria");
        service.listar(idCategoria).enqueue(new Callback<List<Carro>>() {
            @Override
            public void onResponse(Call<List<Carro>> call, Response<List<Carro>> response) {
                List<Carro> carros = response.body();
                BaseAdapter adapter = new CarroListAdapter(getActivity(), carros);
                listView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Carro>> call, Throwable t) {
                Log.e(TAG, t.getMessage(), t);
                Toast.makeText(getActivity(), "Falha ao carregar categorias",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
