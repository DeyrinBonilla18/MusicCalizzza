package com.example.nstorflores.musicalizza.Dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.nstorflores.musicalizza.models.SongCreate;

/**
 * Created by User on 12/04/2018.
 */

@Dao
public interface SongDao {
    @Query("Select * from SongCreate where title like :nombre")
    SongCreate getCancion(String nombre);

    @Delete()
    void deleteAllcancions(SongCreate songCreate);

    @Insert
    void insertAll(SongCreate... songCreates);

    @Update
    void updateUser(SongCreate songCreate);

}
