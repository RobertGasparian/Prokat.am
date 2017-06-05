package com.realmucho.prokatproject.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.realmucho.prokatproject.CategoryAdapter;
import com.realmucho.prokatproject.CategoryData;
import com.realmucho.prokatproject.Interfaces.PaneCallBack;
import com.realmucho.prokatproject.PostsActivity;
import com.realmucho.prokatproject.R;

import java.util.ArrayList;


public class TransportCategoryFragment extends Fragment implements PaneCallBack {
    private RecyclerView categoryrw;
    private CategoryAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.transport_category_fragment, container, false);
        categoryrw = (RecyclerView) view.findViewById(R.id.transport_category_rw);
        categoryrw.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new CategoryAdapter(setData(), getContext(), this);
        categoryrw.setAdapter(adapter);
        return view;
    }

    private ArrayList<CategoryData> setData() {
        ArrayList<CategoryData> arrayList = new ArrayList<>();
        int[] checked = new int[]{R.drawable.econom_icon, R.drawable.biznes_icon, R.drawable.jeep_icon, R.drawable.nerka_icon, R.drawable.limuzin_icon, R.drawable.cabriolet_icon, R.drawable.miniven_icon, R.drawable.retro_icon, R.drawable.karq_icon, R.drawable.tochki_icon};
        int[] unchecked = new int[]{R.drawable.econom_checked_icon, R.drawable.biznes_checked_icon, R.drawable.jeep_checked_icon, R.drawable.nerka_checked_icon, R.drawable.limuzin_checked_icon, R.drawable.cabriolet_checked_icon, R.drawable.miniven_checked_icon, R.drawable.retro_checked_icon, R.drawable.karq_checked_icon, R.drawable.tochki_checked_icon};
        String[] names = getResources().getStringArray(R.array.transport_titles);

        for (int i = 0; i < 10; i++) {
            arrayList.add(new CategoryData(unchecked[i], names[i + 1], checked[i]));

        }


        return arrayList;
    }

    @Override
    public void paneopen(int position) {
        Intent intent = new Intent(getContext(), PostsActivity.class);
        startActivity(intent);
    }
}
