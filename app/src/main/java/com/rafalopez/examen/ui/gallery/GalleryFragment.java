package com.rafalopez.examen.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.rafalopez.examen.R;
import com.rafalopez.examen.databinding.FragmentGalleryBinding;
import com.rafalopez.examen.entity.Product;

public class GalleryFragment extends Fragment {

    private FragmentGalleryBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GalleryViewModel galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);
        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        binding.btnGuarda.setOnClickListener(new View.OnClickListener(){
            Product producto = new Product();

            @Override
            public void onClick(View v) {
                producto.setCode(binding.inputCodigo.getText().toString());
                producto.setDescription(binding.inputDescripcion.getText().toString());
                producto.setPrice(Double.parseDouble(binding.inputPrecio.getText().toString()));
                producto.setStock(Integer.parseInt(binding.inputStock.getText().toString()));
                galleryViewModel.setProducto(producto);
                NavController navController = Navigation.findNavController(v);
                navController.navigate(R.id.nav_home);

            }
        });
        binding.btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController navController = Navigation.findNavController(v);
                navController.navigate(R.id.nav_home);
            }
        });

        return root;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}