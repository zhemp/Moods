package com.android.example.moods.data

import androidx.lifecycle.LiveData

class NoteRepository(private val noteDao: NoteDao) {

    // TODO PHASE 2.0: Define getAllNotes method - call noteDao to get all notes
    val readnote: LiveData<List<Note>> = noteDao.readnote()

    // TODO PHASE 2.0: Define addNote method - call noteDao to insert note
    suspend fun addnote(inNote:Note){
        noteDao.addnote(inNote)
    }

    // TODO PHASE 2.0: Define updateNote method - call noteDao to update note
    suspend fun updatenote(inNote:Note){
        noteDao.updatenote(inNote)
    }

    // TODO PHASE 2.0: Define deleteNote method - call noteDao to delete note
    suspend fun deletenote(inNote:Note){
        noteDao.deletenote(inNote)
    }
}