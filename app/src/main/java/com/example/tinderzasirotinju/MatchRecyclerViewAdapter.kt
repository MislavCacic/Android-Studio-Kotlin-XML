package com.example.tinderzasirotinju

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MatchRecyclerViewAdapter: RecyclerView.Adapter<MatchRecyclerViewAdapter.MatchViewHolder>{
    var context: Context?
    var matchModels: ArrayList<MatchModel> = ArrayList<MatchModel>()

    constructor(context: Context?, matchModels: ArrayList<MatchModel>){
        this.context = context
        this.matchModels = matchModels
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MatchRecyclerViewAdapter.MatchViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        val view: View = inflater.inflate(R.layout.recycler_view_row, parent, false)
        return MatchRecyclerViewAdapter.MatchViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: MatchRecyclerViewAdapter.MatchViewHolder,
        position: Int
    ) {
        holder.matchNameTextView.setText(matchModels.get(position).matchName)
        holder.matchProfilePicutre.setImageResource(matchModels.get(position).matchProfilePicture)
        holder.matchAgeTextView.setText(matchModels.get(position).matchAge)
        holder.matchUsernameTextView.setText(matchModels.get(position).matchUsername)
    }

    override fun getItemCount(): Int {
        return matchModels.size
    }

    class MatchViewHolder constructor(itemView: View): RecyclerView.ViewHolder(itemView){
        var matchNameTextView: TextView =
            itemView.findViewById(R.id.nameOfMatch)

        var matchProfilePicutre: ImageView=
            itemView.findViewById(R.id.profilePictureOfMatch)

        var matchAgeTextView: TextView =
            itemView.findViewById(R.id.ageOfMatch)

        var matchUsernameTextView: TextView =
            itemView.findViewById(R.id.usernameOfMatch)
    }
}