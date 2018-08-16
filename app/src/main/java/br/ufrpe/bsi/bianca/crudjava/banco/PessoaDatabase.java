package br.ufrpe.bsi.bianca.crudjava.banco;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import br.ufrpe.bsi.bianca.crudjava.endereco.dao.EnderecoDao;
import br.ufrpe.bsi.bianca.crudjava.endereco.dominio.Endereco;
import br.ufrpe.bsi.bianca.crudjava.pessoa.dao.PessoaDao;
import br.ufrpe.bsi.bianca.crudjava.pessoa.dominio.Pessoa;

@Database(entities = {Pessoa.class, Endereco.class}, version = 1)
public abstract class PessoaDatabase extends RoomDatabase {
    private static PessoaDatabase pessoaDatabase;

    public abstract PessoaDao PessoaDAO();
    public abstract EnderecoDao EnderecoDao();

    public static PessoaDatabase getInstance(Context context) {
        if(pessoaDatabase == null) {
            pessoaDatabase = Room.databaseBuilder(context.getApplicationContext(), PessoaDatabase.class, "pessoa")
                    .fallbackToDestructiveMigration()
                    .build();
        }

        return pessoaDatabase;
    }
}