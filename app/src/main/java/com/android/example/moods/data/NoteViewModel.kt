package com.android.example.moods.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModel(application: Application): AndroidViewModel(application) {
    // TODO PHASE 2.0: declare member variables getAllNotes and repository
    val readnote: LiveData<List<Note>>
    private val repository: NoteRepository

    // TODO PHASE 2.0: initialize noteDao, repository and getAllNotes
    init{
        val noteDao = NoteDatabase.getDatabase(application).noteDao()
        repository = NoteRepository(noteDao)
        readnote = repository.readnote
    }

    // TODO PHASE 2.0: Define addNote method - call repository inside of a viewModelScope to add note
    fun addnote(inNote: Note){
        viewModelScope.launch(Dispatchers.IO){
            repository.addnote(inNote)
        }
    }

    // TODO PHASE 2.0: Define updateNote method - call repository inside of a viewModelScope to update note
    fun updatenote(inNote: Note){
        viewModelScope.launch(Dispatchers.IO){
            repository.updatenote(inNote)
        }
    }

    // TODO PHASE 2.0: Define deleteNote method - call repository inside of a viewModelScope to delete note
    fun deletenote(inNote: Note){
        viewModelScope.launch(Dispatchers.IO){
            repository.deletenote(inNote)
        }
    }
}