package com.rafalopez.examen.ui.gallery;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.rafalopez.examen.MainActivity;
import com.rafalopez.examen.entity.Product;

public class GalleryViewModel extends ViewModel {

    private final MutableLiveData<String> mMsg;


    public GalleryViewModel() {
        mMsg = new MutableLiveData<>();
//        mText.setValue("This is gallery fragment");
    }
    public void setProducto(String code, String description, double price, int stock, View view) {
        Product producto = new Product();
        producto.setCode(code);
        producto.setDescription(description);
        producto.setPrice(price);
        producto.setStock(stock);
        if (!MainActivity.products.contains(producto)) {
            MainActivity.products.add(producto);
            mMsg.setValue("Producto agregado");
        } else {
            mMsg.setValue("Producto no pudo ser agregado, ya existe");
        }
        hideKeyboard(view);
    }

    public LiveData<String> getMsg() {
        return mMsg;
    }
    public void hideKeyboard(View view) {
        InputMethodManager imm = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}