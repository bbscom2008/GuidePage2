package cn.itcast.www.sh;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.widget.RadioGroup;

import cn.itcast.www.sh.fragment.GovFragment;
import cn.itcast.www.sh.fragment.HomeFragment;
import cn.itcast.www.sh.fragment.NewsCenterFragment;
import cn.itcast.www.sh.fragment.SettingFragment;
import cn.itcast.www.sh.fragment.SmartServiceFragment;


/**
 * 点击底部按钮，切换上面的内容，实现方式：

     一：点击按钮 + 切换 fragment
     二：点击按钮 + 切换ViewPager
     三：点击按钮 + 切换view ( removeAllView 和 addView)
     四：点击按钮 + 显示一个view 隐藏 4个view
     五：TabHost 实现
 */
public class HomeActivity extends FragmentActivity implements RadioGroup.OnCheckedChangeListener {

    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frag_home);


        radioGroup = (RadioGroup) findViewById(R.id.main_radio);
        radioGroup.setOnCheckedChangeListener(this);

        // 默认显示第一个页面
        radioGroup.check(R.id.rb_function);

    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        Fragment fragment = null;

        switch (checkedId) {
            case R.id.rb_function : // 首页
                fragment = new HomeFragment();
                break;
            case R.id.rb_news_center : //
                fragment = new NewsCenterFragment();
                break;
            case R.id.rb_smart_service: //
                fragment = new SmartServiceFragment();
                break;
            case R.id.rb_gov_affairs : //
                fragment = new GovFragment();
                break;
            case R.id.rb_setting : //
                fragment = new SettingFragment();
                break;
        }

        // 用fragment 填充内容区域

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.layout_content,fragment)
                .commit();
    }
}
