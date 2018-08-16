package br.ufrpe.bsi.bianca.crudjava.pessoa.gui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import br.ufrpe.bsi.bianca.crudjava.R;
import br.ufrpe.bsi.bianca.crudjava.pessoa.dominio.Pessoa;
import br.ufrpe.bsi.bianca.crudjava.pessoa.negocio.PessoaNegocio;

public class CadastroPessoa extends AppCompatActivity {
    private EditText nomeRegistro;
    private EditText cpfRegistro;
    private EditText telefoneRegistro;
    private Button botaoRegistrar;
    private boolean error = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastropessoa);
        setTela();
        botaoRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    validarCadastro();
            }
        });
    }
    private void setTela(){
        nomeRegistro = findViewById(R.id.nomeUsuarioId);
        cpfRegistro = findViewById(R.id.cpfId);
        botaoRegistrar = findViewById(R.id.btAlterarId);
        telefoneRegistro = findViewById(R.id.telefoneId);
    }

    private boolean validarCampos(){
        boolean erro = true;
        if(validarCpf()){
            erro = false;
        }
        if(validarNome()){
            erro = false;
        }
        if(validarTelefone()){
            erro= false;
        }
        return erro;
    }

    private boolean validarTelefone(){
        boolean erro = false;
        String telefone = telefoneRegistro.getText().toString().trim();
        if(telefone.isEmpty()){
            erro = true;
            telefoneRegistro.setError("Campo em branco");
        }
        return erro;
    }

    private boolean validarCpf(){
        boolean erro = false;
        String cpf = cpfRegistro.getText().toString().trim();
        if(cpf.isEmpty()){
            erro = true;
            cpfRegistro.setError("Campo em branco");
        }else if(cpf.length() != 11){
            erro = true;
            cpfRegistro.setError("Cpf inválido");
        }
        return erro;
    }

    private boolean validarNome(){
        boolean erro = false;
        String nome = nomeRegistro.getText().toString().trim();
        if(nome.isEmpty()){
            erro = true;
            nomeRegistro.setError("Campo em branco");
        }
        return erro;
    }
    private void validarCadastro() {
        if (validarCampos()) {
            criarPessoa();
        }
    }

    private void criarPessoa(){
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(nomeRegistro.getText().toString().trim());
        pessoa.setCpf(cpfRegistro.getText().toString().trim());
        pessoa.setTelefone(telefoneRegistro.getText().toString().trim());
        new PessoaNegocio().inserirPessoa(pessoa);
        onBackPressed();
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(CadastroPessoa.this, TelaInicial.class));
        this.finish();
    }
}
