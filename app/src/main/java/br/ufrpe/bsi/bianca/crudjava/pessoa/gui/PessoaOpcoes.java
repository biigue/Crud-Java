package br.ufrpe.bsi.bianca.crudjava.pessoa.gui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.ufrpe.bsi.bianca.crudjava.R;
import br.ufrpe.bsi.bianca.crudjava.endereco.gui.ListarEnderecos;
import br.ufrpe.bsi.bianca.crudjava.infra.Sessao;
import br.ufrpe.bsi.bianca.crudjava.pessoa.negocio.PessoaNegocio;

public class PessoaOpcoes extends AppCompatActivity {
    private Button verEnderecos;
    private Button editarPessoa;
    private Button deletarPessoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pessoa_opcoes);
        setTela();
    }

    private void setTela(){
        verEnderecos = findViewById(R.id.btEnderecosId);
        editarPessoa = findViewById(R.id.btEditEndrecoId);
        deletarPessoa = findViewById(R.id.btDeletarId);
        verEnderecos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verListaEnderecos();
            }
        });;
        editarPessoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updatePessoa();
            }
        });;
        deletarPessoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deletePessoa();
            }
        });;
    }

    private void updatePessoa(){
        startActivity(new Intent(PessoaOpcoes.this, EditarPessoa.class));
        this.finish();
    }

    private void verListaEnderecos(){
        startActivity(new Intent(PessoaOpcoes.this, ListarEnderecos.class));
        this.finish();
    }

    private void deletePessoa(){
        new PessoaNegocio().detelarPessoa(Sessao.instance.getPessoa());
        onBackPressed();
    }

    @Override
    public void onBackPressed() {
        Sessao.instance.resetPessoa();
        startActivity(new Intent(PessoaOpcoes.this, TelaInicial.class));
        finish();
    }
}