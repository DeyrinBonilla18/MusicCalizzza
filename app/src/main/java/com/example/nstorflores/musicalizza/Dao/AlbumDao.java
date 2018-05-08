package com.example.nstorflores.musicalizza.Dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.nstorflores.musicalizza.models.Album;

import java.util.List;

/**
 * Created by Néstor Flores on 30/4/2018.
 */
@Dao
public interface AlbumDao {

    @Query("Select * from Album")
    List<Album> getAlbums();

    @Query("Select * from Album where id = :id")
    Album getAlbum(int id);

    @Delete()
    void deleteAllAlbums(Album album);

    @Insert
    void insertAll(Album... albums);

    @Update
    void updateAlbum(Album album);
}
