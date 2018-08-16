package br.ufrpe.bsi.bianca.crudjava.pessoa.gui;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;
import br.ufrpe.bsi.bianca.crudjava.R;
import br.ufrpe.bsi.bianca.crudjava.infra.CrudApp;
import br.ufrpe.bsi.bianca.crudjava.pessoa.dominio.Pessoa;

public class PessoaAdapter extends ArrayAdapter<Pessoa> {
    private List<Pessoa> elementos;
    public PessoaAdapter(@NonNull List<Pessoa> elementos) {
        super(CrudApp.getContext(), R.layout.linha_pessoas, elementos);
        this.elementos = elementos;
    }
    @Override
    public View getView(int position, View convertView,  ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) CrudApp.getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.linha_pessoas, parent, false);
        TextView nomePessoa = rowView.findViewById(R.id.pessoaId);
        TextView cpf = rowView.findViewById(R.id.cpfPessoaId);
        TextView telefone = rowView.findViewById(R.id.telefonePessoaId);
        nomePessoa.setText(elementos.get(position).getNome());
        cpf.setText(elementos.get(position).getCpf());
        telefone.setText(elementos.get(position).getTelefone());
        return rowView;
    }
}
