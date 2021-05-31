package com.example.testjusto.background.web_service

import com.example.testjusto.BuildConfig
import com.ihsanbal.logging.Level
import com.ihsanbal.logging.LoggingInterceptor
import okhttp3.OkHttpClient
import okhttp3.internal.platform.Platform
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class WebService {

    companion object {

        fun services(): WebServicesDefinition {
            val okHttpClient: OkHttpClient
            val okHttpClientBuilder: OkHttpClient.Builder = OkHttpClient.Builder()

            okHttpClientBuilder.readTimeout(90, TimeUnit.SECONDS)
            okHttpClientBuilder.callTimeout(90, TimeUnit.SECONDS)
            okHttpClientBuilder.connectTimeout(90, TimeUnit.SECONDS)

            okHttpClientBuilder.addInterceptor(

                LoggingInterceptor.Builder()
                    .addHeader("Version", BuildConfig.VERSION_NAME)
                    .setLevel(Level.BASIC)
                    .setLevel(Level.HEADERS)
                    .setLevel(Level.BASIC)
                    .log(Platform.INFO)
                    .request("Request")
                    .response("Response")
                    .build()
            )

            okHttpClient = okHttpClientBuilder.build()

            val retrofit: Retrofit
            val retrofitBuilder: Retrofit.Builder = Retrofit.Builder()
            retrofitBuilder.client(okHttpClient)
            retrofitBuilder.baseUrl("https://randomuser.me/")
            retrofitBuilder.addConverterFactory(GsonConverterFactory.create(GsonUtils.gsonForDeserialization()))

            retrofit = retrofitBuilder.build()

            return retrofit.create(WebServicesDefinition::class.java)
        }
    }
}