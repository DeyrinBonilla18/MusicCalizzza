package com.example.nstorflores.musicalizza.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.nstorflores.musicalizza.Dao.SongDao;
import com.example.nstorflores.musicalizza.models.SongCreate;

/**
 * Created by User on 12/04/2018.
 */

@Database(entities = {SongCreate.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase{
    public abstract SongDao cancionDao();
}
