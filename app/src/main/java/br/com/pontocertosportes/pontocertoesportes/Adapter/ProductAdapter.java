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

import br.com.pontocertosportes.pontocertoesportes.DAO.ProdutoDAO;
import br.com.pontocertosportes.pontocertoesportes.Model.Product;
import br.com.pontocertosportes.pontocertoesportes.R;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder> {

    private List<Product> listaProdutos;
    String produto = null;

    public ProductAdapter(List<Product> list) {
        this.listaProdutos = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_list_product, parent, false));


    }

    public Product produtoEditado = null;

    public Product editProduct = null;

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        final Product product = listaProdutos.get(position);

        holder.name.setText(product.getName());
        holder.categoria.setText("Categoria: "+ product.getCategoria());
        holder.id.setText("ID: "+ product.getID());
        holder.name.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v){
                editProduct = product;
            }
        });
        holder.id.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                final View view = v;
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setTitle("Confirmacao")
                        .setMessage("Tem certeza que deseja excluir esse produto?")
                        .setPositiveButton("Excluir", new DialogInterface.OnClickListener(){
                            public void onClick(DialogInterface dialog, int which){
                                ProdutoDAO dao = new ProdutoDAO(view.getContext());
                                boolean sucesso = dao.excluir(product.getID());

                                if (sucesso) {
                                    removerProduto(product);
                                    Snackbar.make(view, "Excluiu!", Snackbar.LENGTH_LONG)
                                            .setAction("Action", null).show();
                                }else{
                                    Snackbar.make(view, "Erro ao excluir o produto!", Snackbar.LENGTH_LONG)
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
    public void atualizarProduto(Product product){
        listaProdutos.set(listaProdutos.indexOf(product), product);
        notifyItemChanged(listaProdutos.indexOf(product));
    }

    public void removerProduto(Product product){
        int position = listaProdutos.indexOf(product);
        listaProdutos.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public int getItemCount() {
        try{
            return this.listaProdutos.size();
        }catch (Exception e) {
            return 0;
        }
    }



    public void adicionarProdutos(Product product){
        this.listaProdutos.add(product);
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
        TextView categoria ;
        TextView id;

        public MyViewHolder( View itemView){
            super(itemView);

            name = itemView.findViewById(R.id.listNameProduct);
            categoria = itemView.findViewById(R.id.listCategoriaProduct);
            id = itemView.findViewById(R.id.listIdProduct);

        }
    }
}