package com.example.salonkita_utspbp.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.salonkita_utspbp.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TransaksiDashboardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TransaksiDashboardFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private CardView cardHome,cardOrder;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TransaksiDashboardFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TransaksiDashboardFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TransaksiDashboardFragment newInstance(String param1, String param2) {
        TransaksiDashboardFragment fragment = new TransaksiDashboardFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_transaksi_dashboard, container, false);
        cardHome = view.findViewById(R.id.book);
        cardOrder = view.findViewById(R.id.order);

        cardHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                Navigation.findNavController(view).navigate(R.id.action_nav_dashboard_transaksi_to_nav_transaksi);
            }
        });

        cardOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                Navigation.findNavController(view).navigate(R.id.action_nav_dashboard_transaksi_to_nav_transaksi_food);

            }
        });


        return view;
    }
}