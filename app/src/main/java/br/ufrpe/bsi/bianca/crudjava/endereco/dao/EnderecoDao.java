package br.ufrpe.bsi.bianca.crudjava.endereco.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import java.util.List;

import br.ufrpe.bsi.bianca.crudjava.endereco.dominio.Endereco;
import br.ufrpe.bsi.bianca.crudjava.pessoa.dominio.Pessoa;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface EnderecoDao {
    @Query("SELECT * FROM Endereco")
    public List<Endereco> getAllEnderecos();

    @Query("SELECT * FROM Endereco WHERE id = :id") //mudar para id
    public List<Endereco> getEnderecosByNome(String id);

    @Insert(onConflict = REPLACE)
    public void insert(Pessoa pessoa);

    @Update
    public void update(Pessoa pessoa);

    @Delete
    public void delete(Pessoa pessoa);
}
