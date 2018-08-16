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

    @Query("SELECT * FROM Endereco WHERE hooman_id = :id")
    public List<Endereco> getEnderecosById(int id);

    @Insert(onConflict = REPLACE)
    public void insertEndereco(Endereco endereco);

    @Update
    public void updateEndereco(Endereco endereco);

    @Delete
    public void deleteEndereco(Endereco endereco);
}
