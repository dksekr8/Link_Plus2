package com.example.linkmain.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    public MutableLiveData<String> category = new MutableLiveData<>();

    public HomeViewModel() {
        category.setValue(null);
    }
    public void sigong(){
        category.setValue("sigong");
    }
    public void bosu(){
        category.setValue("bosu");
    }
    public void gonggu(){
        category.setValue("gonggu");
    }
    public void jungu(){
        category.setValue("jungu");
    }
    public void car(){
        category.setValue("car");
    }

    public LiveData<String> getText() { return category; }
}