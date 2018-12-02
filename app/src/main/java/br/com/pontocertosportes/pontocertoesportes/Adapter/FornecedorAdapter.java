package br.com.pontocertosportes.pontocertoesportes.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.com.pontocertosportes.pontocertoesportes.Model.Fornecedores;
import br.com.pontocertosportes.pontocertoesportes.Model.Funcionarios;
import br.com.pontocertosportes.pontocertoesportes.R;

import static br.com.pontocertosportes.pontocertoesportes.R.layout.adapter_list_fornecedores;
import static br.com.pontocertosportes.pontocertoesportes.R.layout.adapter_list_funcionarios;

public class FornecedorAdapter extends RecyclerView.Adapter<FornecedorAdapter.MyViewHolder> {

    private List<Fornecedores> listaFornecedores;


    public FornecedorAdapter(List<Fornecedores> list) {
        this.listaFornecedores=list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemList = LayoutInflater.from(parent.getContext())
                .inflate(adapter_list_fornecedores, parent , false);
        return new FornecedorAdapter.MyViewHolder(itemList);

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Fornecedores fornecedores = listaFornecedores.get(position);
        holder.name.setText(fornecedores.getName());
        holder.cpf.setText("CPF: "+ fornecedores.getCpf());
        holder.id.setText("ID: "+ fornecedores.getId());




    }

    @Override
    public int getItemCount() {
        try{
            return this.listaFornecedores.size();
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

            name = itemView.findViewById(R.id.listNameFornecedor);
            cpf = itemView.findViewById(R.id.listCnpjFornecedor);
            id = itemView.findViewById(R.id.listIdFornecedor);

        }
    }
}
