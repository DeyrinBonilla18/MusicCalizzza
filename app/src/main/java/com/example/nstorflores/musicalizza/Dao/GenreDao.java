package com.example.nstorflores.musicalizza.Dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.nstorflores.musicalizza.models.Genre;

import java.util.List;

/**
 * Created by Néstor Flores on 30/4/2018.
 */
@Dao
public interface GenreDao {

    @Query("Select * from Genre")
    List<Genre> getGenres();

    @Query("Select * from Genre where id = :id")
    Genre getGenre(int id);

    @Delete()
    void deleteAllGenres(Genre genre);

    @Insert
    void insertAll(Genre... Genres);

    @Update
    void updateGenre(Genre Genres);

}
