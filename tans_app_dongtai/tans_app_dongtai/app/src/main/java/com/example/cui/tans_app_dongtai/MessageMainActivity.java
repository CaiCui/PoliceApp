package com.example.cui.tans_app_dongtai;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class MessageMainActivity extends AppCompatActivity {
    private ListView mlv;
    private ImageView msgimg;
    private static final String[]msg=new String[]{
            "西安互助路、北二环两处路段将封闭改造","[图]首批六年免检车到期 月初审车人最少","组图：阎良交警为破案2天2夜没睡觉",
            "西安交警网络直播夜查酒驾 42万网友围观","买车不再是梦 5万元也有靠谱选择","西部文博会今日开幕 展馆免费开放"
    };
    private static final String[]txt=new String[]{
            "昨日下午，西安市举行城建PPP（公私合作模式）项目集中开工动员会。伴随着三条进出城快速路的开工建设，西安交通承载能力将进一步提升。预计\"十三五\"末，我市将建成多条连接二环与三环的快速路，届时将有望实现主城区上快速路不超过20分钟、","[图]首批六年免检车到期 月初审车人最少xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx","查看详情>",
            "西安交警网络直播夜查酒驾 42万网友围观","买车不再是梦 5万元也有靠谱选择","西部文博会今日开幕 展馆免费开放"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_message_page);

        Toolbar toolbar = (Toolbar) findViewById(R.id.activity_message_toolbar);

        mlv=(ListView)findViewById(R.id.messagelistView);
        msgimg=(ImageView)findViewById(R.id.message_pic) ;
        bindchoose(0);


    }
    public void bindchoose(int type) {
        ArrayList<HashMap<String, Object>> listItem = new ArrayList<HashMap<String, Object>>();
        switch (type) {
            case 0: {
                for (int i = 0; i < 6; i++) {
                    HashMap<String, Object> map = new HashMap<String, Object>();
                    map.put("m_Itemtitle", msg[i]);
                    if (((i + 1) * 2) % 30 < 10)
                        map.put("m_Itemtext", "2016年" + "07月" + "0" + ((i + 1) * 2) % 29 + "日");
                    else
                        map.put("m_Itemtext", "2016年" + "07月" + ((i + 1) * 2) % 30 + "日");
                    if(i==1)
                        map.put("m_pic",R.drawable.message_car);
                    else
                        map.put("m_Itemtextcontent",txt[i]);
                    listItem.add(map);
                }
                break;
            }
            case 1: {
                for (int i = 1; i < 6; i += 2) {
                    HashMap<String, Object> map = new HashMap<String, Object>();
                    map.put("m_Itemtitle", msg[i]);
                    if (((i + 1) * 2) % 30 < 10)
                        map.put("m_Itemtext", "2016年" + "07月" + "0" + ((i + 1) * 2) % 29 + "日");
                    else
                        map.put("m_Itemtext", "2016年" + "07月" + ((i + 1) * 2) % 30 + "日");
                    listItem.add(map);
                }
                break;
            }

        }
        SimpleAdapter mSimpleAdapter = new SimpleAdapter(this,listItem,R.layout.activity_message_item_list,new String[] {"m_Itemtitle", "m_Itemtext","m_Itemtextcontent","m_pic"},
                new int[] {R.id.m_Itemtitle,R.id.m_Itemtext,R.id.m_Itemtextcontent,R.id.message_pic} );
        mlv.setAdapter(mSimpleAdapter);
        mlv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                //点击后在标题上显示点击了第几行
                //Toast.makeText(getApplicationContext(), "你点击了第"+arg2+"行",
                //Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                intent.setClass(MessageMainActivity.this,MessagedetailActivity.class);
                //传递数据行号
                String n;
                n=""+arg2;
                if(n.equals("2"))
                {
                    intent.putExtra("NUM",n);
                    startActivity(intent);
                }
                else
                    return;

            }
        });
    }
}
