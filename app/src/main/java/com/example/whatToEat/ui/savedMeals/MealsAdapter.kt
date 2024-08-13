package com.example.whatToEat.ui.savedMeals

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.whatToEat.R
import com.example.whatToEat.databinding.SavedMealRowItemBinding
import com.example.whatToEat.domain.model.Meal

class MealsAdapter(private val dataSet: List<Meal>):
    RecyclerView.Adapter<MealsAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: SavedMealRowItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = SavedMealRowItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = dataSet.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val meal = dataSet[position]
        holder.binding.apply {
            Glide.with(this.root)
                .load(meal.thumbnail ?: R.drawable.mark)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(holder.binding.vThumbnail)
            this.vMealName.text = meal.mealName
            if (meal.area.isNotBlank()) {
                holder.binding.vArea.root.apply {
                    visibility = View.VISIBLE
                    text = meal.area
                }
            }
            if (meal.category.isNotBlank()) {
                holder.binding.vCategory.root.apply {
                    visibility = View.VISIBLE
                    text = meal.category
                }
            }
        }
        holder.itemView.setOnClickListener {
            holder.binding.root.findNavController().navigate(
                SavedMealsFragmentDirections.actionSavedRecipeFragmentToRecipeDetailFragment(
                    mealUid = meal.uid,
                    mealApiId = -1
                )
            )
        }
    }
}