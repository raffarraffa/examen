package com.rafalopez.examen.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
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
                String code = binding.inputCodigo.getText().toString();
                String description = binding.inputDescripcion.getText().toString();
                double price =Double.parseDouble(binding.inputPrecio.getText().toString());
                int stock = Integer.parseInt(binding.inputStock.getText().toString());
                galleryViewModel.setProducto(code, description,price,stock,v);
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

        // Observa si el producto ha sido agregado
        galleryViewModel.getMsg().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Toast.makeText(getActivity(), s, Toast.LENGTH_SHORT).show();
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