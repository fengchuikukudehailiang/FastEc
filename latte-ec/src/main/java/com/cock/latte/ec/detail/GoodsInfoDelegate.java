package com.cock.latte.ec.detail;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cock.latte.core.delegates.LatteDelegate;
import com.cock.latte.ec.R;

import me.yokeyword.fragmentation.ISupportFragment;

public class GoodsInfoDelegate extends LatteDelegate {


    private static final String ARG_GOODS_DATA = "ARG_GOODS_DATA";
    private JSONObject mData = null;

    @Override
    public Object setLayout() {
        return R.layout.delegate_goods_info;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Bundle args = getArguments();
        final String goodsData;
        if (args != null) {
            goodsData = args.getString(ARG_GOODS_DATA);
            mData = JSON.parseObject(goodsData);
        }
    }

    public static ISupportFragment create(String goodsInfo) {
        final Bundle args = new Bundle();
        args.putString(ARG_GOODS_DATA, goodsInfo);
        final GoodsInfoDelegate delegate = new GoodsInfoDelegate();
        delegate.setArguments(args);
        return delegate;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {
        final AppCompatTextView goodsInfoTitle = $(R.id.tv_goods_info_title);
        final AppCompatTextView goodsInfoDesc = $(R.id.tv_goods_info_desc);
        final AppCompatTextView goodsInfoPrice = $(R.id.tv_goods_info_price);
        final String name = mData.getString("name");
        final String desc = mData.getString("description");
        final double price = mData.getDouble("price");
        goodsInfoTitle.setText(name);
        goodsInfoDesc.setText(desc);
        goodsInfoPrice.setText(String.valueOf(price));
    }


}
