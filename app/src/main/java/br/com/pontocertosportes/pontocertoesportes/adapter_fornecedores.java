package br.com.pontocertosportes.pontocertoesportes;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import br.com.pontocertosportes.pontocertoesportes.DAO.FornecedorDAO;
import br.com.pontocertosportes.pontocertoesportes.Model.Fornecedores;

public class adapter_fornecedores extends RecyclerView.Adapter<adapter_fornecedores.MyViewHolder>  {

    private final List<Fornecedores> listaFornecedores;
    String fornecedores = null;

    public adapter_fornecedores(List<Fornecedores> list) {
        this.listaFornecedores=list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_list_fornecedores, parent, false));

    }

    public Fornecedores fornecedorEditado = null;

    public Fornecedores editFornecedor = null;

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        final Fornecedores fornecedores = listaFornecedores.get(position);

        holder.name.setText(fornecedores.getName());
        holder.cnpj.setText("CNPJ: "+ fornecedores.getCnpj());
        holder.id.setText("ID: "+ fornecedores.getId());
        holder.name.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v){
                editFornecedor = fornecedores;
            }
        });
        holder.id.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                final View view = v;
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setTitle("Confirmacao")
                        .setMessage("Tem certeza que deseja excluir esse fornecedor?")
                        .setPositiveButton("Excluir", new DialogInterface.OnClickListener(){
                            public void onClick(DialogInterface dialog, int which){
                                FornecedorDAO dao = new FornecedorDAO(view.getContext());
                                boolean sucesso = dao.excluir(fornecedores.getId());

                                if (sucesso) {
                                    removerFornecedor(fornecedores);
                                    Snackbar.make(view, "Excluiu!", Snackbar.LENGTH_LONG)
                                            .setAction("Action", null).show();
                                }else{
                                    Snackbar.make(view, "Erro ao excluir o fornecedor!", Snackbar.LENGTH_LONG)
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
    public void atualizarFornecedor(Fornecedores fornecedor){
        listaFornecedores.set(listaFornecedores.indexOf(fornecedor), fornecedor);
        notifyItemChanged(listaFornecedores.indexOf(fornecedor));
    }

    public void removerFornecedor(Fornecedores fornecedor){
        int position = listaFornecedores.indexOf(fornecedor);
        listaFornecedores.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public int getItemCount() {
        try{
            return this.listaFornecedores.size();
        }catch (Exception e) {
            return 0;
        }
    }



    public void adicionarFornecedores(Fornecedores fornecedor){
        this.listaFornecedores.add(fornecedor);
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
        TextView cnpj ;
        TextView id;

        public MyViewHolder( View itemView){
            super(itemView);

            name = itemView.findViewById(R.id.listNameFornecedor);
            cnpj = itemView.findViewById(R.id.listCnpjFornecedor);
            id = itemView.findViewById(R.id.listIdFornecedor);

        }
    }
}
