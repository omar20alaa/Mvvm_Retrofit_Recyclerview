package app.mvvm.ui.album;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import app.mvvm.R;
import app.mvvm.adapter.albumAdapter;
import app.mvvm.model.albumModel;
import butterknife.BindView;
import butterknife.ButterKnife;

public class albumActivity extends AppCompatActivity {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    albumViewModel albumViewModel;
    albumAdapter adapter = new albumAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(albumActivity.this);
        albumViewModel = ViewModelProviders.of(this).get(albumViewModel.class);
        albumViewModel.fetchAlbums();
        initRecycler();
        initViewMModel();
     }

    private void initViewMModel() {
        albumViewModel.list.observe(this, new Observer<List<albumModel>>() {
            @Override
            public void onChanged(List<albumModel> albumModel) {
                adapter.setList(albumModel);
            }
        });
    } // init view model

    private void initRecycler() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
    } // init recyclerview
}
