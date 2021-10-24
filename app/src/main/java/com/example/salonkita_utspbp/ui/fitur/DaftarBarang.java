package com.example.salonkita_utspbp.ui.fitur;

import java.util.ArrayList;

public class DaftarBarang {
    public ArrayList<Barang> BARANG;

    public DaftarBarang(){
        BARANG = new ArrayList();
        BARANG.add(Pomade);
        BARANG.add(Sisir);
        BARANG.add(Cukur);
        BARANG.add(HairDrayer);
    }

    public static final Barang Pomade = new Barang("Pomade","Pengeras Rambut",120000,
            "https://www.static-src.com/wcsstore/Indraprastha/images/catalog/full//82/MTA-3005007/king-pomade_king-pomade-super-shine-ukuran-sedang-2-8-oz-aroma-sirsak_full05.jpg");

    public static final Barang Sisir = new Barang("Sisir Tony Start","Menyisir Rambut",1800000,
            "https://images.tokopedia.net/img/cache/500-square/product-1/2020/6/16/batch-upload/batch-upload_dd5bd21e-bdef-483d-b62c-a736bfde9441.jpg.webp?ect=4g");

    public static final Barang Cukur = new Barang("Mesin Cukur Elektrik","Cukur Kumis",600000,
            "https://images.tokopedia.net/img/cache/900/VqbcmM/2020/10/21/9c644601-1767-4699-8eeb-5bf65209b39a.jpg");

    public static final Barang HairDrayer = new Barang("Hair Drayer Panasunic","Pengering Rambut Sultan",8000000,
            "https://images.tokopedia.net/img/cache/900/product-1/2020/6/10/104037193/104037193_717cb16a-3801-40b9-b06e-1e4a2752286c_720_720.jpg");

}
