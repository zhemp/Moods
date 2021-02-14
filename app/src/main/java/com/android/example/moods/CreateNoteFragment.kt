package com.android.example.moods

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.android.example.moods.data.Note
import com.android.example.moods.data.NoteViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.fragment_create_note.*

class CreateNoteFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_note, container, false)
    }
    fun resetOutline(){
        imageView1.setImageResource(R.drawable.ic_anxious_outline_false)
        imageView2.setImageResource(R.drawable.ic_content_outline_false)
        imageView3.setImageResource(R.drawable.ic_happy_outline_false)
        imageView6.setImageResource(R.drawable.ic_neutral_outline_false)
        imageView7.setImageResource(R.drawable.ic_sad_outline_false)
        imageView5.setImageResource(R.drawable.ic_mad_outline_false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var mood = ""
        // TODO PHASE 1.2: Add on click listener to the submission FAB that calls insertNoteIntoDB()
        fab_yes.setOnClickListener {
            val title = editTextTextPersonName.text.toString()
            val text = editTextTextPersonName2.text.toString()
            if(title == ""||text == "" || mood==""){
                Toast.makeText(activity,"something is missing", Toast.LENGTH_SHORT).show()
            }
            else {
                insertNoteIntoDB()
            }
        }


        editTextTextPersonName.requestFocus()
        editTextTextPersonName2.requestFocus()
        // TODO PHASE 1.2: Add on click listener to the cancellation FAB
        fab_no.setOnClickListener {
            val ac = R.id.action_createNoteFragment_to_noteFeedFragment
            findNavController().navigate(ac)
        }

        // TODO PHASE 1.2: Add on click listener to Mood Images to select the one that was clicked last
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


    // TODO TIP: It might be helpful to create a function that resets all the mood images to be w/o outlines


    private fun insertNoteIntoDB() {
        // TODO PHASE 2.1: Create Note Object from data inputted and add Note to Database using NoteViewModel
        // todo check if either text is empty

        // TODO PHASE 1.2: Use the Navigation Controller to switch to NoteFeedFragment
        val ac = R.id.action_createNoteFragment_to_noteFeedFragment
        findNavController().navigate(ac)
    }
}