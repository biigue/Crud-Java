package br.ufrpe.bsi.bianca.crudjava.endereco.gui;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;
import br.ufrpe.bsi.bianca.crudjava.R;
import br.ufrpe.bsi.bianca.crudjava.endereco.dominio.Endereco;
import br.ufrpe.bsi.bianca.crudjava.infra.MyApplication;


public class EnderecoAdapter extends ArrayAdapter<Endereco> {
    private List<Endereco> elementos;
    public EnderecoAdapter(@NonNull List<Endereco> elementos) {
        super(MyApplication.getContext(), R.layout.linha_endereco, elementos);
        this.elementos = elementos;
    }
    @Override
    public View getView(int position, View convertView,  ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) MyApplication.getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.linha_endereco, parent, false);
        TextView rua = rowView.findViewById(R.id.ruaId);
        TextView numero = rowView.findViewById(R.id.numeroId);
        TextView cep = rowView.findViewById(R.id.cepId);
        TextView cidade = rowView.findViewById(R.id.cidadeId);
        rua.setText(elementos.get(position).getRua());
        numero.setText(elementos.get(position).getNumero());
        cep.setText(elementos.get(position).getCep());
        cidade.setText(elementos.get(position).getCidade());
        return rowView;
    }
}
