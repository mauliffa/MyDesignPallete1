package com.mar.project.mydesignpallete

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.eazegraph.lib.models.PieModel


class GridProjectAdapter(private val listProjects: ArrayList<Projects>): RecyclerView.Adapter<GridProjectAdapter.GridViewHolder> () {

    inner class GridViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView = itemView.findViewById(R.id.tv_title)
        var progress: TextView = itemView.findViewById(R.id.tv_progress)
        var percent: TextView = itemView.findViewById(R.id.tv_percent)
        var percentCont: ImageView = itemView.findViewById(R.id.iv_percent_cont)
        var chart: org.eazegraph.lib.charts.PieChart = itemView.findViewById(R.id.chart)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GridViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_projects, parent, false)
        return GridViewHolder(view)
    }

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        val project = listProjects[position]

        holder.title.text = project.title
        holder.progress.text = project.progress

        //percentage text
        val text = project.percentage.toString()
        val text2 = "$text%"
        holder.percent.text = text2

        //pie chart
        val done = project.percentage
        val undone = 100 - done
        holder.chart.addPieSlice(PieModel(
            "value 1", done.toFloat(), Color.parseColor("#FFFFFF")))
        holder.chart.addPieSlice(PieModel(
            "value 2", undone.toFloat(), Color.parseColor("#B1AFAF")))
        holder.chart.startAnimation()

        //background
        var background = 0
        var percentContainer = 0
        when (position % 4) {
            0 -> {
                background = R.drawable.rounded_green
                percentContainer = R.drawable.circle_green
            }
            1 -> {
                background = R.drawable.rounded_red
                percentContainer = R.drawable.circle_red
            }
            2 -> {
                background = R.drawable.rounded_orange
                percentContainer = R.drawable.circle_orange
            }
            3 -> {
                background = R.drawable.rounded_blue
                percentContainer = R.drawable.circle_blue
            }
        }
        holder.percentCont.setImageResource(percentContainer)
        holder.itemView.setBackgroundResource(background)
    }

    override fun getItemCount(): Int {
        return listProjects.size
    }

}
