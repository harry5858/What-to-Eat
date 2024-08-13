package com.example.whatToEat.ui.addMeal

import android.os.Bundle
import android.view.View
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import com.example.whatToEat.R
import com.example.whatToEat.databinding.AddIngredientMeasurementItemBinding
import com.example.whatToEat.databinding.FragmentAddRecipeBinding
import com.example.whatToEat.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AddMealFragment() : BaseFragment<FragmentAddRecipeBinding, AddMealViewModel>() {

    override val viewModel: AddMealViewModel by viewModels()
    override fun getViewBinding(): FragmentAddRecipeBinding {
        return FragmentAddRecipeBinding.inflate(layoutInflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupTopBar()
        lifecycleScope.launch {
            viewModel.meal.collect {

            }
        }
        binding.etMealName.doOnTextChanged { text, _, _, _ -> viewModel.onMealNameChange(text.toString()) }
        binding.etMealArea.doOnTextChanged { text, _, _, _ -> viewModel.onAreaChange(text.toString()) }
        binding.etMealCategory.doOnTextChanged { text, _, _, _ -> viewModel.onCategoryChange(text.toString()) }
        binding.etYoutubeUrl.doOnTextChanged { text, _, _, _ -> viewModel.onYoutubeUrlChange(text.toString()) }
        binding.etThumbnailUrl.doOnTextChanged { text, _, _, _ -> viewModel.onThumbnailUrlChange(text.toString()) }
        binding.etInstruction.doOnTextChanged { text, _, _, _ -> viewModel.onInstructionChange(text.toString()) }
        binding.llAddIngredientSection.btnAdd.setOnClickListener {
            val viewBinding = AddIngredientMeasurementItemBinding.inflate(layoutInflater).apply {
                this.vIngredient.text = binding.llAddIngredientSection.etIngredient.text
                this.vMeasurement.text = binding.llAddIngredientSection.etMeasurement.text
                this.btnDelete.setOnClickListener {
                    viewModel.onDeleteIngredientClick(
                        this.vIngredient.text.toString(),
                        this.vIngredient.text.toString()
                    ) {
                        binding.llAddIngredientSection.llIngredientMeasurementItems.removeView(this@apply.root)
                    }
                }
            }
            viewModel.onAddIngredientClick(
                ingredient = viewBinding.vIngredient.text.toString(),
                measurement = viewBinding.vMeasurement.text.toString()
            ) {
                binding.llAddIngredientSection.llIngredientMeasurementItems.addView(viewBinding.root)
            }
        }
        super.onViewCreated(view, savedInstanceState)
    }

    private fun setupTopBar() {
        binding.vAppbar.vTitle.text = getString(R.string.add_recipe_fragment_title)
        binding.vAppbar.btnBack.apply {
            visibility = View.VISIBLE
            setOnClickListener {
                this.findNavController().popBackStack()
            }
        }
        binding.vAppbar.btnUtil.apply {
            visibility = View.VISIBLE
            setImageResource(R.drawable.ic_check)
            setOnClickListener {
                //TODO
            }
        }
    }

    private fun onError() {

    }
}