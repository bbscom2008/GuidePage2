package cn.itcast.www.sh;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

import cn.itcast.www.sh.fragment.guide.GuideFragment0;
import cn.itcast.www.sh.fragment.guide.GuideFragment1;
import cn.itcast.www.sh.fragment.guide.GuideFragment2;

public class GuideActivity extends FragmentActivity {

    @ViewInject(R.id.viewPager)
    private ViewPager viewPager;

    @ViewInject(R.id.btn_go)
    private Button btnGo;

    private int[] imageIds = {R.mipmap.guide_1, R.mipmap.guide_2
            , R.mipmap.guide_3};

    private List<ImageView> imageList;
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        sp = getSharedPreferences("config",MODE_PRIVATE);

//        viewPager = (ViewPager) findViewById(R.id.viewPager);
//        btnGo = (Button) findViewById(R.id.btn_go);

        /**
         * 该方法会获得当前对象所有的包含注解 @ViewInject 成员变量,以及注解中的值 如：R.id.viewPager
         * 然后会从当前activity 的内容视图中查找指定的ID 并将结果赋值给 该变量
         * 当有注解的变量是当前activity,并ID 也是在activity的contentView 中时，使用该方法
         */
        ViewUtils.inject(this);

        /**
         * 参数一是 拥有注解的对象
         * 参数二 是 包含ID 的view
         */
//        ViewUtils.inject(handler,view);


        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sp.edit().putBoolean("isFirst",false).commit();

                Intent intent = new Intent(GuideActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });
        imageList = new ArrayList<ImageView>();
        for(int i=0;i<imageIds.length;i++){
            ImageView image = new ImageView(this);
            image.setBackgroundResource(imageIds[i]);

            imageList.add(image);
        }


//        adapter = new MyAdapter();
//        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            // 当页面滑动时，不断调用
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            // 当选择的页面发生变化时，调用此方法
            public void onPageSelected(int position) {

                if(position == imageList.size()-1){ // 说明是最后一个页面
                    btnGo.setVisibility(View.VISIBLE);
                }else{
                    btnGo.setVisibility(View.GONE);
                }
            }

            @Override
            // 当页面滑动状态发生改变时，调用
            public void onPageScrollStateChanged(int state) {
            }
        });



        fragmentList = new ArrayList<Fragment>();

        fragmentList.add(new GuideFragment0());
        fragmentList.add(new GuideFragment1());
        fragmentList.add(new GuideFragment2());

        viewPager.setAdapter(new MyFragmentAdapter(getSupportFragmentManager()));



//        HttpUtils httpUtils = new HttpUtils();
//        httpUtils.send(HttpRequest.HttpMethod.GET,url,params,callback);

    }

    private List<Fragment>  fragmentList;


    private class MyFragmentAdapter extends FragmentPagerAdapter{

        public MyFragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }
    }


//    private MyAdapter adapter;
//
//    private class MyAdapter extends PagerAdapter {
//
//        @Override
//        /**
//         * 告诉viewPager 有多少个页面
//         */
//        public int getCount() {
//            return imageList.size();
//        }
//
//        @Override
//        /**
//         * 当要初始化某个页面时，调用此应运
//         * @param container 其实就是viewPager 自己
//         * @param position 页面的下标
//         */
//        public Object instantiateItem(ViewGroup container, int position) {
//            // 在此方法中，我们要干二件事：
////            1- 根据 position 获得view,并添加至 container
//            View view = imageList.get(position);
//            container.addView(view);
//
//            // 2- 返回一个和view 有关系 的对象
//            return view;
//        }
//
//        @Override
//        /**
//         * 判断view 和object 之间的对应关系
//         * @params view 就是instantiateItem 方法当中，添加至 container 的view
//         * @params object 就是instantiateItem 方法的返回值
//         */
//        public boolean isViewFromObject(View view, Object object) {
//            return view == object;
//        }
//
//        @Override
//        /**
//         * 当要销毁某个条目时调用
//         * @params container viewPager 自己
//         * @params position 要销毁的页面下标
//         * @params object 该页面对应的对象，即 是instantiateItem 方法的返回值
//         */
//        public void destroyItem(ViewGroup container, int position, Object object) {
//            // 下面这句必须删除，否则会崩，原因，你懂的。
////            super.destroyItem(container, position, object);
//
//            // 根据 position 和 object 找到 view  将其从 container 中删除
//            container.removeView((View) object);
//        }
//    }


}
