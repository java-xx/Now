package top.wefor.now.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.umeng.analytics.MobclickAgent;

import top.wefor.now.R;

/**
 * Created by ice on 15/10/28.
 */
public class BaseFragment extends Fragment {
    protected RecyclerView mRecyclerView;
    protected View mLoadingView;

    public static BaseFragment newInstance() {
        return new BaseFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recyclerview, container, false);
        mLoadingView = view.findViewById(R.id.loading_view);
        mLoadingView.setVisibility(View.GONE);
        return view;
    }

    protected String pass(String string) {
        if (string == null) string = "";
        return string;
    }

    protected String pass(Integer integer) {
        if (integer == null) return "";
        return "" + integer;
    }

    protected void stopLoadingAnim() {
        if (mLoadingView != null)
            mLoadingView.setVisibility(View.GONE);
    }

    protected void showLoadingAnim() {
        if (mLoadingView != null)
            mLoadingView.setVisibility(View.VISIBLE);
    }

    public void onResume() {
        super.onResume();
        MobclickAgent.onPageStart("MainScreen"); //统计页面
    }

    public void onPause() {
        super.onPause();
        MobclickAgent.onPageEnd("MainScreen");
    }
}
