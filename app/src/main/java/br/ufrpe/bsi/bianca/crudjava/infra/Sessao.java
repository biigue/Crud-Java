package br.ufrpe.bsi.bianca.crudjava.infra;

import java.util.HashMap;
import java.util.Map;
import br.ufrpe.bsi.bianca.crudjava.pessoa.dominio.Pessoa;
import br.ufrpe.bsi.bianca.crudjava.endereco.dominio.Endereco;

public class Sessao {
    public static final Sessao instance = new Sessao();
    private final Map<String, Object> values = new HashMap<>();

    private Sessao(){}

    private void setValue(String string, Object object){
        values.put(string, object);
    }

    public void setPessoa(Pessoa pessoa){
        setValue("sessao.pessoa", pessoa);
    }

    public Pessoa getPessoa(){
        return (Pessoa) values.get("sessao.pessoa");
    }

    public void resetPessoa(){
        setPessoa(null);
    }

    public void setEndereco(Endereco endereco){
        setValue("sessao.endereco", endereco);
    }

    public Endereco getEndereco(){
        return (Endereco) values.get("sessao.endereco");
    }

    public void resetEndereco(){
        setEndereco(null);
    }

    public void reset(){
        setPessoa(null);
        setEndereco(null);
    }
}