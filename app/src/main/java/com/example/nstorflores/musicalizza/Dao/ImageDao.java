package com.example.nstorflores.musicalizza.Dao;

import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.nstorflores.musicalizza.models.Image;

import java.util.List;

/**
 * Created by Néstor Flores on 30/4/2018.
 */

public interface ImageDao {

    @Query("Select * from Image")
    List<Image> getGenres();

    @Query("Select * from Image where id = :id")
    Image getImage(int id);

    @Delete()
    void deleteAllImages(Image image);

    @Insert
    void insertAll(Image... image);

    @Update
    void updateImage(Image image);
}
