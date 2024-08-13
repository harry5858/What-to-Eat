package com.example.whatToEat.data.local.models

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.Gson

@ProvidedTypeConverter
class IngredientMeasurementEntityListConverter {
    @TypeConverter
    fun fromString(serialized: String): IngredientMeasurementEntityList{
        return Gson().fromJson(serialized, IngredientMeasurementEntityList::class.java)
    }

    @TypeConverter
    fun toString(entity: IngredientMeasurementEntityList): String{
        return Gson().toJson(entity)
    }
}