package ir.akharinkhabar.card_type.network

import ir.akharinkhabar.card_type.network.utils.ExceptionUtil
import retrofit2.Response

abstract class BaseService : RetrofitInstance() {

    suspend fun <T : Any> apiCall(call: suspend () -> Response<T>): Result<T> {
        val response: Response<T>
        try {
            response = call.invoke()
        } catch (e: Exception) {
           return Result.Error(ExceptionUtil.catchException(e))
        }

        return if (!response.isSuccessful) {
            val errorBody = response.errorBody()
            Result.Error(ExceptionUtil.catchHttpException(response.code()))
        } else {
            return if (response.body() == null) {
//                Result.Error(NullBodyException(ApiError("response.body() can't be null")))
                Result.Error("NullBodyException")
            } else {
                Result.Success(response.body()!!)
            }
        }
    }

}