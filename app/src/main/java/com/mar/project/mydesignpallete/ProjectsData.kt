package com.mar.project.mydesignpallete

object ProjectsData {
    private val title = arrayOf("Medical App",
        "Making History Notes",
        "Title 3",
        "Title 4")

    private val progress = arrayOf("9 hours progress",
        "20 hours progress",
        "n hours progress",
        "n hours progress")

    private val percentage = intArrayOf(
        25, 60, 0, 0)

    val listData: ArrayList<Projects>
        get() {
            val list = arrayListOf<Projects>()
            for (position in title.indices) {
                val projects = Projects()
                projects.title = title[position]
                projects.progress = progress[position]
                projects.percentage = percentage[position]
                list.add(projects)
            }
            return list
        }
}