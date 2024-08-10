package com.aungpaing.test.data.models

import androidx.appcompat.app.AppCompatActivity
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import com.aungpaing.test.network.NetworkApi
import com.aungpaing.test.utils.BASE_URL
import okhttp3.Credentials
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

abstract class BaseModel: AppCompatActivity() {

    protected val mNetworkApi: NetworkApi

    init {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

       /* val mOkHttpClient = OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .addInterceptor(BasicAuthInterceptor("RES!@#", "12345678"))
            .apply {
                addInterceptor(interceptor)
            }
            .build()*/

        val mOkHttpClient = OkHttpClient.Builder()
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .writeTimeout(120, TimeUnit.SECONDS)
            .addInterceptor(interceptor)
            .build()


        val gson = GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create()
        // val headerInterceptor =
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(mOkHttpClient)
            .build()

        mNetworkApi = retrofit.create(NetworkApi::class.java)
    }

    class BasicAuthInterceptor(username: String, password: String): Interceptor {
        private var credentials: String = Credentials.basic(username, password)

        override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
            var request = chain.request()
            request = request.newBuilder().header("Authorization", credentials).build()
            return chain.proceed(request)
        }
    }
}