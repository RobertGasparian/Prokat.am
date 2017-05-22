package com.realmucho.prokatproject.Fragments;


import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import com.realmucho.prokatproject.CategoryActivity;
import com.realmucho.prokatproject.R;

import java.util.HashMap;
import java.util.Map;


public class MainFragment extends Fragment implements View.OnClickListener {

    private ImageView goodsimage, transportimage, serviceimage, realtyimage, roundcategory;
    private View pizza;
    private Intent intent;
    private Handler handler;
    private Map<String,Integer> imagesround;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment, container, false);
        pizza =  view.findViewById(R.id.pizza);
        roundcategory = (ImageView) view.findViewById(R.id.roundcategory);
        goodsimage = (ImageView) view.findViewById(R.id.goods_image);
        transportimage = (ImageView) view.findViewById(R.id.transport_image);
        serviceimage = (ImageView) view.findViewById(R.id.service_image);
        realtyimage = (ImageView) view.findViewById(R.id.realty_image);
        goodsimage.setOnClickListener(this);
        transportimage.setOnClickListener(this);
        serviceimage.setOnClickListener(this);
        realtyimage.setOnClickListener(this);
        imagesround=new HashMap<>();
        imagesround.put("goods",R.drawable.goods_round);
        imagesround.put("transport",R.drawable.transport_round);
        imagesround.put("service",R.drawable.service_round);
        imagesround.put("realty",R.drawable.realty_round);
        roundcategory.setVisibility(View.GONE);
        return view;
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();

        final int REQ_GOODS = 1;
        final int REQ_TRANSPORT = 2;
        final int REQ_SERVICE = 3;
        final int REQ_REALTY = 4;

        switch (id) {

            case R.id.goods_image:
                roundcategory.setImageResource(imagesround.get("goods"));
                roundcategory.setVisibility(View.VISIBLE);
                animation(pizza, roundcategory);
                handler = new Handler();
                handler.postDelayed(new Runnable() {


                    @Override
                    public void run() {
                        pizza.setVisibility(View.GONE);
                        intent = new Intent(getContext(), CategoryActivity.class);
                        intent.putExtra("code", REQ_GOODS);
                        startActivity(intent);
                    }
                }, 1000);


                break;
            case R.id.transport_image:
                roundcategory.setImageResource(imagesround.get("transport"));
                roundcategory.setVisibility(View.VISIBLE);
                animation(pizza, roundcategory);
                handler = new Handler();

                handler.postDelayed(new Runnable() {


                    @Override
                    public void run() {

                        pizza.setVisibility(View.GONE);
                        intent = new Intent(getContext(), CategoryActivity.class);
                        intent.putExtra("code", REQ_TRANSPORT);
                        startActivity(intent);
                    }
                }, 1000);


                break;
            case R.id.service_image:
                roundcategory.setImageResource(imagesround.get("service"));
                roundcategory.setVisibility(View.VISIBLE);
                animation(pizza, roundcategory);
                handler = new Handler();

                handler.postDelayed(new Runnable() {


                    @Override
                    public void run() {

                        pizza.setVisibility(View.GONE);
                        intent = new Intent(getContext(), CategoryActivity.class);
                        intent.putExtra("code", REQ_SERVICE);
                        startActivity(intent);
                    }
                }, 1000);


                break;
            case R.id.realty_image:
                roundcategory.setImageResource(imagesround.get("realty"));
                roundcategory.setVisibility(View.VISIBLE);
                animation(pizza, roundcategory);
                handler = new Handler();

                handler.postDelayed(new Runnable() {


                    @Override
                    public void run() {

                        pizza.setVisibility(View.GONE);
                        intent = new Intent(getContext(), CategoryActivity.class);
                        intent.putExtra("code", REQ_REALTY);
                        startActivity(intent);
                    }
                }, 1000);


                break;


        }


    }

    public void animation(View view, ImageView imageView) {

        ObjectAnimator alphaAnimator = ObjectAnimator.ofFloat(view, "alpha", 0f);
        alphaAnimator.setDuration(300);
        ObjectAnimator scaleAnimatorX = ObjectAnimator.ofFloat(imageView, "scaleX", (float) imageView.getScaleX(), imageView.getScaleX() * 300);
        scaleAnimatorX.setDuration(500);
        scaleAnimatorX.setStartDelay(500);
        ObjectAnimator scaleAnimatorY = ObjectAnimator.ofFloat(imageView, "scaleY", imageView.getScaleY(), imageView.getScaleY() * 300);
        scaleAnimatorY.setDuration(500);
        scaleAnimatorY.setStartDelay(500);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(alphaAnimator, scaleAnimatorX, scaleAnimatorY);
        animatorSet.start();


    }


    @Override
    public void onResume() {


        super.onResume();
        pizza.setAlpha(1);
        pizza.setVisibility(View.VISIBLE);
        roundcategory.setScaleX(1);
        roundcategory.setScaleY(1);
        roundcategory.setVisibility(View.GONE);

    }
}

