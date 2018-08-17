package br.ufrpe.bsi.bianca.crudjava.endereco.gui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.ufrpe.bsi.bianca.crudjava.R;
import br.ufrpe.bsi.bianca.crudjava.endereco.dominio.Endereco;
import br.ufrpe.bsi.bianca.crudjava.endereco.negocio.EnderecoNegocio;
import br.ufrpe.bsi.bianca.crudjava.infra.Sessao;

public class EditarEndereco extends AppCompatActivity {
    private EditText ruaEnd;
    private EditText numeroEnd;
    private EditText cepEnd;
    private EditText cidadeEnd;
    private Button deletarEnd;
    private Button editarEnd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_endereco);
        setTela();
    }

    private void setTela(){
        ruaEnd = findViewById(R.id.ruaEnderecoId);
        numeroEnd = findViewById(R.id.numEnderecoId);
        cepEnd = findViewById(R.id.cepId);
        cidadeEnd = findViewById(R.id.cidadeEnderecoId);
        deletarEnd = findViewById(R.id.btDeletarId);
        editarEnd = findViewById(R.id.btEditarEndId);
        setEndereco();
        deletarEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteEndereco();
            }
        });;
        editarEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editarEndereco();
            }
        });;
    }

    private void setEndereco(){
        Endereco endereco = Sessao.instance.getEndereco();
        ruaEnd.setText(endereco.getRua());
        numeroEnd.setText(endereco.getNumero());
        cepEnd.setText(endereco.getCep());
        cidadeEnd.setText(endereco.getCidade());
    }

    private void editarEndereco(){
        Endereco endereco = Sessao.instance.getEndereco();
        String rua = ruaEnd.getText().toString().trim();
        String numero = numeroEnd.getText().toString().trim();
        String cep = cepEnd.getText().toString().trim();
        String cidade = cidadeEnd.getText().toString().trim();
        endereco.setRua(rua);
        endereco.setNumero(numero);
        endereco.setCep(cep);
        endereco.setCidade(cidade);
        new EnderecoNegocio().alterarEndereco(Sessao.instance.getEndereco());
        onBackPressed();
    }

    private void deleteEndereco(){
        new EnderecoNegocio().deletarEndereco(Sessao.instance.getEndereco());
        onBackPressed();
    }
    @Override
    public void onBackPressed() {
        Sessao.instance.resetEndereco();
        startActivity(new Intent(EditarEndereco.this, ListarEnderecos.class));
        finish();
    }
}