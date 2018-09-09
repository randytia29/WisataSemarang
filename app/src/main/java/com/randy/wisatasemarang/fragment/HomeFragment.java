package com.randy.wisatasemarang.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.randy.wisatasemarang.R;
import com.randy.wisatasemarang.adapter.WisataAdapter;
import com.randy.wisatasemarang.helper.ServiceClient;
import com.randy.wisatasemarang.helper.ServiceGenerator;
import com.randy.wisatasemarang.model.ListWisata;
import com.randy.wisatasemarang.model.Wisata;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    RecyclerView rvHome;
    List<Wisata> listWisata = new ArrayList<>();
    ProgressDialog pd;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        rvHome = (RecyclerView) view.findViewById(R.id.rv_home);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rvHome.setLayoutManager(llm);

        ServiceClient service = ServiceGenerator.createService(ServiceClient.class);
        Call<ListWisata> getListWisata = service.getWisata("semarang");

        pd = new ProgressDialog(getActivity());
        pd.setMessage("load data from server");
        pd.show();

        getListWisata.enqueue(new Callback<ListWisata>() {
            @Override
            public void onResponse(Call<ListWisata> call, Response<ListWisata> response) {
                pd.dismiss();
                listWisata = response.body().getListWisataSemarang();
                WisataAdapter adapter = new WisataAdapter(getActivity(), listWisata);
                rvHome.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ListWisata> call, Throwable t) {
                Toast.makeText(getActivity(), "" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
