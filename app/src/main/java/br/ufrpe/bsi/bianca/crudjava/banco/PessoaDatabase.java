package br.ufrpe.bsi.bianca.crudjava.banco;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import br.ufrpe.bsi.bianca.crudjava.pessoa.dao.PessoaDao;
import br.ufrpe.bsi.bianca.crudjava.pessoa.dominio.Pessoa;

@Database(entities = {Pessoa.class}, version = 1)
public abstract class PessoaDatabase extends RoomDatabase {
    private static PessoaDatabase pessoaDatabase;

    public abstract PessoaDao createPessoaDAO();

    public static PessoaDatabase getInstance(Context context) {
        if(pessoaDatabase == null) {
            pessoaDatabase = Room.databaseBuilder(context.getApplicationContext(), PessoaDatabase.class, "driver_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }

        return pessoaDatabase;
    }
}