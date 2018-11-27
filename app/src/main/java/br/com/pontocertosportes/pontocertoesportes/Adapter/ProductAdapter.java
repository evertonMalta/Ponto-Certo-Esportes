package br.com.pontocertosportes.pontocertoesportes.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import br.com.pontocertosportes.pontocertoesportes.R;


public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder> {

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemList = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_list_product, parent , false);
        return new MyViewHolder(itemList);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.name.setText("aaaaa");
        holder.price.setText("aaaaa");
        holder.qdt.setText(position);


    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        TextView price;
        TextView qdt;

        public MyViewHolder( View itemView){
            super(itemView);

            name = itemView.findViewById(R.id.listNameProduct);
            price = itemView.findViewById(R.id.listPriceProduct);
            qdt = itemView.findViewById(R.id.listQtdProduct);

        }
    }



}
