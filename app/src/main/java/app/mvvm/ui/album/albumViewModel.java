package app.mvvm.ui.album;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import app.mvvm.model.albumModel;
import app.mvvm.network.retrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class albumViewModel extends ViewModel {

    MutableLiveData<List<albumModel>> list = new MutableLiveData<>();

    public void fetchAlbums() {
        retrofitClient.getInstance().getPosts().enqueue(new Callback<List<albumModel>>() {
            @Override
            public void onResponse(Call<List<albumModel>> call, Response<List<albumModel>> response) {
                list.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<albumModel>> call, Throwable t) {
                Log.i("Print", "error = " + t.getLocalizedMessage());
            }
        });
    } // fetchPosts
}
