package br.com.pontocertosportes.pontocertoesportes.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.com.pontocertosportes.pontocertoesportes.Model.Clients;
import br.com.pontocertosportes.pontocertoesportes.Model.Funcionarios;
import br.com.pontocertosportes.pontocertoesportes.R;



public class FuncionarioAdapter extends RecyclerView.Adapter<FuncionarioAdapter.MyViewHolder> {

    private List<Funcionarios> listaFuncionarios;


    public FuncionarioAdapter(List<Funcionarios> list) {
        this.listaFuncionarios=list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemList = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_list_funcionarios, parent , false);
        return new FuncionarioAdapter.MyViewHolder(itemList);

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Funcionarios funcionarios = listaFuncionarios.get(position);
        holder.name.setText(funcionarios.getName());
        holder.cpf.setText("CPF: "+ funcionarios.getCpf());
        holder.id.setText("ID: "+ funcionarios.getId());




    }

    @Override
    public int getItemCount() {
        try{
            return this.listaFuncionarios.size();
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

            name = itemView.findViewById(R.id.listNameFuncionario);
            cpf = itemView.findViewById(R.id.listCpfFuncionario);
            id = itemView.findViewById(R.id.listIdFuncionario);

        }
    }
}
