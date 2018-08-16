package br.ufrpe.bsi.bianca.crudjava.pessoa.gui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.ufrpe.bsi.bianca.crudjava.R;
import br.ufrpe.bsi.bianca.crudjava.infra.Sessao;
import br.ufrpe.bsi.bianca.crudjava.pessoa.dominio.Pessoa;
import br.ufrpe.bsi.bianca.crudjava.pessoa.negocio.PessoaNegocio;

public class EditarPessoa extends AppCompatActivity {
    private EditText nomeRegistro;
    private EditText cpfRegistro;
    private EditText telefoneRegistro;
    private Button botaoEditar;
    private boolean error = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_pessoa);
        setTela();
    }

    private void setTela(){
        nomeRegistro = findViewById(R.id.nomeUsuarioId);
        cpfRegistro = findViewById(R.id.cpfId);
        botaoEditar = findViewById(R.id.btAlterarId);
        telefoneRegistro = findViewById(R.id.telefoneId);
        setPessoa();
        botaoEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editarPessoa();
            }
        });;
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

    private void editarPessoa() {
        if (validarCampos()) {
            Pessoa pessoa = Sessao.instance.getPessoa();
            String nome = nomeRegistro.getText().toString().trim();
            String telefone = telefoneRegistro.getText().toString().trim();
            String cpf = cpfRegistro.getText().toString().trim();
            pessoa.setNome(nome);
            pessoa.setTelefone(telefone);
            pessoa.setCpf(cpf);
            new PessoaNegocio().atualizarPessoa(Sessao.instance.getPessoa());
            onBackPressed();
        }
    }

    private void setPessoa(){
        Pessoa pessoa = Sessao.instance.getPessoa();
        nomeRegistro.setText(pessoa.getNome());
        cpfRegistro.setText(pessoa.getCpf());
        telefoneRegistro.setText(pessoa.getTelefone());
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(EditarPessoa.this, TelaInicial.class));
        finish();
    }
}