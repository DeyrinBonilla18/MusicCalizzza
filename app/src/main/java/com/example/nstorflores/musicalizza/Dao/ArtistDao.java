package com.example.nstorflores.musicalizza.Dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.nstorflores.musicalizza.models.Artist;

import java.util.List;

/**
 * Created by Néstor Flores on 30/4/2018.
 */
@Dao
public interface ArtistDao {

    @Query("Select * from Artist")
    List<Artist> getArtists();

    @Query("Select * from Artist where id = :id")
    Artist getArtist(int id);

    @Delete()
    void deleteAllArtists(Artist artist);

    @Insert
    void insertAll(Artist... artists);

    @Update
    void updateArtist(Artist artist);
}
