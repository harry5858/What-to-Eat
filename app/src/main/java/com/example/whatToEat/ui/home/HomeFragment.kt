package com.example.whatToEat.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.whatToEat.R
import com.example.whatToEat.databinding.FragmentHomeBinding
import com.example.whatToEat.domain.model.MealUiModel
import com.example.whatToEat.ui.base.BaseFragment
import com.example.whatToEat.ui.util.toErrorString
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class HomeFragment: BaseFragment<FragmentHomeBinding, HomeViewModel>() {

    override val viewModel: HomeViewModel by viewModels()
    override fun getViewBinding(): FragmentHomeBinding = FragmentHomeBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupTopBar()
        binding.btnRoll.setOnClickListener {
            viewModel.onRollClick()
        }
        lifecycleScope.launch {
            viewModel.meal.collect { mealUiModel ->
                onViewStateChange(mealUiModel)
            }
        }
        super.onViewCreated(view, savedInstanceState)
    }

    private fun setupTopBar() {
        binding.vAppbar.btnBack.visibility = View.INVISIBLE
        binding.vAppbar.vTitle.text = getString(R.string.home_fragment_app_bar_title)
        binding.vAppbar.btnUtil.apply {
            visibility = View.VISIBLE
            setImageResource(R.drawable.ic_add)
            setOnClickListener {
                this.findNavController().navigate(
                    HomeFragmentDirections.actionHomeFragmentToSavedRecipeFragment()
                )
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
                MealUiModel.Loading -> {
                    this.handleLoading(true)
                }
                is MealUiModel.Success -> {
                    this.handleLoading(false)
                    binding.btnToDetail.apply {
                        isEnabled = true
                        setOnClickListener {
                            uiModel.data.let { safeMeal ->
                                this@HomeFragment.findNavController().navigate(
                                    HomeFragmentDirections.actionHomeFragmentToDetailFragment(
                                        mealUid = safeMeal.uid,
                                        mealApiId = safeMeal.apiId
                                    )
                                )
                            }
                        }
                    }
                    binding.vMeal.text = uiModel.data.mealName
                    Glide.with(this)
                        .load(uiModel.data.thumbnail)
                        .fallback(R.drawable.mark)
                        .transition(DrawableTransitionOptions.withCrossFade())
                        .into(binding.vThumbnail)
                }
            }
        }?: return
    }
}