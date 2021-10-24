package com.example.salonkita_utspbp.ui.fitur;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.salonkita_utspbp.R;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.salonkita_utspbp.AppPreferencesManager;
import com.example.salonkita_utspbp.databinding.FragmentBookBinding;
import com.example.salonkita_utspbp.databinding.FragmentOrderBinding;

import java.util.ArrayList;
/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OrderFragment#newInstance} factory method to
 * create an instance of this fragment.
 */


public class OrderFragment extends Fragment {
    private ArrayList<Barang> ListBarang;
    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;
    private RecyclerView.LayoutManager mLayoutManager;
    FragmentOrderBinding binding;
    AppPreferencesManager preferencesManager;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    // TODO: Rename and change types and number of parameters
    public static OrderFragment newInstance(String param1, String param2) {
        OrderFragment fragment = new OrderFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.
                fragment_order, container, false);
        View view = binding.getRoot();

        recyclerView = binding.recyclerViewOrder;

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        ListBarang = new DaftarBarang().BARANG;
        adapter = new RecyclerViewAdapter(getActivity(), ListBarang);
        recyclerView.setAdapter(adapter);


        return view;
    }
}
