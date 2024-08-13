package com.example.whatToEat.ui.mealDetail

import android.content.Intent
import android.content.res.ColorStateList
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.whatToEat.R
import com.example.whatToEat.databinding.FragmentDetailBinding
import com.example.whatToEat.databinding.IngredientMeasurementItemBinding
import com.example.whatToEat.domain.model.MealUiModel
import com.example.whatToEat.ui.base.BaseFragment
import com.example.whatToEat.ui.util.toErrorString
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class MealDetailFragment: BaseFragment<FragmentDetailBinding, MealDetailViewModel>() {

    override val viewModel: MealDetailViewModel by viewModels()
    override fun getViewBinding(): FragmentDetailBinding = FragmentDetailBinding.inflate(layoutInflater)
    private val args: MealDetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val uid = args.mealUid
        val apiId = args.mealApiId
        viewModel.fetchMeal(uid, apiId)
        setupTopBar()
        lifecycleScope.launch {
            viewModel.meal.collect { mealUiModel ->
                onViewStateChange(mealUiModel)
            }
        }
        lifecycleScope.launch {
            viewModel.isSaved.collect {
                it?.let {
                    if (it) {
                        binding.vAppbar.btnUtil.setImageResource(R.drawable.ic_favourite_fill)
                    } else {
                        binding.vAppbar.btnUtil.setImageResource(R.drawable.ic_favourite_empty)
                    }
                }
            }
        }
        super.onViewCreated(view, savedInstanceState)
    }

    private fun setupTopBar() {
        binding.vAppbar.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.vAppbar.btnUtil.apply {
            visibility = View.VISIBLE
            imageTintList = ColorStateList.valueOf(context.getColor(R.color.red))
            setOnClickListener {
                viewModel.onFavButtonClick()
            }
        }
    }

    private fun onViewStateChange(event: MealUiModel?) {
        event?.let { uiModel ->
            when (uiModel) {
                is MealUiModel.Failure -> {
                    this.handleLoading(false)
                    this.handleErrorMessage(uiModel.error.toErrorString(context))
                }
                MealUiModel.Loading -> { this.handleLoading(isLoading = true) }
                is MealUiModel.Success -> {
                    this.handleLoading(isLoading = false)
                    binding.vAppbar.vTitle.text = uiModel.data.mealName
                    Glide.with(this)
                        .load(uiModel.data.thumbnail ?: R.drawable.mark)
                        .transition(DrawableTransitionOptions.withCrossFade())
                        .into(binding.vThumbnail)
                    uiModel.data.youtube?.let { safeYoutubeUrl ->
                        binding.btnYoutube.root.apply {
                            visibility = View.VISIBLE
                            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(safeYoutubeUrl))
                            setOnClickListener {
                                if (intent.resolveActivity(requireContext().packageManager) != null) {
                                    context?.startActivity(intent)
                                }
                            }
                        }
                    }
                    binding.vMealDetailInstructionSection.vInstructionDetail.text = uiModel.data.instructions
                    if (uiModel.data.area.isNotBlank() || uiModel.data.category.isNotBlank()) {
                        binding.llAreaAndCategory.visibility = View.VISIBLE
                        binding.vArea.root.text = uiModel.data.area
                        binding.vCategory.root.text = uiModel.data.category
                    }
                    uiModel.data.ingredientMeasurementList.forEach {
                        if (!it.ingredient.isNullOrBlank()) {
                            val customViewBinding = IngredientMeasurementItemBinding.inflate(layoutInflater).apply {
                                this.vIngredient.text = it.ingredient
                                this.vMeasurement.text = it.measurement.orEmpty()
                            }
                            binding.llIngredient.addView(customViewBinding.root)
                        }
                    }
                }
            }
        }
    }
}