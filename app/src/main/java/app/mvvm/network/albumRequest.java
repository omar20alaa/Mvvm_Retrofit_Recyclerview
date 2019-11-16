package app.mvvm.network;

import java.util.List;

import app.mvvm.model.albumModel;
import retrofit2.Call;
import retrofit2.http.GET;

public interface albumRequest {

    @GET("photos")
    Call<List<albumModel>> getPosts();

}
