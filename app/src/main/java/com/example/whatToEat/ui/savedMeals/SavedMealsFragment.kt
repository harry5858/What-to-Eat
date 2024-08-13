package com.example.whatToEat.ui.savedMeals

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.whatToEat.R
import com.example.whatToEat.databinding.FragmentSavedMealsBinding
import com.example.whatToEat.domain.model.MealsUiModel
import com.example.whatToEat.ui.base.BaseFragment
import com.example.whatToEat.ui.util.MarginItemDecoration
import com.example.whatToEat.ui.util.toErrorString
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SavedMealsFragment : BaseFragment<FragmentSavedMealsBinding, SavedMealsViewModel>() {
    override val viewModel: SavedMealsViewModel by viewModels()

    override fun getViewBinding(): FragmentSavedMealsBinding {
        return FragmentSavedMealsBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSavedMealsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.fetchSavedMeals()
        lifecycleScope.launch {
            viewModel.meals.collect {
                onViewStateChange(it)
            }
        }
        val layoutManager: LayoutManager = LinearLayoutManager(context).apply {
            orientation = LinearLayoutManager.VERTICAL
        }
        binding.rvMeals.apply {
            this.layoutManager = layoutManager
            this.addItemDecoration(MarginItemDecoration(resources.getDimensionPixelSize(R.dimen.meal_row_item_margin)))
        }
        setupTopBar()
        super.onViewCreated(view, savedInstanceState)
    }

    private fun setupTopBar() {
        binding.vAppbar.vTitle.text = getString(R.string.saved_meals_fragment_app_bar_title)
        binding.vAppbar.btnBack.apply {
            visibility = View.VISIBLE
            setOnClickListener {
                parentFragmentManager.popBackStack()
            }
        }
        binding.vAppbar.btnUtil.apply {
            visibility = View.VISIBLE
            setImageResource(R.drawable.ic_add)
            setOnClickListener {
                this.findNavController().navigate(
                    SavedMealsFragmentDirections.actionHomeFragmentToAddRecipeFragment()
                )
            }
        }
    }

    private fun onViewStateChange(event: MealsUiModel?) {
        event?.let { uiEvent ->
            when (uiEvent) {
                is MealsUiModel.Failure -> {
                    handleLoading(false)
                    handleErrorMessage(uiEvent.error.toErrorString(context))
                }
                MealsUiModel.Loading -> { handleLoading(true) }
                is MealsUiModel.Success -> {
                    handleLoading(false)
                    val adapter = MealsAdapter(uiEvent.data)
                    binding.rvMeals.adapter = adapter
                }
            }
        }
    }
}