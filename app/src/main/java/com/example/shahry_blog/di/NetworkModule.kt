package com.example.shahry_blog.di

import com.example.network.createNetworkClient
import com.example.shahry_blog.data.data_source.remote.ShahryBlogClient
import com.example.shahry_blog.data.type_converters.OffsetDateTimeTypeConverter
import com.google.gson.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Converter
import retrofit2.converter.gson.GsonConverterFactory
import java.time.OffsetDateTime
import java.time.ZonedDateTime
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule{
    val BASE_URL = "https://sym-json-server.herokuapp.com/"

    @Provides
    @Singleton
    fun getGsonTypeConverter(): Converter.Factory {
        val gson = GsonBuilder()
            .registerTypeAdapter( // OffsetDateTime Deserializer
                OffsetDateTime::class.java,
                JsonDeserializer<OffsetDateTime> { json, _, _ ->
                    OffsetDateTimeTypeConverter.toOffsetDateTime(json.asString)
                })
            .registerTypeAdapter(// OffsetDateTime Serializer
                ZonedDateTime::class.java,
                JsonSerializer<ZonedDateTime> { json, _, _ ->
                    JsonPrimitive(OffsetDateTimeTypeConverter.toString(json.toOffsetDateTime()))
                })
            .create()

        return GsonConverterFactory.create(gson)
    }

    @Provides
    @Singleton
    fun getRetroInstance(): ShahryBlogClient =
        createNetworkClient(BASE_URL, typeConverter = getGsonTypeConverter()).create(
            ShahryBlogClient::class.java
        )


}