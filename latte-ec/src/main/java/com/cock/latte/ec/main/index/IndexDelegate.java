package com.cock.latte.ec.main.index;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.cock.latte.core.delegates.bottom.BottomItemDelegate;
import com.cock.latte.core.utils.callback.CallbackManager;
import com.cock.latte.core.utils.callback.CallbackType;
import com.cock.latte.core.utils.callback.IGlobalCallback;
import com.cock.latte.core.utils.log.LatteLogger;
import com.cock.latte.ec.R;
import com.cock.latte.ec.main.EcBottomDelegate;
import com.cock.latte.ec.main.index.search.SearchDelegate;
import com.cock.latte.ui.recycler.divider.BaseDecoration;
import com.cock.latte.ui.refresh.RefreshHandler;
import com.joanzapata.iconify.widget.IconTextView;

public class IndexDelegate extends BottomItemDelegate implements View.OnFocusChangeListener {

    private RecyclerView mRecyclerView = null;
    private SwipeRefreshLayout mRefreshLayout = null;

    private RefreshHandler mRefreshHandler = null;

    @Override
    public Object setLayout() {
        return R.layout.delegate_index;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {
        mRecyclerView = $(R.id.rv_index);
        mRefreshLayout = $(R.id.srl_index);
        final IconTextView mIconScan = $(R.id.icon_index_scan);
        final AppCompatEditText mSearchView = $(R.id.et_search_view);
        mIconScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startScanWithCheck(getParentDelegate());
            }
        });
        mRefreshHandler = RefreshHandler.create(mRefreshLayout, mRecyclerView, new IndexDataConverter());
        CallbackManager.getInstance().addCallback(CallbackType.ON_SCAN, new IGlobalCallback() {
            @Override
            public void executeCallback(@Nullable Object args) {
                LatteLogger.d("得到的的二维码是" + args);
                Toast.makeText(getContext(), "得到的的二维码是" + args, Toast.LENGTH_SHORT).show();
            }
        });
        mSearchView.setOnFocusChangeListener(this);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    private void initRefreshLayout() {
        mRefreshLayout.setColorSchemeResources(
                android.R.color.holo_blue_bright,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light
        );
        mRefreshLayout.setProgressViewOffset(true, 120, 300);
    }

    private void initRecyclerView() {
        final GridLayoutManager manager = new GridLayoutManager(getContext(), 4);
        final Context context = getContext();
        mRecyclerView.setLayoutManager(manager);
        //边距现有问题
        if (context != null) {
            mRecyclerView.addItemDecoration
                    (BaseDecoration.create(ContextCompat.getColor(context, R.color.app_background), 10));
        }
        final EcBottomDelegate ecBottomDelegate = getParentDelegate();
        mRecyclerView.addOnItemTouchListener(IndexItemClickListener.create(ecBottomDelegate));
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        initRefreshLayout();
        initRecyclerView();
        mRefreshHandler.firstPage("index.php");
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (hasFocus) {
            getParentDelegate().start(new SearchDelegate());
        }
    }
}
