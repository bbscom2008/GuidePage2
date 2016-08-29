package cn.itcast.www.sh.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lidroid.xutils.view.annotation.ViewInject;

import cn.itcast.www.sh.R;


public class HomeFragment extends Fragment {

    @ViewInject(R.id.btn_go)
    TextView textView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

//        View view;
//
//        TextView btnGo = view.findViewById(R.id.btn_go);

        TextView textView = new TextView(getActivity());
        textView.setText("我是首页面");

        return textView;
    }
}
