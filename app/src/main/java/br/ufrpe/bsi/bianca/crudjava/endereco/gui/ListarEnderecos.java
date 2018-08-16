package br.ufrpe.bsi.bianca.crudjava.endereco.gui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

import br.ufrpe.bsi.bianca.crudjava.R;
import br.ufrpe.bsi.bianca.crudjava.endereco.dominio.Endereco;
import br.ufrpe.bsi.bianca.crudjava.endereco.negocio.EnderecoNegocio;
import br.ufrpe.bsi.bianca.crudjava.infra.Sessao;
import br.ufrpe.bsi.bianca.crudjava.pessoa.dominio.Pessoa;

public class ListarEnderecos extends AppCompatActivity {
    private Button cadastraEndereco;
    private List<Endereco> enderecoLista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_enderecos);
        setTela();
    }

    public void setTela(){
        cadastraEndereco = findViewById(R.id.btCadastrarEndId);
        cadastraEndereco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadastroEnd();
            }
        });;
        enderecoLista = new EnderecoNegocio().listarEnderecos();
        ListView listView = findViewById(R.id.reformaListaId);
        listView.setAdapter(new EnderecoAdapter(enderecoLista));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                posiEnd(position);
            }
        });
    }

    public void cadastroEnd(){
        startActivity(new Intent(ListarEnderecos.this, CadastroEndereco.class));
        finish();
    }

    public void posiEnd(int position){
        Sessao.instance.setEndereco(enderecoLista.get(position));
        startActivity(new Intent(ListarEnderecos.this, EditarEndereco.class));
        finish();
    }
}
