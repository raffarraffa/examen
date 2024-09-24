package com.rafalopez.examen.ui.gallery;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.rafalopez.examen.MainActivity;
import com.rafalopez.examen.entity.Product;

public class GalleryViewModel extends ViewModel {

    private final MutableLiveData<String> mText;


    public GalleryViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }
    public void setProducto(Product producto){
        MainActivity.products.add(producto);

    }

    public LiveData<String> getText() {
        return mText;
    }
}