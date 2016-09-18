package com.example.cui.tans_app_dongtai;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class jiaojingdongtaiMainActivity extends AppCompatActivity {
    private static final String[]strgs=new String[]{
            "西安互助路、北二环两处路段将封闭改造","[图]首批六年免检车到期 月初审车人最少","组图：阎良交警为破案2天2夜没睡觉",
            "西安交警网络直播夜查酒驾 42万网友围观","买车不再是梦 5万元也有靠谱选择","西部文博会今日开幕 展馆免费开放",
            "西安三条进出城快速路开建 连接二环三环","西安交警网络直播高速 17万网友围观点赞","道路设施维修西汉高速堵车 禁止货车通行",
            "10日全国新增46对高铁列车 半数直通西安","西安临潼高速小车通行费拟由10元降至5元","西安审计城区占道停车收费问题 乱象严重",
            "西安兴善寺西街 把停车线涂黑就开始罚款","借来小轿车撞伤人 车主被判承担赔偿责任","贴心设计 一商场针对新司机推出超宽车位",
            "油价每升上调一毛四50升92号汽油多掏7元","道沿违法停车新规推两周 道上仍车来车往","业主怕罚款挤满院子 小区停车位借机涨价"
    };
    private ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_jiaojingdongtai_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.activity_main_toolbar);
        toolbar.setNavigationIcon(R.drawable.jiaojingdongtai_action_back_normal);
        toolbar.setOnCreateContextMenuListener(this);
        toolbar.setNavigationOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                finish();
            }

        });
        lv = (ListView) findViewById(R.id.listView);
        bindchoose(0);

    }
    public void bindchoose(int type)
    {
        ArrayList<HashMap<String, Object>>listItem = new ArrayList<HashMap<String,Object>>();
        switch(type)
        {
            case 0: {
                for(int i=0;i<18;i++)
                {
                    HashMap<String, Object> map = new HashMap<String, Object>();
                    map.put("Itemtitle", strgs[i]);
                    if(((i+1)*2)%30<10)
                        map.put("Itemtext", "2016年"+"07月"+"0"+((i+1)*2)%29+"日");
                    else
                        map.put("Itemtext", "2016年"+"07月"+((i+1)*2)%30+"日");
                    listItem.add(map);
                }
                break;
            }
            case 1: {
                for(int i=1;i<18;i+=2)
                {
                    HashMap<String, Object> map = new HashMap<String, Object>();
                    map.put("Itemtitle", strgs[i]);
                    if(((i+1)*2)%30<10)
                        map.put("Itemtext", "2016年"+"07月"+"0"+((i+1)*2)%29+"日");
                    else
                        map.put("Itemtext", "2016年"+"07月"+((i+1)*2)%30+"日");
                    listItem.add(map);
                }
                break;
            }
            case 2: {
                for(int i=2;i<18;i+=3)
                {
                    HashMap<String, Object> map = new HashMap<String, Object>();
                    map.put("Itemtitle", strgs[i]);
                    if(((i+1)*2)%30<10)
                        map.put("Itemtext", "2016年"+"07月"+"0"+((i+1)*2)%29+"日");
                    else
                        map.put("Itemtext", "2016年"+"07月"+((i+1)*2)%30+"日");
                    listItem.add(map);
                }
                break;
            }
        }
        SimpleAdapter mSimpleAdapter = new SimpleAdapter(this,listItem,R.layout.activity_jiaojingdongtai_item_list,new String[] {"Itemtitle", "Itemtext"},
                new int[] {R.id.Itemtitle,R.id.Itemtext} );
        lv.setAdapter(mSimpleAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                //点击后在标题上显示点击了第几行
                //Toast.makeText(getApplicationContext(), "你点击了第"+arg2+"行",
                //Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                intent.setClass(jiaojingdongtaiMainActivity.this,jiaojingdongtaiDeatailActivity.class);
                //传递数据行号
                String n;
                n=""+arg2;
                intent.putExtra("NUM",n);
                startActivity(intent);

            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.jiaojingdongtai_menu_choose, menu);
        return  true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.home) {
            Toast.makeText(getApplicationContext(), "返回主页",
                    Toast.LENGTH_SHORT).show();
            return true;
        }
        if(id == R.id.all)
        {
            bindchoose(0);
            return true;
        }
        if(id==R.id.Announcement)
        {
            bindchoose(1);
            return true;
        }
        if(id==R.id.Law)
        {
            bindchoose(2);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
