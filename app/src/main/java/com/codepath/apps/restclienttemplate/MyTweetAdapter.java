package com.codepath.apps.restclienttemplate;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.codepath.apps.restclienttemplate.models.Tweet;

import java.util.List;

public class MyTweetAdapter extends RecyclerView.Adapter<MyTweetAdapter.ViewHolder> {

    private List<Tweet> mTweet;
    Context context;
    public MyTweetAdapter(List<Tweet> tweets){
        mTweet=tweets;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater=LayoutInflater.from(context);

        View tweetView=inflater.inflate(R.layout.item_tweet, parent, false);
        ViewHolder viewHolder=new ViewHolder(tweetView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Tweet tweet =mTweet.get(position);

        holder.tvUsername.setText(tweet.user.name);
        holder.tvBody.setText(tweet.body);
        Glide.with(context).load(tweet.user.profilImgUrl).into(holder.ivProfileImage);
    }

    @Override
    public int getItemCount() {
        return mTweet.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView ivProfileImage;
        public TextView tvUsername;
        public TextView tvBody;

        public ViewHolder (View itemView){
            super(itemView);
            ivProfileImage=(ImageView)itemView.findViewById(R.id.ivrofilemage);
            tvUsername=(TextView)itemView.findViewById(R.id.tvUser_name);
            tvBody=(TextView)itemView.findViewById(R.id.tvBody);
        }
    }
}
