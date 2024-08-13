package com.example.whatToEat.data.local.models

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.Gson

@ProvidedTypeConverter
class IngredientMeasurementEntityConverter {
    @TypeConverter
    fun fromString(serialized: String): IngredientMeasurementEntity{
        return Gson().fromJson(serialized, IngredientMeasurementEntity::class.java)
    }

    @TypeConverter
    fun toString(entity: IngredientMeasurementEntity): String{
        return Gson().toJson(entity)
    }
}