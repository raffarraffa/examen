package com.rafalopez.examen.ui.home;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rafalopez.examen.R;
import com.rafalopez.examen.entity.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {
    //private  TreeSet<Product> products;
    public ArrayList<Product> products ;
    private LayoutInflater li;
    public ItemAdapter(TreeSet<Product> products, LayoutInflater li) {
        this.products = new ArrayList<Product>(products);
        this.li=li;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = li.inflate(R.layout.item,parent,false);
        return new ViewHolder(view);
    }

    /**
     * El metodo pra bindear los productos, no puede iterar sobre un TreeSet, ya qu eutiliza
     * position para obtenr el producto. Se convierteel treeset en ArrayList
     * @param holder The ViewHolder which should be updated to represent the contents of the
     *        item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */

     public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

            Product product = products.get(position);
            Log.d("salida", product.toString());
            holder.itemCodigo.setText(product.getCode().toString());
            holder.itemPrecio.setText(product.getPrice() +"");
            holder.itemStock.setText(product.getStock() +"");
            holder.itemDescripcion.setText(product.getDescription());

    }


    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView itemCodigo;
        TextView itemPrecio;
        TextView itemStock;
        TextView itemDescripcion;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemCodigo = itemView.findViewById(R.id.itemCodigo);
            itemPrecio = itemView.findViewById(R.id.itemPrecio);
            itemStock= itemView.findViewById(R.id.itemStock);
            itemDescripcion=itemView.findViewById(R.id.itemDescripcion);
        }
    }
}
