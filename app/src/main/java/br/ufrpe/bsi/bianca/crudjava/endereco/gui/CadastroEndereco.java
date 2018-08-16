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
import br.ufrpe.bsi.bianca.crudjava.pessoa.gui.CadastroPessoa;

public class CadastroEndereco extends AppCompatActivity {
    private EditText ruaEnd;
    private EditText numeroEnd;
    private EditText cepEnd;
    private EditText cidadeEnd;
    private Button cadastrarEnd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_endereco);
        setTela();
    }

    private void setTela(){
        ruaEnd = findViewById(R.id.ruaEnderecoId);
        numeroEnd = findViewById(R.id.numEnderecoId);
        cepEnd = findViewById(R.id.cepId);
        cidadeEnd = findViewById(R.id.cidadeEnderecoId);
        cadastrarEnd = findViewById(R.id.btConfirmarId);
        cadastrarEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadastroEndereco();
            }
        });;
    }

    private void cadastroEndereco(){
        Endereco endereco = new Endereco();
        endereco.setRua(ruaEnd.getText().toString().trim());
        endereco.setNumero(numeroEnd.getText().toString().trim());
        endereco.setCep(cepEnd.getText().toString().trim());
        endereco.setCidade(cidadeEnd.getText().toString().trim());
        new EnderecoNegocio().inserirEndereco(endereco);
        onBackPressed();
    }
    @Override
    public void onBackPressed() {
        startActivity(new Intent(CadastroEndereco.this, ListarEnderecos.class));
        finish();
    }


}
