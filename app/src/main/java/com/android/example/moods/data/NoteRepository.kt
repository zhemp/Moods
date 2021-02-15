package com.android.example.moods.data

import androidx.lifecycle.LiveData

class NoteRepository(private val noteDao: NoteDao) {

    // aTODO PHASE 2.0: Define getAllNotes method - call noteDao to get all notes
    val readAllNoteData: LiveData<List<Note>> = noteDao.readAllNoteData()

    suspend fun addNote(Note: Note){
        noteDao.addNote(Note)
    }
    suspend fun updateNote(Note: Note){
        noteDao.updateNote(Note)
    }
    suspend fun deleteNote(Note: Note){
        noteDao.deleteNote(Note)
    }

    // aTODO PHASE 2.0: Define addNote method - call noteDao to insert note

    // aTODO PHASE 2.0: Define updateNote method - call noteDao to update note

    // TaODO PHASE 2.0: Define deleteNote method - call noteDao to delete note
}