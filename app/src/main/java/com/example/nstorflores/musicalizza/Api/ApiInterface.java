package com.example.nstorflores.musicalizza.Api;

import com.example.nstorflores.musicalizza.models.AccessToken;
import com.example.nstorflores.musicalizza.models.Album;
import com.example.nstorflores.musicalizza.models.SongCreate;
import com.example.nstorflores.musicalizza.models.Song;
import com.example.nstorflores.musicalizza.models.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Néstor Flores on 2/3/2018.
 */
public interface ApiInterface {

    @GET("Songs?filter={\"include\":[\"song_genre\",\"song_album\"]}")
    Call<List<Song>> getSongs();

    @GET("Cancions/{id}")
    Call<SongCreate> getCancions(@Path("id") int cancionId);

    @GET("Cancions/findOne")
    Call<SongCreate> getCancionsFindOne();

    //Album
    @GET("Albums?filter={\"include\":[\"album_genre\",\"album_image\",\"album_artist\"]}")
    Call<List<Album>> getAlbums();

    @POST("Users/login")
    Call<AccessToken> login(@Body User user);

    @POST("Users")
    Call<User> signUp(@Body User user);

}

