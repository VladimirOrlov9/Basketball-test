package com.vladimirorlov9.basketball_test.ui.livescore

import android.text.format.DateFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.vladimirorlov9.basketball_test.R
import com.vladimirorlov9.basketball_test.domain.model.LiveMatch
import java.text.SimpleDateFormat
import java.util.*

class LiveScoreListAdapter :
    ListAdapter<LiveMatch, LiveScoreListAdapter.LiveScoreViewHolder>(DiffCallback()) {

    inner class LiveScoreViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val homeTeamLogo = itemView.findViewById<ImageView>(R.id.home_team_logo)
        private val homeTeamName = itemView.findViewById<TextView>(R.id.home_team_name)
        private val awayTeamLogo = itemView.findViewById<ImageView>(R.id.away_team_logo)
        private val awayTeamName = itemView.findViewById<TextView>(R.id.away_team_name)
        private val score = itemView.findViewById<TextView>(R.id.score_text)
        private val eventDate = itemView.findViewById<TextView>(R.id.event_date)
        private val eventTime = itemView.findViewById<TextView>(R.id.event_time)

        fun bind(position: Int) {
            val currentElement = currentList[position]

            homeTeamName.text = currentElement.eventHomeTeam
            awayTeamName.text = currentElement.eventAwayTeam
            score.text = currentElement.eventFinalResult

            eventDate.text = parseDate(currentElement.eventDate)
            eventTime.text = currentElement.eventTime

            Glide.with(itemView)
                .load(currentElement.eventHomeTeamLogo)
                .error(R.drawable.outline_image_not_supported_24)
                .into(homeTeamLogo)

            Glide.with(itemView)
                .load(currentElement.eventAwayTeamLogo)
                .error(R.drawable.outline_image_not_supported_24)
                .into(awayTeamLogo)
        }

        private fun parseDate(dateBefore: String): String {
            val date = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(dateBefore)
            val dateFormatted = DateFormat.format("dd.MM.yyyy", date)
            return dateFormatted.toString()
        }

    }

    class DiffCallback : DiffUtil.ItemCallback<LiveMatch>() {
        override fun areItemsTheSame(oldItem: LiveMatch, newItem: LiveMatch): Boolean {
            return oldItem.eventId == newItem.eventId &&
                    oldItem.eventFinalResult == newItem.eventFinalResult &&
                    oldItem.eventStatus == newItem.eventStatus
        }

        override fun areContentsTheSame(oldItem: LiveMatch, newItem: LiveMatch): Boolean =
            oldItem == newItem

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LiveScoreViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_element_live_score, parent, false)

        return LiveScoreViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: LiveScoreViewHolder, position: Int) {
        holder.bind(position = position)
    }
}