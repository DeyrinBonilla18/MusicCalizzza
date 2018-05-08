package com.example.nstorflores.musicalizza.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Néstor Flores on 29/4/2018.
 */
@Entity
public class AlbumCreate {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "year")
    private int year;

    @ColumnInfo(name = "type")
    private String type;

    @SerializedName("image_id")
    @ColumnInfo(name = "image_id")
    private int imageId;

    @SerializedName("artist_id")
    @ColumnInfo(name = "artist_id")
    private String artistId;

    @SerializedName("genre_id")
    @ColumnInfo(name = "genre_id")
    private int genreId;

    @SerializedName("arist_id")
    @ColumnInfo(name = "arist_id")
    private int aristId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    public String getArtistId() {
        return artistId;
    }

    public void setArtistId(String artistId) {
        this.artistId = artistId;
    }

    public int getAristId() {
        return aristId;
    }

    public void setAristId(int aristId) {
        this.aristId = aristId;
    }
}
