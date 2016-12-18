package com.tejasvi7.meettheteam;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;




public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ViewHolder> {
    public static String id;
    public int cPosition;

public ArrayList<HashMap<String,String>> teamlist=new ArrayList<>();


     Context context;
    ItemsAdapter(Context context, ArrayList<HashMap<String,String>> teamlist){
        this.context = context;
        this.teamlist= teamlist;
    }

    @Override
    public ItemsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.team_member, null);

        // create ViewHolder

        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ItemsAdapter.ViewHolder holder, int position) {
            holder.firstName.setText(teamlist.get(position).get("firstName"));
            Log.d("firstname", teamlist.get(position).get("firstName"));
            holder.lastName.setText(teamlist.get(position).get("lastName"));
            holder.title.setText(teamlist.get(position).get("title"));
        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.init(ImageLoaderConfiguration.createDefault(context));

// Load image, decode it to Bitmap and display Bitmap in ImageView

       imageLoader.displayImage(teamlist.get(position).get("avatar"), holder.Avatar);

    }



    @Override
    public int getItemCount() {
        return teamlist.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView firstName,lastName,title;
        public ImageView Avatar;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            firstName = (TextView) itemLayoutView
                    .findViewById(R.id.textView);
            lastName = (TextView) itemLayoutView.findViewById(R.id.textView2);
            title = (TextView) itemLayoutView.findViewById(R.id.textView3);
            Avatar = (ImageView) itemLayoutView
                    .findViewById(R.id.imageView);
            itemLayoutView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {

Intent intent=new Intent(context,FullBio.class);
            intent.putExtra("position",getAdapterPosition());
            intent.putExtra("firstName",teamlist.get(getAdapterPosition()).get("firstName"));
            intent.putExtra("lastName",teamlist.get(getAdapterPosition()).get("lastName"));
            intent.putExtra("title",teamlist.get(getAdapterPosition()).get("title"));
            intent.putExtra("id",teamlist.get(getAdapterPosition()).get("id"));
            intent.putExtra("bio",teamlist.get(getAdapterPosition()).get("bio"));
            ImageView imageView=(ImageView) v.findViewById(R.id.imageView);
            Bitmap bm=((BitmapDrawable) imageView.getDrawable()).getBitmap();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bm.compress(Bitmap.CompressFormat.PNG, 50, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            String encoded = Base64.encodeToString(byteArray, Base64.URL_SAFE);
            intent.putExtra("image",encoded);
            context.startActivity(intent);
        }
    }
}

