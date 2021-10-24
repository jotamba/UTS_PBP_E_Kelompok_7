package com.example.salonkita_utspbp.twoway;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.example.salonkita_utspbp.R;
import com.example.salonkita_utspbp.databinding.TwoWayBinding;
import com.example.salonkita_utspbp.ui.dashboard.DashboardFragment;
import com.google.gson.Gson;

public class DetailDataBook extends FragmentActivity {
    Book book;
    TwoWayBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.two_way);

        //MENGAMBIL DATA DARI INTENT
        String strBook = getIntent().getStringExtra("objPgw");
        Gson gson = new Gson();
        book = gson.fromJson(strBook, Book.class);

        //INISIALISASI OBJEK DAN VARIABEL KE DATA BINDING
        binding.setBook(book);
        binding.setActivity(this);
    }

}