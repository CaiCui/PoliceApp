package com.example.cui.tans_app_dongtai;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class TravelGuide extends AppCompatActivity {

    private TextView stitle;//西安交警
    private TextView text_1;
    private TextView text_2;
    private TextView text_3;
    private TextView text_4;
    private TextView text_5;
    private TextView text_6;
    private ImageView pic0;//pic_0
    private ImageView pic1;
    private ImageView pic2;
    private ImageView pic3;
    private ImageView pic4;
    private ImageView pic5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_travel_guide);
        //Init
        stitle=(TextView)findViewById(R.id.travelguide_page_stitle);
        text_1=(TextView)findViewById(R.id.travelguide_page_text_1);
        text_1.setText("注：交通拥堵延时指数反映出交通的拥堵程度，[1，1.2]为“畅通”，（1.2，1.5]为“基本畅通”，（1.5，1.8]为“轻度拥堵”，（1.8，2.1]为“中度拥堵”，2.1以上为“严重拥堵”。\n" +
                "\n" +
                "上周全天拥堵排名靠前路段在空间上的分布如下图二所示。\n");
        text_2=(TextView)findViewById(R.id.travelguide_page_text_2);
        text_2.setText("上周通勤日24小时拥堵在时间上的分布规律如下图三和图四所示。");
        text_3=(TextView)findViewById(R.id.travelguide_page_text_3);
        text_3.setText("二、道路交通综述\n" +
                "（一）高德地图研判市区内道路拥堵状况\n" +
                "上周早高峰（7:00~9:00）周四（9月1日）拥堵最严重，拥堵延时指数达到峰值1.89；晚高峰（17:00~19:00）周五（9月2日）拥堵最严重，拥堵延时指数达到峰值2.06。上周早晚高峰各天拥堵延时指数如图五所示。");
        text_4=(TextView)findViewById(R.id.travelguide_page_text_4);
        text_4.setText("三、拥堵原因分析\n" +
                "（一）常规拥堵\n" +
                "上周拥堵情况环比前一周小幅上升，主要是学校集中开学，交通出行较为集中，且总量增加，导致全天拥堵及高峰期拥堵程度加剧，其中，高峰期尤为显著。\n" +
                "全市总的过江（湖）桥梁交通量环比前一周小幅上升，尤其是三环线周边桥梁，除货运交通需求影响外，外地学生到武汉上学也刺激了三环线周边桥梁通行需求。\n" +
                "（二）异常拥堵");
        text_5=(TextView)findViewById(R.id.travelguide_page_text_5);
        text_5.setText("四、本周预测分析\n" +
                "（一）根据中国天气网专业预报，本周主要以晴朗天气为主，气温维持在30°左右，道路通行将受到较小影响。");
        text_6=(TextView)findViewById(R.id.travelguide_page_text_6);
        text_6.setText("（二）本周仍然为开学季，为确保学校周边交通秩序良好，尽量避免交通拥堵现象，交管交管部门将开展为期一个月的秋季护学护校行动。因此，建议如下：\n" +
                "一是各区交通大队及时掌握学校开学时间，提前进行交通疏导，尤其是在学校上学、放学高峰期间，确保交通安全和畅通。\n" +
                "二是完善学校周边交通指示标志及安全警告标志，降低开车接送学生家长因不熟悉路况而盲目寻找目的地导致的拥堵和交通事故导致的拥堵。\n" +
                "三是各区交通大队进一步加强学校周边区域道路、进出城通道、火车站、客运站、二环线、三环线等重要路段的交通管理，及时进行交通疏导。\n" +
                "四是各区交通大队加强对校园周边巡逻守控，严查机动车违停和电动车聚集、非法营运等违法行为。\n" +
                "五是各区交通大队协调城管部门加强校园周边小摊小贩占道经营管理。");

        pic0=(ImageView)findViewById(R.id.travelguide_pic_0);
        pic0.setImageResource(R.drawable.travelguide_pic0);
        pic1=(ImageView)findViewById(R.id.travelguide_pic_1);
        pic1.setImageResource(R.drawable.travelguide_pic1);
        pic2=(ImageView)findViewById(R.id.travelguide_pic_2);
        pic2.setImageResource(R.drawable.travelguide_pic2);
        pic3=(ImageView)findViewById(R.id.travelguide_pic_3);
        pic3.setImageResource(R.drawable.travelguide_pic3);
        pic4=(ImageView)findViewById(R.id.travelguide_pic_4);
        pic4.setImageResource(R.drawable.travelguide_pic4);
        pic5=(ImageView)findViewById(R.id.travelguide_pic_5);
        pic5.setImageResource(R.drawable.travelguide_pic5);

        //字体点击事件处理
        String stitletext="西安交警";
        SpannableString ss=new SpannableString(stitletext);
        MyClickableSpan clickspan=new MyClickableSpan(this,stitletext);
        ss.setSpan(clickspan,0, stitletext.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        stitle.setText(ss);
        stitle.setMovementMethod(LinkMovementMethod.getInstance());

        /**设置部分字体改变
          *content=(TextView)findViewById(R.id.travelguide_page_text_0);
          *String str1="设置改变部分字体颜色";
          *SpannableStringBuilder ssb=new SpannableStringBuilder(str1);
          *ssb.setSpan(new ForegroundColorSpan(Color.RED),0,5, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
          *content.setText(ssb);
          *或者
          *content.setText(Html.fromHtml("使用 Html <font color = blue> 来实现部分字体颜色的改变</font>"));

          设置部分字体颜色改变并且可以点击
          *content=(TextView)findViewById(R.id.travelguide_page_text_0);*String str2="实现部分字体颜色改变";
          *String str3="并且可以点击";
          *这里无论是使用  SpannableString 还是  SpannableStringBuilder 都一样
          *SpannableString ss=new SpannableString(str3);
          *MyClickableSpan clickspan=new MyClickableSpan(this,str3);
          *ss.setSpan(clickspan,0, str3.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
          *content.setText(str2);
          *content.append(ss);
          *必须加下面这句，否则无法被点击
          *content.setMovementMethod(LinkMovementMethod.getInstance());
        */

    }
    /**
     * MyClickableSpan类用于处理部分的字体点击事件
     */
    public class MyClickableSpan extends ClickableSpan{
        private Context context;
        private String text;

        public MyClickableSpan(Context context,String text)
        {
              this.context=context;
              this.text=text;
        }
        //这里设置字体，颜色等属性
        public void updateDrawState(TextPaint ds)
        {
            //ds.setColor(Color.RED);
        }
        @Override //设置点击事件
        public void onClick(View widget){
            //Intent intent = new Intent(MainActivity.this,OtherActivity.class);
            //startActivity(intent);
            Toast.makeText(getApplicationContext(),"你点击了",Toast.LENGTH_SHORT).show();
        }
    }
}

