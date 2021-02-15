package com.android.example.moods.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModel(application: Application): AndroidViewModel(application) {
    // aTODO PHASE 2.0: declare member variables getAllNotes and repository
    val readAllNoteData: LiveData<List<Note>>
    private val repository: NoteRepository
    // aTODO PHASE 2.0: initialize noteDao, repository and getAllNotes

    init{
        val NoteDao = NoteDatabase.getDatabase(application).NoteDao()
        repository = NoteRepository(NoteDao)
        readAllNoteData = repository.readAllNoteData
    }

    fun addNote(Note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addNote(Note)
        }
    }
    fun updateNote(Note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateNote(Note)
        }
    }
    fun deleteNote(Note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteNote(Note)
        }
    }


    // TODO PHASE 2.0: Define addNote method - call repository inside of a viewModelScope to add note

    // TODO PHASE 2.0: Define updateNote method - call repository inside of a viewModelScope to update note

    // TODO PHASE 2.0: Define deleteNote method - call repository inside of a viewModelScope to delete note
}