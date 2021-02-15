package com.android.example.moods.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NoteDao {

    // TODO PHASE 2.0: Define Query to get all Notes

    @Query("SELECT * FROM note_table ORDER BY id ASC")
    fun readAllNoteData(): LiveData<List<Note>>
    // TODO PHASE 2.0: Define Query to update a Note
    @Update
    suspend fun updateNote(Note: Note)
    // TODO PHASE 2.0: Define Query to insert a Note

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addNote(Note: Note)
    // TODO PHASE 2.0: Define Query to delete a Note
    @Delete
    suspend fun deleteNote(Note: Note)
}