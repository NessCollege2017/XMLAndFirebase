package ness.edu.xmlandfirebase;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import java.util.List;

//TODO: SET the adapter.
/**
 * A fragment representing a list of Ynet Items.
 */
public class YnetArticleFragment extends Fragment implements YnetDataSource.OnYnetArrivedListener {

    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        recyclerView = (RecyclerView)
                inflater.inflate(R.layout.fragment_ynetarticle, container, false);


        YnetDataSource.getYnet(this);


        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return recyclerView;
    }

    @Override
    public void onYnetArrived(final List<YnetDataSource.Ynet> data, final Exception e) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (e == null)
                    Toast.makeText(getContext(), data.toString(), Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getContext(), e.toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }


}
