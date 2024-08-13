package com.example.whatToEat.data.remote

import com.example.whatToEat.data.remote.models.MealsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MealApi {
    @GET("random.php/")
    suspend fun getRandomMeal(): Response<MealsResponse>

    @GET("lookup.php")
    suspend fun getMealById(@Query("i") id: Int): Response<MealsResponse>
}