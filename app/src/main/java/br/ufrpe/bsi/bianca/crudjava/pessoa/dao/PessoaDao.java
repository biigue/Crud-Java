package br.ufrpe.bsi.bianca.crudjava.pessoa.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import java.util.List;

import br.ufrpe.bsi.bianca.crudjava.pessoa.dominio.Pessoa;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface PessoaDao {

    @Query("SELECT * FROM Pessoa")
    public List<Pessoa> getAllPessoas();

    @Query("SELECT * FROM Pessoa WHERE nome = :nome")
    public List<Pessoa> getPessoasByNome(String nome);

    @Insert(onConflict = REPLACE)
    public void insert(Pessoa pessoa);

    @Update
    public void update(Pessoa pessoa);

    @Delete
    public void delete(Pessoa pessoa);

}
