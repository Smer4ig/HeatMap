package develop.heatmap;


import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {

    private static final String BASE_URL = "https://westus.api.cognitive.microsoft.com/";

    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());

    private static  OkHttpClient httpClient =
            new OkHttpClient.Builder().connectTimeout(10, TimeUnit.SECONDS)
                    .writeTimeout(10, TimeUnit.SECONDS)
                    .readTimeout(30, TimeUnit.SECONDS).build();
    private static Retrofit retrofit = builder.client(httpClient).build();
    public static <S> S createService(
            Class<S> serviceClass) {
        return retrofit.create(serviceClass);
    }
}