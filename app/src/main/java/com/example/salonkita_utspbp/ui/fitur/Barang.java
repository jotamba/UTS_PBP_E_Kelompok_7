package com.example.salonkita_utspbp.ui.fitur;


import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

public class Barang {

    public String nama;
    public String kegunaan;
    public Integer harga;
    public String imgURL;

    public Barang(String nama, String kegunaan, Integer harga, String imgURL) {
        this.nama = nama;
        this.kegunaan = kegunaan;
        this.harga = harga;
        this.imgURL = imgURL;
    }

    public String getKegunaan() {
        return kegunaan;
    }

    public void setKegunaan(String kegunaan) {
        this.kegunaan = kegunaan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(Integer harga) {
        this.harga=harga;
    }



    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }


    @BindingAdapter("android:loadImage")
    public static void loadImage(ImageView imageView, String imgURL){
        Glide.with(imageView)
                .load(imgURL)
                .into(imageView);
    }
}
