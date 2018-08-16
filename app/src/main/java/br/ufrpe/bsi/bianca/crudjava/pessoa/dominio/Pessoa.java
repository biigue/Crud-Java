package br.ufrpe.bsi.bianca.crudjava.pessoa.dominio;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import android.arch.persistence.room.Embedded;

import br.ufrpe.bsi.bianca.crudjava.endereco.dominio.Endereco;


@Entity
public class Pessoa {
    @PrimaryKey(autoGenerate = true)
    public int id;
//    @ColumnInfo(name = "nome")
    public String nome;

    public String cpf;

    public String telefone;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
