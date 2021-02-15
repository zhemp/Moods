package com.android.example.moods.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class NoteDatabase : RoomDatabase() {
    // sTODO PHASE 2.0: Declare abstract noteDao Function
    abstract fun NoteDao(): NoteDao

    companion object{
        @Volatile
        private var NoteINSTANCE: NoteDatabase? = null

        fun getDatabase(context: Context) : NoteDatabase{
            val tempNoteInstance = NoteINSTANCE
            if (tempNoteInstance != null){
                return tempNoteInstance
            }
            synchronized(this){
                val noteinstance = Room.databaseBuilder(
                        context.applicationContext,
                        NoteDatabase::class.java,
                        "note_table"
                ).build()
                NoteINSTANCE = noteinstance
                return noteinstance
            }
        }
    }
    // sTODO PHASE 2.0: Define companion object that returns an instance of the NoteDatabase
}