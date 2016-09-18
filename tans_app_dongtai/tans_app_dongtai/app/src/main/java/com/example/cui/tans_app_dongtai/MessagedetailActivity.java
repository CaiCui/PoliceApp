package com.example.cui.tans_app_dongtai;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

public class MessagedetailActivity extends AppCompatActivity {

    private TextView detailtx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_message_detail_content);
        Toolbar toolbar = (Toolbar) findViewById(R.id.activity_message_detailcontent_toolbar);
        toolbar.setNavigationIcon(R.drawable.jiaojingdongtai_action_back_normal);
        toolbar.setOnCreateContextMenuListener(this);
        toolbar.setNavigationOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                finish();
            }

        });
        detailtx=(TextView)findViewById(R.id.message_detailitem_title);
        Intent getvalue=getIntent();
        Bundle bd = getvalue.getExtras();
        switch (bd.getString("NUM"))
        {
            case "2":
            {
                detailtx.setText("详情如下:\n近日，铁路部门公布，为迎接郑徐高铁开通，计划在本月10日进行一轮大规模调图，初步计划新增高铁列车46对，其中将有半数直通西安。记者昨日登录12306购票网站发现，通过郑徐高铁从西安前往上海、青岛、福州和大连等方向9月10日后的高铁车票目前已经开售。\n" +
                        "　　郑徐高铁途经河南、安徽、江苏3个省份，西起郑州东站，东至徐州东站，线路全长361.937公里，速度目标值为每小时350公里，郑徐高铁开通后，其将与现有的郑西高铁相连，将西安真正带入东部高铁网络。\n" +
                        "　　记者昨日从西安铁路局了解到，本周，他们将正式公布调图后西安铁路局管内新增开往全国各城市列车的详细信息。而从目前铁路部门公布的信息看，此次调图后，因郑徐高铁开通而新增的高铁列车数将达到46对，其中，有半数将直通西安。\n" +
                        "　　记者昨日登录中国铁路总公司12306购票网站发现，本月10日后，西安前往上海、青岛、福州等方向的高铁车票已经可以购买，与过去相比，乘客前往这些地方的时间将大大缩短，郑徐高铁开通后，与西安实现高铁直连的大中城市将再增加近20个。\n" +
                        "　　以前往上海为例，9月9日，从西安前往上海的最快的列车为D308次，耗时11小时12分，9月10日，从西安北站前往上海虹桥站的最快一趟高铁列车G362次的耗时只有5小时58分，一下子节约了5个多小时的时间。再以前往福州为例，9月9日，前往福州最快的T308次列车耗时23小时18分，如果在9月11日，旅客乘坐G1904次高铁列车的话，上午10时31分从西安出发的话，当天21时49分就能到达福州，时间缩短了一半。\n" +
                        "　　除此之外，从西安到大连以前没有火车，而9月10日后，G1294次高铁列车会将两座城市用铁路相连，11时05分从西安出发，11个小时后就将到达大连。");
                break;
            }

        }
    }
}
