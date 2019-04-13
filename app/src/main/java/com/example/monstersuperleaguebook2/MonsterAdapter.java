package com.example.monstersuperleaguebook2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class MonsterAdapter extends RecyclerView.Adapter<MonsterAdapter.MonsterViewHolder> implements Filterable {

    Context mContext;
    List<MonsterItem> mMonsterData;
    List<MonsterItem> mMonsterDataFiltered;

    public MonsterAdapter(Context mContext, List<MonsterItem> mMonsterData) {
        this.mContext = mContext;
        this.mMonsterData = mMonsterData;
        this.mMonsterDataFiltered = mMonsterData;
    }

    @NonNull
    @Override
    public MonsterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View layout;
        layout = LayoutInflater.from(mContext).inflate(R.layout.item_monster, viewGroup, false);

        return new MonsterViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull MonsterViewHolder monsterViewHolder, int i) {

        //set Animation
        monsterViewHolder.monsterImg.setAnimation(AnimationUtils.loadAnimation(mContext, R.anim.fade_transition_animation));
        monsterViewHolder.monsterName.setAnimation(AnimationUtils.loadAnimation(mContext, R.anim.fade_transition_animation));

        monsterViewHolder.monsterName.setText(mMonsterDataFiltered.get(i).monsterName);
        //monsterViewHolder.monsterImg.setImageResource(mMonsterData.get(i).monsterPicture);
        Glide.with(mContext)
                .load(mMonsterDataFiltered.get(i).monsterPicture)
                .centerCrop()
                .into(monsterViewHolder.monsterImg);
    }

    @Override
    public int getItemCount() {
        return mMonsterDataFiltered.size();
    }

    @Override
    public Filter getFilter() {

        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {

                String key = constraint.toString();
                if (key.isEmpty()){
                    mMonsterDataFiltered = mMonsterData;
                } else{

                    List<MonsterItem> monsterFilteredList = new ArrayList<>();
                    for(MonsterItem row : mMonsterData){
                        if(row.monsterName.toLowerCase().contains(key.toLowerCase())){
                            monsterFilteredList.add(row);
                        }
                    }

                    mMonsterDataFiltered = monsterFilteredList;

                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = mMonsterDataFiltered;

                return filterResults;

            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {

                mMonsterDataFiltered = (List<MonsterItem>) results.values;
                notifyDataSetChanged();
            }
        };

    }

    public class MonsterViewHolder extends RecyclerView.ViewHolder {

        TextView monsterName;
        ImageView monsterImg;

        public MonsterViewHolder(@NonNull View itemView) {
            super(itemView);

            monsterName = itemView.findViewById(R.id.monster_name);
            monsterImg = itemView.findViewById(R.id.iv_monster_picture);
        }
    }


}
