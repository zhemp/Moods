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
import com.android.example.moods.data.NoteViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.fragment_view_note.*

class ViewNoteFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_view_note, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // TODO PHASE 1.3: Set Data on screen by grabbing Note from safe args


        // TODO PHASE 1.3: Add an on click listener to the 'pencil' FAB
        //  and use the Navigation Controller to navigation to the UpdateNoteFragment.
        //  Make sure to pass the current Note as an argument to the navigation action


        // TODO PHASE 1.3: Add an on click listener to the 'trashcan' FAB and call deleteNoteFromDB
    }

    private fun deleteNoteFromDB() {
        // TODO PHASE 2.3: Delete Note Object being viewed using NoteViewModel


        // TODO PHASE 1.3: Use the Navigation Controller to switch to NoteFeedFragment
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