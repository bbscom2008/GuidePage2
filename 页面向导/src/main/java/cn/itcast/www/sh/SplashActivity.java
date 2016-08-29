package cn.itcast.www.sh;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

public class SplashActivity extends Activity {

    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        sp = getSharedPreferences("config",MODE_PRIVATE);
        // 2秒以后，跳转至向导页面
        // 立刻发送一个消息，让系统2秒后，执行 handleMessage 方法
        handler.sendEmptyMessageDelayed(88,2000);

    }

    /**
     * 判断是否是第一次运行
     */
    private boolean isFirst;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            isFirst = sp.getBoolean("isFirst",true);

            isFirst = true; //为了永远都能看以向导页面

            Intent intent = null;
            // 第一次进入时跳转至向导页面
            if(isFirst){
                 intent = new Intent(SplashActivity.this,GuideActivity.class);
            }else{
                // 如果不是第一次，跳转至主页面
                intent = new Intent(SplashActivity.this,HomeActivity.class);
            }
            startActivity(intent);
            // 结束闪屏页面
            finish();;


        }
    };


}
