package br.com.pontocertosportes.pontocertoesportes.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import br.com.pontocertosportes.pontocertoesportes.Model.Clients;
import br.com.pontocertosportes.pontocertoesportes.R;

import static br.com.pontocertosportes.pontocertoesportes.R.layout.adapter_list_clients;
import static br.com.pontocertosportes.pontocertoesportes.R.layout.adapter_list_product;

public class ClientAdapter extends RecyclerView.Adapter<ClientAdapter.MyViewHolder> {

    private List<Clients> listaClientes;


    public ClientAdapter(List<Clients> list) {
        this.listaClientes=list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemList = LayoutInflater.from(parent.getContext())
                .inflate(adapter_list_clients, parent , false);
        return new ClientAdapter.MyViewHolder(itemList);

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Clients clients = listaClientes.get(position);
        holder.name.setText(clients.getName());
        holder.cpf.setText("CPF: "+ clients.getCpf());
        holder.id.setText("ID: "+ clients.getId());
    }

    @Override
    public int getItemCount() {
        try{
            return this.listaClientes.size();
        }catch (Exception e){
            return 0;
        }



    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        TextView cpf ;
        TextView id;

        public MyViewHolder( View itemView){
            super(itemView);

            name = itemView.findViewById(R.id.listNameCleint);
            cpf = itemView.findViewById(R.id.listCpfClient);
            id = itemView.findViewById(R.id.listIdClient);

        }
    }
}
