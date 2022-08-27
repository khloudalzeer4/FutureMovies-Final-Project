package com.khloud.FutureMovies.data.source.cache

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.khloud.FutureMovies.data.model.FavoriteMovie

@Dao
interface FavoriteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveFavoriteMovie(movie: FavoriteMovie)

    @Query("SELECT * FROM FavoriteMovie")
    suspend fun getAllFavMovies(): List<FavoriteMovie>

    @Query("DELETE  FROM FavoriteMovie WHERE id = :id")
    suspend fun deleteFavMovie(id: Int)

    @Query("SELECT EXISTS(SELECT * FROM FavoriteMovie WHERE id = :id)")
    suspend fun checkMovieExist(id: Int): Boolean

}