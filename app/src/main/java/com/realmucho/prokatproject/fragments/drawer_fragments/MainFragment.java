package com.realmucho.prokatproject.fragments.drawer_fragments;


import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.realmucho.prokatproject.activities.AddActivity;
import com.realmucho.prokatproject.activities.CategoryActivity;
import com.realmucho.prokatproject.R;

import java.util.HashMap;
import java.util.Map;


public class MainFragment extends Fragment implements View.OnClickListener {

    private ImageView mGoodsImage, mTransportImage, mServiceImage, mRealtyImage, mRoundCategory;
    private View pizza;
    private Intent intent;
    private Handler mAnimHandler;
    private Map<String, Integer> mImagesRound;
    private FloatingActionButton mAddFab;
    private RelativeLayout mMainLayout;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment, container, false);
        init(view);
        setupClicks();
        setmImagesRound();
        mRoundCategory.setVisibility(View.GONE);

        return view;
    }

    private void init(View view) {

        pizza = view.findViewById(R.id.pizza);
        mMainLayout = (RelativeLayout) view.findViewById(R.id.main_fragment_layout);
        mRoundCategory = (ImageView) view.findViewById(R.id.roundcategory);
        mGoodsImage = (ImageView) view.findViewById(R.id.goods_image);
        mTransportImage = (ImageView) view.findViewById(R.id.transport_image);
        mServiceImage = (ImageView) view.findViewById(R.id.service_image);
        mRealtyImage = (ImageView) view.findViewById(R.id.realty_image);
        mAddFab = (FloatingActionButton) view.findViewById(R.id.fab);

    }

    private void setupClicks() {
        mAddFab.setOnClickListener(this);
        mGoodsImage.setOnClickListener(this);
        mTransportImage.setOnClickListener(this);
        mServiceImage.setOnClickListener(this);
        mRealtyImage.setOnClickListener(this);
    }

    private void setmImagesRound() {
        mImagesRound = new HashMap<>();
        mImagesRound.put("goods", R.drawable.goods_round);
        mImagesRound.put("transport", R.drawable.transport_round);
        mImagesRound.put("service", R.drawable.service_round);
        mImagesRound.put("realty", R.drawable.realty_round);
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
                mRoundCategory.setImageResource(mImagesRound.get("goods"));
                mRoundCategory.setVisibility(View.VISIBLE);
                animation(pizza, mRoundCategory);
                mAnimHandler = new Handler();
                mAnimHandler.postDelayed(new Runnable() {


                    @Override
                    public void run() {
                        pizza.setVisibility(View.GONE);
                        intent = new Intent(getContext(), CategoryActivity.class);
                        intent.putExtra("code", REQ_GOODS);
                        startActivity(intent);
                    }
                }, 1200);


                break;
            case R.id.transport_image:
                mRoundCategory.setImageResource(mImagesRound.get("transport"));
                mRoundCategory.setVisibility(View.VISIBLE);
                animation(pizza, mRoundCategory);
                mAnimHandler = new Handler();

                mAnimHandler.postDelayed(new Runnable() {


                    @Override
                    public void run() {

                        pizza.setVisibility(View.GONE);
                        intent = new Intent(getContext(), CategoryActivity.class);
                        intent.putExtra("code", REQ_TRANSPORT);
                        startActivity(intent);
                    }
                }, 1200);


                break;
            case R.id.service_image:
                mRoundCategory.setImageResource(mImagesRound.get("service"));
                mRoundCategory.setVisibility(View.VISIBLE);
                animation(pizza, mRoundCategory);
                mAnimHandler = new Handler();

                mAnimHandler.postDelayed(new Runnable() {


                    @Override
                    public void run() {

                        pizza.setVisibility(View.GONE);
                        intent = new Intent(getContext(), CategoryActivity.class);
                        intent.putExtra("code", REQ_SERVICE);
                        startActivity(intent);
                    }
                }, 1200);


                break;
            case R.id.realty_image:
                mRoundCategory.setImageResource(mImagesRound.get("realty"));
                mRoundCategory.setVisibility(View.VISIBLE);
                animation(pizza, mRoundCategory);
                mAnimHandler = new Handler();

                mAnimHandler.postDelayed(new Runnable() {


                    @Override
                    public void run() {

                        pizza.setVisibility(View.GONE);
                        intent = new Intent(getContext(), CategoryActivity.class);
                        intent.putExtra("code", REQ_REALTY);
                        startActivity(intent);
                    }
                }, 1200);


                break;
            case R.id.fab:
                intent = new Intent(getContext(), AddActivity.class);
                startActivity(intent);
                break;


        }


    }

    public void animation(View view, ImageView imageView) {

        ObjectAnimator alphaAnimatorPizza = ObjectAnimator.ofFloat(view, "alpha", 0f);
        alphaAnimatorPizza.setDuration(500);
        ObjectAnimator alphaAnimatorRound = ObjectAnimator.ofFloat(imageView, "alpha", 1f);
        alphaAnimatorRound.setDuration(500);

        alphaAnimatorRound.setStartDelay(600);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(alphaAnimatorPizza, alphaAnimatorRound);
        animatorSet.start();


    }


    @Override
    public void onResume() {


        super.onResume();
        pizza.setAlpha(1);
        pizza.setVisibility(View.VISIBLE);
        mRoundCategory.setAlpha(0f);
        mRoundCategory.setVisibility(View.GONE);
        getView().setFocusableInTouchMode(true);
        getView().requestFocus();
        getView().setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if (event.getAction() == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_BACK) {

                    getActivity().onBackPressed();


                }

                return true;
            }
        });

    }

}

