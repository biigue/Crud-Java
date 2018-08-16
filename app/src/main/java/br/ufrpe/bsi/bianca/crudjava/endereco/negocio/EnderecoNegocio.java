package br.ufrpe.bsi.bianca.crudjava.endereco.negocio;

import java.util.List;

import br.ufrpe.bsi.bianca.crudjava.banco.PessoaDatabase;
import br.ufrpe.bsi.bianca.crudjava.endereco.dominio.Endereco;
import br.ufrpe.bsi.bianca.crudjava.infra.CrudApp;
import br.ufrpe.bsi.bianca.crudjava.endereco.dao.EnderecoDao;
import br.ufrpe.bsi.bianca.crudjava.infra.Sessao;

public class EnderecoNegocio {
    public void inserirEndereco(Endereco endereco) {
        PessoaDatabase database = PessoaDatabase.getInstance(CrudApp.getContext());
        database.EnderecoDao().insertEndereco(endereco);
    }

    public void alterarEndereco(Endereco endereco) {
        PessoaDatabase database = PessoaDatabase.getInstance(CrudApp.getContext());
        database.EnderecoDao().updateEndereco(endereco);

    }

    public void deletarEndereco(Endereco endereco) {
        PessoaDatabase database = PessoaDatabase.getInstance(CrudApp.getContext());
        database.EnderecoDao().deleteEndereco(endereco);

    }

    public List<Endereco> listarEnderecos() {
        PessoaDatabase database = PessoaDatabase.getInstance(CrudApp.getContext());
        List<Endereco> enderecosList = database.EnderecoDao().getEnderecosById(Sessao.instance.getPessoa().getId());
        return enderecosList;
    }
}