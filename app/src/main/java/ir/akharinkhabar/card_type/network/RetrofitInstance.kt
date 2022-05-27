package ir.akharinkhabar.card_type.network


import com.readystatesoftware.chuck.ChuckInterceptor
import ir.akharinkhabar.card_type.MyApplication
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

abstract class RetrofitInstance {

    protected fun getRetrofit(): Retrofit = retrofit

    companion object {

        private val retrofit by lazy {
            val logging = HttpLoggingInterceptor()
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)

            val client = OkHttpClient.Builder()
                    .addInterceptor(ResponseInterceptor())
                    .addInterceptor(ChuckInterceptor(MyApplication.instance))
                    .addInterceptor(logging)
                    .build()

            Retrofit.Builder()
                    .baseUrl("https://akharinkhabar.ir/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build()
        }
    }
}