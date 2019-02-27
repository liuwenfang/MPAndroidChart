package com.example.admin.mpandroidchart;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.BubbleChart;
import com.github.mikephil.charting.charts.CandleStickChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.BubbleDataSet;
import com.github.mikephil.charting.data.BubbleEntry;
import com.github.mikephil.charting.data.CandleDataSet;
import com.github.mikephil.charting.data.CandleEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class MainActivity extends AppCompatActivity {
    LineChart lineChart;
//BubbleChart lineChart;//散点图
//    BarChart lineChart;
    TextView text;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lineChart =  findViewById(R.id.myLineChart);
        text = findViewById(R.id.text);
        text.setTextColor(R.color.colorAccent);
        List<Entry> entities = new ArrayList<>();
        for (int i = 1; i < 8; i++) {
            entities.add(new Entry(i,new Random().nextInt(30)));
        }
//        BarDataSet barDataSet = new BarDataSet(entities, "label");//柱状型
        // LineDataSet dataSet = new LineDataSet(entities,"℃");
//        dataSet.setCircleColor(R.color.colorAccent);//圆点颜色
//        dataSet.setColor(R.color.colorPrimary);//线条颜色
//        dataSet.setLineWidth(1f);//线条宽度

        LineDataSet barDataSet = new LineDataSet(entities,"la");

//        BubbleDataSet data = new BubbleDataSet(entities,"lab");
//        BarData data = new BarData(barDataSet);//柱状型
        barDataSet.setDrawCircleHole(false);
        barDataSet.setMode(LineDataSet.Mode.CUBIC_BEZIER);//曲线 默认是折线
        barDataSet.setCircleColor(R.color.colorAccent);

        LineData data = new LineData(barDataSet);//折线图
        lineChart.setData(data);
//        lineChart.setDragEnabled(true);//
//         lineChart.invalidate();

        //x和y轴样式
        YAxis rightAxis = lineChart.getAxisRight();
        rightAxis.setEnabled(false);//右边线条禁用

        XAxis xAxis = lineChart.getXAxis();
        xAxis.setTextColor(R.color.colorPrimaryDark);
        xAxis.setTextSize(11f);
        xAxis.setAxisMinimum(0f);
        xAxis.setDrawGridLines(true);//设置x轴上每个点对应的线
        xAxis.setDrawLabels(true);//绘制标签  指x轴上的对应数值
        xAxis.setDrawAxisLine(true);//是否绘制曲线
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);//设置x轴的显示位置
        xAxis.setGranularity(1f);//禁止放大后x轴标签重绘

    }
}
