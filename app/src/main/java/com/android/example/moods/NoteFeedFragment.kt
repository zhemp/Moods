package com.android.example.moods

import kotlinx.android.synthetic.main.fragment_note_feed.*
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.example.moods.data.Note
import com.android.example.moods.data.NoteViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class NoteFeedFragment : Fragment() {

    private lateinit var myNoteViewModel: NoteViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_note_feed, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val happylist : MutableList<Note> = mutableListOf<Note>(
            Note(1,"health","wo rinidma","mad"),
            Note(2, "un-affairs","wo rinidma2","happy"),
            Note(3, "law-and-crime-prevention","wo rinidma3","content"),
            Note(4, "human-rights","wo rinidma4","anxious")
        )
        // TODO PHASE 1.1: Add RecyclerView
        //  you may fill the recyclerview with dummy data to test it out
        //  but you'll want to remove the dummy data when working on Phase 2
        //Recycler View
        val adapter = NoteListAdapter()
        val recyclerView = topic_recyclerview
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // ShopperViewmodel
        myNoteViewModel = ViewModelProvider(this).get(NoteViewModel::class.java)
        myNoteViewModel.readAllNoteData.observe(viewLifecycleOwner, Observer{ notes ->
           adapter.setData(notes)
        })

        /*
        val feeds = topic_recyclerview.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = NoteListAdapter(happylist)
        }
         */

        // TODO PHASE 1.1: Add an on click listener to the '+' FAB
        //  and use the Navigation Controller to navigation to the CreateNoteFragment
        val fab: View = fab_plus
        fab.setOnClickListener {
            val ac = R.id.action_noteFeedFragment_to_createNoteFragment
            it.findNavController().navigate(ac)
        }

        // TODO PHASE 2.2: Connect to the NoteViewModel and use it to update the RecyclerView's list
        //  Hint: Look at NoteListAdapter's setData method
    }
}