package br.com.pontocertosportes.pontocertoesportes.Adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import br.com.pontocertosportes.pontocertoesportes.DAO.FuncionarioDAO;
import br.com.pontocertosportes.pontocertoesportes.Model.Clients;
import br.com.pontocertosportes.pontocertoesportes.Model.Funcionarios;
import br.com.pontocertosportes.pontocertoesportes.R;



public class FuncionarioAdapter extends RecyclerView.Adapter<FuncionarioAdapter.MyViewHolder> {

    private final List<Funcionarios> listaFuncionarios;
    String funcionario = null;

    public FuncionarioAdapter(List<Funcionarios> list) {
        this.listaFuncionarios=list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_list_funcionarios, parent, false));

    }

    public Funcionarios funcionarioEditado = null;

    public Funcionarios editFuncionario = null;

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        final Funcionarios funcionarios = listaFuncionarios.get(position);

        holder.name.setText(funcionarios.getName());
        holder.cpf.setText("CPF: "+ funcionarios.getCpf());
        holder.id.setText("ID: "+ funcionarios.getId());
        holder.name.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v){ editFuncionario = funcionarios; }
        });
        holder.id.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                final View view = v;
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setTitle("Confirmacao")
                        .setMessage("Tem certeza que deseja excluir esse funcionario?")
                        .setPositiveButton("Excluir", new DialogInterface.OnClickListener(){
                            public void onClick(DialogInterface dialog, int which){
                                FuncionarioDAO dao = new FuncionarioDAO(view.getContext());
                                boolean sucesso = dao.excluir(funcionarios.getId());

                                if (sucesso) {
                                    removerFuncionario(funcionarios);
                                    Snackbar.make(view, "Excluiu!", Snackbar.LENGTH_LONG)
                                            .setAction("Action", null).show();
                                }else{
                                    Snackbar.make(view, "Erro ao excluir o funcionario!", Snackbar.LENGTH_LONG)
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
    public void atualizarFuncionario(Funcionarios funcionario){
        listaFuncionarios.set(listaFuncionarios.indexOf(funcionario), funcionario);
        notifyItemChanged(listaFuncionarios.indexOf(funcionario));
    }

    public void removerFuncionario(Funcionarios funcionario){
        int position = listaFuncionarios.indexOf(funcionario);
        listaFuncionarios.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public int getItemCount() {
        try{
            return this.listaFuncionarios.size();
        }catch (Exception e) {
            return 0;
        }
    }



    public void adicionarFuncionario(Funcionarios funcionario){
        this.listaFuncionarios.add(funcionario);
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

            name = itemView.findViewById(R.id.listNameFuncionario);
            cpf = itemView.findViewById(R.id.listCpfFuncionario);
            id = itemView.findViewById(R.id.listIdFuncionario);

        }
    }
}
