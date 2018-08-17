package br.ufrpe.bsi.bianca.crudjava.banco;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import br.ufrpe.bsi.bianca.crudjava.endereco.dao.EnderecoDao;
import br.ufrpe.bsi.bianca.crudjava.endereco.dominio.Endereco;
import br.ufrpe.bsi.bianca.crudjava.infra.MyApplication;
import br.ufrpe.bsi.bianca.crudjava.pessoa.dao.PessoaDao;
import br.ufrpe.bsi.bianca.crudjava.pessoa.dominio.Pessoa;

@Database(entities = {Pessoa.class, Endereco.class}, version = 2)
public abstract class PessoaDatabase extends RoomDatabase {
    private static PessoaDatabase pessoaDatabase;

    public abstract PessoaDao PessoaDAO();
    public abstract EnderecoDao EnderecoDao();

    public static PessoaDatabase getInstance() {
        if(pessoaDatabase == null) {
            pessoaDatabase = Room.databaseBuilder(MyApplication.getContext(), PessoaDatabase.class, "pessoa")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }

        return pessoaDatabase;
    }
}