package br.ufrpe.bsi.bianca.crudjava.pessoa.gui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

import br.ufrpe.bsi.bianca.crudjava.R;
import br.ufrpe.bsi.bianca.crudjava.endereco.gui.ListarEnderecos;
import br.ufrpe.bsi.bianca.crudjava.infra.Sessao;
import br.ufrpe.bsi.bianca.crudjava.pessoa.dominio.Pessoa;
import br.ufrpe.bsi.bianca.crudjava.pessoa.negocio.PessoaNegocio;

public class TelaInicial extends AppCompatActivity {
    private Button cadastraPessoa;
    private List<Pessoa> pessoasLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicial);
        setTela();
    }

    public void setTela(){
        cadastraPessoa = findViewById(R.id.btCadastrarPessoa);
        cadastraPessoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadastro();
            }
        });;
        pessoasLista = new PessoaNegocio().listarPessoas();
        ListView listView = findViewById(R.id.reformaListaId);
        listView.setAdapter(new PessoaAdapter(pessoasLista));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                posiPessoa(position);
            }
        });
    }

    public void cadastro(){
        startActivity(new Intent(TelaInicial.this, CadastroPessoa.class));
        finish();
    }

    public void posiPessoa(int position){
        Sessao.instance.setPessoa(pessoasLista.get(position));
        startActivity(new Intent(TelaInicial.this, ListarEnderecos.class));
        finish();
    }
}
