package com.example.salonkita_utspbp.ui.fitur;

import static com.example.salonkita_utspbp.MyApplication.CHANNEL_1_ID;

import android.app.DatePickerDialog;
import android.app.Notification;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.example.salonkita_utspbp.R;
import com.example.salonkita_utspbp.databinding.FragmentBookBinding;
import com.example.salonkita_utspbp.twoway.Book;
import com.example.salonkita_utspbp.twoway.InputDataBook;
import com.example.salonkita_utspbp.ui.dashboard.DashboardFragment;
import com.google.gson.Gson;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class BookFragment extends FragmentActivity {
    //DEKLARADI OBJEK DAN VARIABEL
    Book book;
    FragmentBookBinding binding;

    private DatePickerDialog datePickerDialog;
    private SimpleDateFormat dateFormatter;
    private NotificationManagerCompat notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.fragment_book);

        //INISIALISASI OBJEK DAN VARIABEL
        book = new Book();
        binding.setBook(book);
//        binding.setActivity(this);

        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        notificationManager = NotificationManagerCompat.from(this);
    }

    //MEMBUAT RESPONSE CLICK LISTENER YANG AKAN DIGUNAKAN PADA LAYOUT TANGGAL MASUK PEGAWAI
    public View.OnClickListener btnDate = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Calendar newCalendar = Calendar.getInstance();
            datePickerDialog = new DatePickerDialog(BookFragment.this, new DatePickerDialog.OnDateSetListener(){
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth){
                    Calendar newDate = Calendar.getInstance();
                    newDate.set(year,monthOfYear,dayOfMonth);

                    book.setDate(dateFormatter.format(newDate.getTime()));
                }
            },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
            datePickerDialog.show();
        }
    };

    //MEMBUAT RESPONSE CLICK LISTENER YANG AKAN DIGUNAKAN PADA BUTTON KEMBALI
    public View.OnClickListener btnBackBook = new View.OnClickListener(){
        @Override
        public void onClick(View view){
            Intent mainActivity = new Intent(BookFragment.this, DashboardFragment.class);
            mainActivity.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(mainActivity);
        }
    };

    //MEMBUAT RESPONSE CLICK LISTENER YANG AKAN DIGUNAKAN PADA BUTTON SIMPAN
    public View.OnClickListener btnSaveBook = new View.OnClickListener(){
        @Override
        public void onClick(View view){
            //MEMBUAT INTENT
            Intent DetailBook = new Intent(BookFragment.this, com.example.salonkita_utspbp.twoway.DetailDataBook.class);

            //MENGUBAH OBJEK PEGAWAI MENJADI FORMAT JSON STRING DENGAN GSON
            Gson gson = new Gson();
            String strBook = gson.toJson(book);
            DetailBook.putExtra("objPgw", strBook); //MENYISIPKAN DATA JSON STRING KE INTENT

            Notification notification = new NotificationCompat.Builder(getApplicationContext(), CHANNEL_1_ID)
                    .setSmallIcon(R.drawable.ic_baseline_notifications_active_24)
                    .setStyle(new NotificationCompat.BigTextStyle()
                            .bigText("Terima kasih :)")
                            .setBigContentTitle("Berhasil Melakukan Booking Di Salon Kita")
                            .setSummaryText("Booking"))
                    .setPriority(NotificationCompat.PRIORITY_HIGH)
                    .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                    .setColor(Color.BLUE)
                    .setAutoCancel(true)
                    .setOnlyAlertOnce(true)
                    .build();

            notificationManager.notify(1, notification);

            startActivity(DetailBook); //START ACTIVITY UNTUK MEMULAI HALAMAN SELANJUTNYA
        }
    };
}
