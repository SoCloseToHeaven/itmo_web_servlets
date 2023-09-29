package ru.ifmo.soclosetoheaven.model.json

import com.google.gson.Gson
import jakarta.enterprise.context.ApplicationScoped


@ApplicationScoped
class JsonParserBean {

    private val gson = Gson()

    fun stringify(any: Any) : String {
        return gson.toJson(any)
    }

     fun <T> parse(json: String, type: Class<T>): T {
         return gson.fromJson(json, type)
     }
}