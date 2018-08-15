package br.ufrpe.bsi.bianca.crudjava.pessoa.gui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import br.ufrpe.bsi.bianca.crudjava.R;

public class EditarPessoa extends AppCompatActivity {
    private EditText nomeRegistro;
    private EditText cpfRegistro;
    private EditText telefoneRegistro;
    private Button botaoRegistrar;
    private boolean error = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastropessoa);
    }
}