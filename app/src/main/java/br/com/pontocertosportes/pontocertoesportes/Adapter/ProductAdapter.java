package br.com.pontocertosportes.pontocertoesportes.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.com.pontocertosportes.pontocertoesportes.Model.Product;
import br.com.pontocertosportes.pontocertoesportes.R;

import static br.com.pontocertosportes.pontocertoesportes.R.layout.adapter_list_product;


public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder> {

    private List<Product> listaProdutos;


    public ProductAdapter(List<Product> list) {
        this.listaProdutos = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemList = LayoutInflater.from(parent.getContext())
                .inflate(adapter_list_product, parent, false);
        return new MyViewHolder(itemList);

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Product product = listaProdutos.get(position);
        holder.name.setText(product.getName());
        holder.categoria.setText("Categoria: " + product.getCategoria());
        holder.id.setText("ID: " + product.getID());


    }

    @Override
    public int getItemCount() {
        return this.listaProdutos.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView categoria;
        TextView id;

        public MyViewHolder(View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.listNameProduct);
            categoria = itemView.findViewById(R.id.listCategoriaProduct);
            id = itemView.findViewById(R.id.listIdProduct);

        }
    }


}