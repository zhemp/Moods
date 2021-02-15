package com.android.example.moods

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.android.example.moods.data.Note
import kotlinx.android.synthetic.main.noteslist_item.view.*

class NoteListAdapter(): RecyclerView.Adapter<NoteListAdapter.NoteViewHolder>() {
    private var mNoteList = emptyList<Note>()

    class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)  {
        // TODO PHASE 1.1: Define Views in ViewHolder
            val entryView : LinearLayout = itemView.findViewById(R.id.note_container)
            val t1View : TextView = itemView.findViewById(R.id.t1)
            val t2View : TextView = itemView.findViewById(R.id.t2)
            val image1 : ImageView = itemView.findViewById(R.id.moodpreview)
        /*
    val id: Int,
    t1  =====  val title: String?,
    t2  =====  val content: String?,
    val reaction: String?
         */

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.noteslist_item, parent, false)
        return NoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        // TODO PHASE 1.1: Update views in layout with Note data from the current
        //  Note ine the list based on the given position
        holder.t1View.text = mNoteList[position].title
        holder.t2View.text = mNoteList[position].content
        //  not very sure about the code below.
        setMoodImage(holder.image1,  mNoteList[position].reaction!!)

        holder.entryView.setOnClickListener {
            //val ac = R.id.action_noteFeedFragment_to_viewNoteFragment
            val ac = NoteFeedFragmentDirections.actionNoteFeedFragmentToViewNoteFragment(mNoteList[position])
            it.findNavController().navigate(ac)
        }

        // TODO PHASE 1.1: Add a click listener on the container view of one notelist_item and
        //  use the Navigation Controller to switch to the ViewNoteFragment Screen. Make sure to
        //  pass the clicked Note as an argument
    }

    override fun getItemCount(): Int = mNoteList.size
    // Update the recycler view list with new data passed in

    fun setData(newNotes: List<Note>) {
        this.mNoteList = newNotes
        notifyDataSetChanged()
    }

    // This method may be useful for setting mood images in the ViewHolder
    private fun setMoodImage(view: ImageView, mood: String) {
        when (mood) {
            "anxious" -> view.setImageResource(R.drawable.ic_anxious_outline_false)
            "content" -> view.setImageResource(R.drawable.ic_content_outline_false)
            "happy" -> view.setImageResource(R.drawable.ic_happy_outline_false)
            "mad" -> view.setImageResource(R.drawable.ic_mad_outline_false)
            "neutral" -> view.setImageResource(R.drawable.ic_neutral_outline_false)
            "sad" -> view.setImageResource(R.drawable.ic_sad_outline_false)
            else -> { // Note the block
                view.setImageResource(R.drawable.ic_empty_state)
            }
        }
    }
}
