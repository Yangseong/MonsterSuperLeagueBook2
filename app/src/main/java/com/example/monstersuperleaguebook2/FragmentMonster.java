package com.example.monstersuperleaguebook2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class FragmentMonster extends Fragment {
    RecyclerView monsterRecyclerView;
    MonsterAdapter monsterAdapter;
    List<MonsterItem> monsterData;

    EditText searchInput;

    private String text = "hello2";

    //test
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_monster, container, false);

        searchInput = view.findViewById(R.id.search_input);

        monsterRecyclerView = view.findViewById(R.id.monster_rv);
        monsterData = new ArrayList<>();
        //monsterData.add(new MonsterItem("athur", R.drawable.athur));
        monsterData.add(new MonsterItem("balrak", R.drawable.balrak));
        monsterData.add(new MonsterItem("garuda", R.drawable.garuda));
        monsterData.add(new MonsterItem("hanjo", R.drawable.hanjo));
        monsterData.add(new MonsterItem("indra", R.drawable.indra));
        monsterData.add(new MonsterItem("mastercat", R.drawable.mastercat));
        monsterData.add(new MonsterItem("athur", R.drawable.athur));
        monsterData.add(new MonsterItem("muline", R.drawable.muline));
        monsterData.add(new MonsterItem("nix", R.drawable.nix));
        monsterData.add(new MonsterItem("rabity", R.drawable.rabity));
        monsterData.add(new MonsterItem("wookong", R.drawable.wookong));
        monsterData.add(new MonsterItem("xiba", R.drawable.xiba));
        monsterData.add(new MonsterItem("xiba", R.drawable.xiba));
        monsterData.add(new MonsterItem("xiba", R.drawable.xiba));
        monsterData.add(new MonsterItem("xiba", R.drawable.xiba));
        monsterData.add(new MonsterItem("rabity", R.drawable.rabity));
        monsterData.add(new MonsterItem("wookong", R.drawable.wookong));
        monsterData.add(new MonsterItem("muline", R.drawable.muline));


        monsterAdapter = new MonsterAdapter(getActivity(), monsterData);

        monsterRecyclerView.setAdapter(monsterAdapter);
        monsterRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        searchInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                monsterAdapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



        return view;
    }
}
