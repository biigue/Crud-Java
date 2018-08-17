package br.ufrpe.bsi.bianca.crudjava.endereco.dominio;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.Entity;
import static android.arch.persistence.room.ForeignKey.CASCADE;

import br.ufrpe.bsi.bianca.crudjava.pessoa.dominio.Pessoa;

@Entity(foreignKeys = @ForeignKey(onDelete = CASCADE, entity = Pessoa.class,
        parentColumns = "id",
        childColumns = "hooman_id"),
        indices = {@Index("hooman_id")})
public class Endereco {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String rua;
    public String numero;
    public String cep;
    public String cidade;

    @ColumnInfo(name = "hooman_id")
    public int hoomanId;

    public int getHoomanId() {
        return hoomanId;
    }

    public void setHoomanId(int hoomanId) {
        this.hoomanId = hoomanId;
    }

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

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
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
