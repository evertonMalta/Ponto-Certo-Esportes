package br.com.pontocertosportes.pontocertoesportes.Adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;

import java.util.List;

import br.com.pontocertosportes.pontocertoesportes.Activity.ListClientsActivity;
import br.com.pontocertosportes.pontocertoesportes.Activity.LoginActivity;
import br.com.pontocertosportes.pontocertoesportes.Activity.ViewClientActivity;
import br.com.pontocertosportes.pontocertoesportes.DAO.ClientDAO;
import br.com.pontocertosportes.pontocertoesportes.Model.Clients;
import br.com.pontocertosportes.pontocertoesportes.R;

import static br.com.pontocertosportes.pontocertoesportes.R.layout.adapter_list_clients;
import static br.com.pontocertosportes.pontocertoesportes.R.layout.adapter_list_product;

public class ClientAdapter extends RecyclerView.Adapter<ClientAdapter.MyViewHolder>  {

    private final List<Clients> listaClientes;
    String cliente = null;

    public ClientAdapter(List<Clients> list) {
        this.listaClientes=list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_list_clients, parent, false));

    }

    public Clients clienteEditado = null;

    public Clients editClient = null;

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        final Clients clients = listaClientes.get(position);

        holder.name.setText(clients.getName());
        holder.cpf.setText("CPF: "+ clients.getCpf());
        holder.id.setText("ID: "+ clients.getId());
        holder.name.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v){
                editClient = clients;
            }
        });
        holder.id.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                final View view = v;
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setTitle("Confirmacao")
                        .setMessage("Tem certeza que deseja excluir esse cliente?")
                        .setPositiveButton("Excluir", new DialogInterface.OnClickListener(){
                            public void onClick(DialogInterface dialog, int which){
                                ClientDAO dao = new ClientDAO(view.getContext());
                                boolean sucesso = dao.excluir(clients.getId());

                                if (sucesso) {
                                    removerCliente(clients);
                                    Snackbar.make(view, "Excluiu!", Snackbar.LENGTH_LONG)
                                            .setAction("Action", null).show();
                                }else{
                                    Snackbar.make(view, "Erro ao excluir o cliente!", Snackbar.LENGTH_LONG)
                                            .setAction("Action", null).show();
                                }
                            }
                })
                .setNegativeButton("Cancelar", null)
                        .create()
                        .show();
            }
        });
    }
    public void atualizarCliente(Clients cliente){
        listaClientes.set(listaClientes.indexOf(cliente), cliente);
        notifyItemChanged(listaClientes.indexOf(cliente));
    }

    public void removerCliente(Clients clients){
        int position = listaClientes.indexOf(clients);
        listaClientes.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public int getItemCount() {
        try{
            return this.listaClientes.size();
        }catch (Exception e) {
            return 0;
        }
    }



     public void adicionarCliente(Clients cliente){
        this.listaClientes.add(cliente);
        notifyItemInserted(getItemCount());
     }

     private Activity getActivity(View view){
        Context context = view.getContext();
        while (context instanceof ContextWrapper){
            if (context instanceof Activity){
                return (Activity)context;
            }
            context = ((ContextWrapper)context).getBaseContext();
        }
        return null;
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
