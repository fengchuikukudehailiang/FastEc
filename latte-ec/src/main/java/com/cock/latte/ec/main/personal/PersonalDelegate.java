package com.cock.latte.ec.main.personal;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.cock.latte.core.delegates.bottom.BottomItemDelegate;
import com.cock.latte.ec.R;
import com.cock.latte.ec.main.personal.list.ListAdapter;
import com.cock.latte.ec.main.personal.list.ListBean;
import com.cock.latte.ec.main.personal.list.ListItemType;

import java.util.ArrayList;
import java.util.List;

public class PersonalDelegate extends BottomItemDelegate {
    @Override
    public Object setLayout() {
        return R.layout.delegate_personal;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {

        final RecyclerView rvSettings = $(R.id.rv_personal_setting);
        $(R.id.tv_all_order).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickAllOrder();
            }
        });
        $(R.id.img_user_avatar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickAvatar();
            }
        });

        final ListBean address = new ListBean.Builder()
                .setItemType(ListItemType.ITEM_NORMAL)
                .setId(1)
                .setText("收货地址")
                .build();

        final ListBean system = new ListBean.Builder()
                .setItemType(ListItemType.ITEM_NORMAL)
                .setId(2)
                .setText("系统设置")
                .build();

        final List<ListBean> data = new ArrayList<>();
        data.add(address);
        data.add(system);

        //设置RecyclerView
        final LinearLayoutManager manager = new LinearLayoutManager(getContext());
        rvSettings.setLayoutManager(manager);
        final ListAdapter adapter = new ListAdapter(data);
        rvSettings.setAdapter(adapter);
    }

    private void onClickAllOrder() {

    }

    private void onClickAvatar() {

    }
}
