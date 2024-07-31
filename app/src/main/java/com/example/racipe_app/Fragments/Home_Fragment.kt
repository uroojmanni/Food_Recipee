package com.example.racipe_app.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.racipe_app.Adaptor.Adapter_Layout
import com.example.racipe_app.Database_Repository.Food_repository
import com.example.racipe_app.Model.Model_Food
import com.example.racipe_app.R
import com.example.racipe_app.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var adapter: Adapter_Layout
    private lateinit var foodRepository: Food_repository

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        foodRepository = Food_repository()
        val foodList = foodRepository.getMockFoodList()

        adapter = Adapter_Layout(foodList) { selectedItem ->
            navigateToRecipeFragment(selectedItem)
        }
        binding.recycleView.adapter = adapter
        binding.recycleView.layoutManager = GridLayoutManager(requireContext(), 2)
    }

    private fun navigateToRecipeFragment(food: Model_Food) {
        val action = HomeFragmentDirections.actionHomeFragmentToRacipieIngridientsFragment(
            food.image,
             food.foodName
        )
        findNavController().navigate(action)
    }


    companion object {
        fun newInstance() = HomeFragment()
    }
}