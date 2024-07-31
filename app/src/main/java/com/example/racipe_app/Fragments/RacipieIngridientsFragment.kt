package com.example.racipe_app.Fragments

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.racipe_app.Database_Repository.Food_repository
import com.example.racipe_app.databinding.FragmentRacipieIngridientsBinding

class RacipieIngridientsFragment : Fragment() {
    private lateinit var binding: FragmentRacipieIngridientsBinding
    private var ingredientsList: List<String>? = null
    private val foodRepository = Food_repository()
    private val args: RacipieIngridientsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRacipieIngridientsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Retrieve the arguments passed from the previous fragment
        val recipeName = args.text
        val imageResource = args.imageid

        // Fetch the ingredients based on the recipe name
        ingredientsList = fetchIngredients(recipeName)

        // Use view binding to access views
        binding.textViewCurrent.text = recipeName
        imageResource.let { binding.imageView6.setImageResource(it) }
        binding.ingredientsDetails.text = ingredientsList?.joinToString("\n")

        // Back button
        binding.imageViewBack.setOnClickListener {

            findNavController().navigateUp()

        }

        // Copy ingredients to clipboard
        binding.imageView7.setOnClickListener {
            copyIngredientsToClipboard()
        }

        // Set click listener for share button
        binding.imageView8.setOnClickListener {
            shareIngredients()
        }
    }

    // Fetch ingredients list using repository
    private fun fetchIngredients(recipeName: String?): List<String> {
        return foodRepository.fetchIngredients(recipeName)
    }

    // Function to copy ingredients to clipboard
    private fun copyIngredientsToClipboard() {
        val clipboardManager = requireContext().getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clip = ClipData.newPlainText("Ingredients", binding.ingredientsDetails.text)
        clipboardManager.setPrimaryClip(clip)
        Toast.makeText(requireContext(), "Ingredients copied to clipboard", Toast.LENGTH_SHORT).show()
    }

    // Function to share ingredients
    private fun shareIngredients() {
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.type = "text/plain"
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Ingredients")
        shareIntent.putExtra(Intent.EXTRA_TEXT, binding.ingredientsDetails.text)
        startActivity(Intent.createChooser(shareIntent, "Share via"))
    }

    companion object {
        @JvmStatic
        fun newInstance(): RacipieIngridientsFragment {
            return RacipieIngridientsFragment()
        }
    }
}
