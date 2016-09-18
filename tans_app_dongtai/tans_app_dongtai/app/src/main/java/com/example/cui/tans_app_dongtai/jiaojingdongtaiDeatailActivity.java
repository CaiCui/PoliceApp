package com.example.cui.tans_app_dongtai;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

public class jiaojingdongtaiDeatailActivity extends AppCompatActivity {

    private TextView tx;
    private TextView stitle;
    private TextView text;
    private ImageView img;
    private static final String[]news=new String[]{
            "关于西安互助路、北二环两处路段将封闭改造通知","2016年07月02日","     三条进出城快速路的开工建设，标志着西安城市快速路系统进入大建设、大发展阶段，对有效提高城市路网的服务水平，提升城市服务功能，改善城市环境，提高人民群众生活质量，具有重要意义。\n" +
            "　　昆明路快速路总投资20.3亿元，工程西起西三环立交，东至高新四路，全长5.7公里。该项目是城西片区二环与三环之间的快速连接线，建成后可有效提升城西进出城的交通承载力。\n" +
            "　　西延路快速路总投资3.72亿元，工程南起北池头一路，北至南二环太乙路立交南侧，全长1.8公里。该项目建成后可有效缓解城南二、三环连接线节点的交通拥堵问题。\n" +
            "　　建工路—新兴南路快速路总投资12.26亿元，工程西起建工路东南二环立交，东至新兴南路东三环立交，全长7.84公里，一期建设为东南二环立交（三期）、建工路高架段、幸福路长鸣路立交及新兴南路地面段，二期建设为新兴南路高架段。该项目是城东片区二、三环新的连接线，建成后可连接纺织城火车站，成为城市东南区域主要通行道路。\n" +
            "　　昆明路快速路\n" +
            "　　西起西三环立交，东至高新四路，全长5.7公里\n" +
            "　　西延路快速路\n" +
            "　　南起北池头一路，北至南二环太乙路立交南侧，全长1.8公里\n" +
            "　　建工路—新兴南路快速路\n" +
            "　　西起建工路东南二环立交，东至新兴南路东三环立交，全长7.84公里\n" +
            "　　今年我市将新建成 2万个停车位" +
            "本报讯 昨日记者从市建委获悉，\"十三五\"期间，全市将主要按照PPP融资建设模式推进公共停车场建设。目前，已策划包装公共停车场PPP项目49个，总投资23.5亿元，并按照行政区域划分为4个项目包。根据《政府工作报告》要求，今年我市新开工建设出行停车位5万个，年内完成2万个。目前，已开工建设3.5万个，建成1.4万个。"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_jiaojingdongtai_detail_content);
        Toolbar toolbar = (Toolbar) findViewById(R.id.activity_detail_toolbar);
        toolbar.setNavigationIcon(R.drawable.jiaojingdongtai_action_back_normal);
        toolbar.setOnCreateContextMenuListener(this);
        toolbar.setNavigationOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                finish();
            }

        });

        tx=(TextView)findViewById(R.id.detail_page_title);
        stitle=(TextView)findViewById(R.id.detail_page_stitle);
        text=(TextView)findViewById(R.id.detail_page_text);
        img=(ImageView)findViewById(R.id.pic);


        Intent getvalue=getIntent();
        Bundle bd = getvalue.getExtras();
        switch (bd.getString("NUM"))
        {
            case "0":
            {
                tx.setText(news[0]);
                stitle.setText(news[1]);
                text.setText(news[2]);
                break;
            }
            case "1":
            {
                tx.setText(news[0]);
                stitle.setText(news[1]);
                text.setText(news[2]);
                img.setImageResource(R.drawable.jiaojingdongtai_car);
                break;
            }
        }

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.jiaojingdongtai_menu_home, menu);
        return  true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.home) {

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
