package br.ufrpe.bsi.bianca.crudjava.endereco.dominio;

import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.Entity;

@Entity
public class Endereco {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String rua;

    public int numero;

    public String cep;

    public String cidade;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}
