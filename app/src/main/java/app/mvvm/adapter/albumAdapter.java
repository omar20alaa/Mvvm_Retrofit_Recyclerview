package app.mvvm.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import app.mvvm.R;
import app.mvvm.model.albumModel;
import butterknife.BindView;
import butterknife.ButterKnife;

public class albumAdapter extends RecyclerView.Adapter<albumAdapter.MyViewHolder> {

    private List<albumModel> list = new ArrayList<>();

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item, parent, false);
        return new MyViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Glide.with(holder.itemView)
                .load(list.get(position).getThumbnailUrl())
                .into(holder.img_item);

        holder.tv_albumId.setText("albumId" + " : " + list.get(position).getId());
        holder.tv_title.setText("title" + " : " + list.get(position).getTitle());
    }


    public void setList(List<albumModel> moviesList) {
        this.list = moviesList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.img_item)
        ImageView img_item;

        @BindView(R.id.tv_albumId)
        TextView tv_albumId;

        @BindView(R.id.tv_title)
        TextView tv_title;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
