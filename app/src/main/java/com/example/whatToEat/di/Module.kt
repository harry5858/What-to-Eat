package com.example.whatToEat.di

import android.content.Context
import androidx.room.Room
import com.example.whatToEat.data.local.dao.MealDao
import com.example.whatToEat.data.local.database.MealDatabase
import com.example.whatToEat.data.local.models.IngredientMeasurementEntityConverter
import com.example.whatToEat.data.remote.MealApi
import com.example.whatToEat.data.repository.MealRepositoryImpl
import com.example.whatToEat.domain.repository.MealRepository
import com.example.whatToEat.domain.useCases.DeleteSavedMealUseCase
import com.example.whatToEat.domain.useCases.GetMealDetailByIdUseCase
import com.example.whatToEat.domain.useCases.GetRandomMealUseCase
import com.example.whatToEat.domain.useCases.SaveMealUseCase
import com.example.whatToEat.utils.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Module {
    @Provides
    @Singleton
    fun provideMealRepository(
        api: MealApi,
        mealDao: MealDao
    ): MealRepository {
        return MealRepositoryImpl(
            mealApi = api,
            mealDao = mealDao
        )
    }

    @Provides
    @Singleton
    fun provideMealApi(): MealApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MealApi::class.java)
    }

    @Provides
    fun provideMealDao(mealDatabase: MealDatabase): MealDao {
        return mealDatabase.mealDao()
    }

    @Provides
    @Singleton
    fun provideMealDatabase(
        @ApplicationContext context: Context
    ): MealDatabase {
        return Room.databaseBuilder(
            context = context,
            klass = MealDatabase::class.java,
            name = "MealDatabase"
        )
            .addTypeConverter(IngredientMeasurementEntityConverter())
            .build()
    }

    @Provides
    fun provideGetRandomMealUseCase(mealRepository: MealRepository): GetRandomMealUseCase {
        return GetRandomMealUseCase(mealRepository)
    }

    @Provides
    fun provideGetMealDetailByIdUseCase(mealRepository: MealRepository): GetMealDetailByIdUseCase {
        return GetMealDetailByIdUseCase(mealRepository)
    }

    @Provides
    fun provideSaveMealUseCase(mealRepository: MealRepository): SaveMealUseCase {
        return SaveMealUseCase(mealRepository)
    }

    @Provides
    fun provideDeleteSavedMealUseCase(mealRepository: MealRepository): DeleteSavedMealUseCase {
        return DeleteSavedMealUseCase(mealRepository)
    }
}