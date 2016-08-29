package cn.itcast.www.sh.fragment.guide;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import cn.itcast.www.sh.R;


public class GuideFragment2 extends Fragment {

    private int[] imageIds = {R.mipmap.guide_1, R.mipmap.guide_2
            , R.mipmap.guide_3};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ImageView imageView = new ImageView(getActivity());
        imageView.setBackgroundResource(imageIds[2]);

        return imageView;
    }
}
