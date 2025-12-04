package com.example.myroom1p9.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface SiswaDao {
    @Query("SELECT * FROM tblSiswa ORDER BY id ASC")
    fun getAllSiswa(): Flow<List<Siswa>>

    @Query("SELECT * FROM tblSiswa WHERE id = :id LIMIT 1")
    fun getSiswa(id: Int): Flow<Siswa?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(siswa: Siswa)

    @Delete
    suspend fun delete(siswa:Siswa)

}
