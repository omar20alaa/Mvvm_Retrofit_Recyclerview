package app.mvvm.network;

import java.util.List;

import app.mvvm.model.albumModel;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class retrofitClient {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    private albumRequest albumRequest;
    private static retrofitClient instance;

    HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
    // set your desired log level


    public retrofitClient() {
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        httpClient.addInterceptor(logging);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();

        albumRequest = retrofit.create(albumRequest.class);
    }

    public static retrofitClient getInstance() {
        if (instance == null) {
            instance = new retrofitClient();
        }
        return instance;
    }

    public Call<List<albumModel>> getPosts() {
        return albumRequest.getPosts();
    }
}
