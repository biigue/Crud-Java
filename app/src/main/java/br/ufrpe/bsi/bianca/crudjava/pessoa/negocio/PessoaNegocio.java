package br.ufrpe.bsi.bianca.crudjava.pessoa.negocio;

import java.util.List;

import br.ufrpe.bsi.bianca.crudjava.banco.PessoaDatabase;
import br.ufrpe.bsi.bianca.crudjava.pessoa.dominio.Pessoa;


public class PessoaNegocio {

    public void inserirPessoa(Pessoa pessoa) {
        PessoaDatabase database = PessoaDatabase.getInstance();
        database.PessoaDAO().insertPessoa(pessoa);
    }

    public void detelarPessoa(Pessoa pessoa) {
        PessoaDatabase database = PessoaDatabase.getInstance();
        database.PessoaDAO().deletePessoa(pessoa);
    }

    public void atualizarPessoa(Pessoa pessoa) {
        PessoaDatabase database = PessoaDatabase.getInstance();
        database.PessoaDAO().updatePessoa(pessoa);
    }

    public List<Pessoa> listarPessoas() {
        PessoaDatabase database = PessoaDatabase.getInstance();
        List<Pessoa> pessoasLista = database.PessoaDAO().getAllPessoas();
        return pessoasLista;
    }
}