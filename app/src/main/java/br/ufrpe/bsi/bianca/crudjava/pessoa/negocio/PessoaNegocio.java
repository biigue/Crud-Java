package br.ufrpe.bsi.bianca.crudjava.pessoa.negocio;

import java.util.List;

import br.ufrpe.bsi.bianca.crudjava.banco.PessoaDatabase;
import br.ufrpe.bsi.bianca.crudjava.infra.CrudApp;
import br.ufrpe.bsi.bianca.crudjava.pessoa.dominio.Pessoa;
import br.ufrpe.bsi.bianca.crudjava.pessoa.dao.PessoaDao;


public class PessoaNegocio {

    public void inserirPessoa(Pessoa pessoa) {
        PessoaDatabase database = PessoaDatabase.getInstance(CrudApp.getContext());
        database.PessoaDAO().insertPessoa(pessoa);
    }

    public void detelarPessoa(Pessoa pessoa) {
        PessoaDatabase database = PessoaDatabase.getInstance(CrudApp.getContext());
        database.PessoaDAO().deletePessoa(pessoa);
    }

    public void atualizarPessoa(Pessoa pessoa) {
        PessoaDatabase database = PessoaDatabase.getInstance(CrudApp.getContext());
        database.PessoaDAO().updatePessoa(pessoa);
    }

    public List<Pessoa> listarPessoas() {
        PessoaDatabase database = PessoaDatabase.getInstance(CrudApp.getContext());
        List<Pessoa> pessoasLista = database.PessoaDAO().getAllPessoas();
        return pessoasLista;
    }
}