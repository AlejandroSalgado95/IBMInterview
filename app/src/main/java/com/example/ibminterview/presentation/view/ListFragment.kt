package com.example.ibminterview.presentation.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import com.example.ibminterview.R
import com.example.ibminterview.databinding.FragmentListBinding
import com.example.ibminterview.presentation.adapter.listAdapter


class ListFragment : Fragment() {

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!
    private var listAdapter = listAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        listAdapter.setOnItemClickListener { item, adapterPosition ->
            Log.d("ADAPTER_POSITION", adapterPosition.toString())
            val listTemp= listAdapter.currentList.toMutableList()
            Log.d("MYLIST",listTemp.toString())
            listTemp.remove(item)
            listAdapter.submitList(listTemp)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listAdapter.submitList(listOf("100","200","300","400","500","600","700","800","900"))
        binding.rvCategory.adapter = listAdapter
        binding.rvCategory.layoutManager = LinearLayoutManager(requireContext())

        binding.addButton.setOnClickListener {
            val tempList = listAdapter.currentList
            
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }


}