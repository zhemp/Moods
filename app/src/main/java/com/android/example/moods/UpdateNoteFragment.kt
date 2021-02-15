package com.android.example.moods

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.android.example.moods.data.Note
import com.android.example.moods.data.NoteViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.fragment_create_note.*
import kotlinx.android.synthetic.main.fragment_update_note.*
import kotlinx.android.synthetic.main.fragment_update_note.editTextTextPersonName
import kotlinx.android.synthetic.main.fragment_update_note.editTextTextPersonName2
import kotlinx.android.synthetic.main.fragment_update_note.imageView1
import kotlinx.android.synthetic.main.fragment_update_note.imageView2
import kotlinx.android.synthetic.main.fragment_update_note.imageView3
import kotlinx.android.synthetic.main.fragment_update_note.imageView5
import kotlinx.android.synthetic.main.fragment_update_note.imageView6
import kotlinx.android.synthetic.main.fragment_update_note.imageView7
import kotlinx.android.synthetic.main.fragment_view_note.*

class UpdateNoteFragment : Fragment() {

    val args: UpdateNoteFragmentArgs by navArgs()
    private lateinit var myNoteViewModel : NoteViewModel

    fun resetOutline(){
        imageView1.setImageResource(R.drawable.ic_anxious_outline_false)
        imageView2.setImageResource(R.drawable.ic_content_outline_false)
        imageView3.setImageResource(R.drawable.ic_happy_outline_false)
        imageView6.setImageResource(R.drawable.ic_neutral_outline_false)
        imageView7.setImageResource(R.drawable.ic_sad_outline_false)
        imageView5.setImageResource(R.drawable.ic_mad_outline_false)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_update_note, container, false)

        myNoteViewModel = ViewModelProvider(this).get(NoteViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var mood = ""

        // TODO PHASE 1.4: Set Data on screen by grabbing Note from safe args
        //  (EditTexts, ImageViews, and so on ...)
        var note_edit = args.noteEdit
        editTextTextPersonName.setText(note_edit.title)
        editTextTextPersonName2.setText(note_edit.content)
        when (note_edit.reaction) {
            "anxious" -> imageView1.setImageResource(R.drawable.ic_anxious_outline_true)
            "content" -> imageView2.setImageResource(R.drawable.ic_content_outline_true)
            "happy" -> imageView3.setImageResource(R.drawable.ic_happy_outline_true)
            "mad" -> imageView5.setImageResource(R.drawable.ic_mad_outline_true)
            "neutral" -> imageView6.setImageResource(R.drawable.ic_neutral_outline_true)
            "sad" -> imageView7.setImageResource(R.drawable.ic_sad_outline_true)
            else -> { // Note the block
                view_note_image.setImageResource(R.drawable.ic_empty_state)
            }
        }



        // TODO PHASE 1.4: Add an on click listener to the submission FAB that
        //  calls updateNoteIntoDB()
        fab_yes_1.setOnClickListener {
            val title = editTextTextPersonName.text.toString()
            val text = editTextTextPersonName2.text.toString()
            if(title == ""||text == "" || mood==""){
                Toast.makeText(activity,"something is missing", Toast.LENGTH_SHORT).show()
            }
            else {
                val nnote = Note(note_edit.id,title,text,mood)
                updateNoteIntoDB(nnote)
            }
        }


        // TODO PHASE 1.4: Add an on click listener to the cancellation FAB that
        //  sends the user back to NoteFeedFragment
        fab_no_1.setOnClickListener {
            val ac = R.id.action_updateNoteFragment_to_noteFeedFragment
            findNavController().navigate(ac)
        }


        // TODO PHASE 1.4: Add an on click listeners to Mood Images to select
        //  the one that was clicked last
        imageView1.setOnClickListener{
            resetOutline()
            mood = "anxious"
            imageView1.setImageResource(R.drawable.ic_anxious_outline_true)
        }
        imageView2.setOnClickListener{
            resetOutline()
            mood = "content"
            imageView2.setImageResource(R.drawable.ic_content_outline_true)
        }
        imageView3.setOnClickListener{
            resetOutline()
            mood = "happy"
            imageView3.setImageResource(R.drawable.ic_happy_outline_true)
        }
        imageView6.setOnClickListener{
            resetOutline()
            mood = "neutral"
            imageView6.setImageResource(R.drawable.ic_neutral_outline_true)
        }
        imageView7.setOnClickListener{
            resetOutline()
            mood = "sad"
            imageView7.setImageResource(R.drawable.ic_sad_outline_true)
        }
        imageView5.setOnClickListener{
            resetOutline()
            mood = "mad"
            imageView5.setImageResource(R.drawable.ic_mad_outline_true)
        }
    }

    private fun updateNoteIntoDB(note:Note) {
        // TODO PHASE 2.4: Create(or update) a Note Object from data inputted on the screen
        //  and add said Note to Database using NoteViewModel
        myNoteViewModel.updateNote(note)


        // TODO PHASE 1.4: Use the Navigation Controller to switch to NoteFeedFragment
            val ac = R.id.action_updateNoteFragment_to_noteFeedFragment
            findNavController().navigate(ac)
    }

    // Feel free to use/update this function if you find parts of it useful for your implementation
    private fun setMoodImage(view: ImageView, mood: String) {
        when (mood) {
            "anxious" -> view.setImageResource(R.drawable.ic_anxious_outline_false)
            "content" -> view.setImageResource(R.drawable.ic_content_outline_false)
            "happy" -> view.setImageResource(R.drawable.ic_happy_outline_false)
            "mad" -> view.setImageResource(R.drawable.ic_mad_outline_false)
            "neutral" -> view.setImageResource(R.drawable.ic_neutral_outline_false)
            "sad" -> view.setImageResource(R.drawable.ic_sad_outline_false)
            else -> {
                view.setImageResource(R.drawable.ic_empty_state)
            }
        }
    }
}