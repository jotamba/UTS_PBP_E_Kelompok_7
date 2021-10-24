package com.example.salonkita_utspbp.twoway;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.salonkita_utspbp.BR;

public class Book extends BaseObservable {
    public String name, phone_number, date;
    public double time;

    public Book(){}

    public Book(String name, String phone_number, double time, String date)
    {
        this.name = name;
        this.phone_number = phone_number;
        this.time = time;
        this.date = date;
    }

    @Bindable
    public String getName(){return name;}
    public void setName(String name)
    {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public String getPhone_number(){return phone_number;}
    public void setPhone_number(String phone_number)
    {
        this.phone_number = phone_number;
        notifyPropertyChanged(BR.phone_number);
    }

    @Bindable
    public double getTime(){return time;}
    public void setTime(double time)
    {
        this.time = time;
        notifyPropertyChanged(BR.time);
    }

    @Bindable
    public String getStringTime(){return String.valueOf(time);}
    public void setStringTime(String time)
    {
        if(time.isEmpty())
        {
            this.time = 0;
        }
        else
        {
            this.time = Double.parseDouble(time);
        }
        notifyPropertyChanged(BR.time);
    }

    @Bindable
    public String getDate(){return date;}
    public void setDate(String date)
    {
        this.date = date;
        notifyPropertyChanged(BR.date);
    }
}