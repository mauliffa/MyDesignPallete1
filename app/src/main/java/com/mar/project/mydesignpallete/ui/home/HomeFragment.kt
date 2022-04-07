package com.mar.project.mydesignpallete.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.mar.project.mydesignpallete.databinding.FragmentHomeBinding
import com.mar.project.mydesignpallete.GridProjectAdapter
import com.mar.project.mydesignpallete.Projects
import com.mar.project.mydesignpallete.ProjectsData

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private var list: ArrayList<Projects> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /**val name = "Sourav Soman"
        val position = "App Developer"
        val toDo = "5 task now. 1 started"
        val progress = "1 task now. 1 started"
        val done = "18 task now. 13 started"

        binding.tvName.text = name
        binding.tvPosition.text = position
        binding.tvToDoSubtitle.text = toDo
        binding.tvInProgressSubtitle.text = progress
        binding.tvDoneSubtitle.text = done

        */

        binding.rvProjects.setHasFixedSize(true)
        list.addAll(ProjectsData.listData)

        binding.rvProjects.layoutManager = GridLayoutManager(activity, 2)
        val gridHeroAdapter = GridProjectAdapter(list)
        binding.rvProjects.adapter = gridHeroAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}