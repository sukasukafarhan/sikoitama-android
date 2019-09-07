package com.fatkhun.agriculture.mvp.ui.fragmentsdata;

import android.animation.ValueAnimator;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dinuscxj.progressbar.CircleProgressBar;
import com.fatkhun.agriculture.mvp.R;
import com.fatkhun.agriculture.mvp.data.network.model.AverageDataResponse;
import com.fatkhun.agriculture.mvp.data.network.model.DataKoiResponse;
import com.fatkhun.agriculture.mvp.di.component.ActivityComponent;
import com.fatkhun.agriculture.mvp.ui.base.BaseFragment;

import org.eazegraph.lib.charts.ValueLineChart;
import org.eazegraph.lib.models.ValueLinePoint;
import org.eazegraph.lib.models.ValueLineSeries;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;


public class DataFragment extends BaseFragment implements DataFragmentMvpView {

    @Inject
    DataFragmentMvpPresenter<DataFragmentMvpView> mPresenter;

    @BindView(R.id.tv_temperature)
    TextView tvTemp;

    @BindView(R.id.tv_ph)
    TextView tvPh;

    @BindView(R.id.line_chart_temperature)
    ValueLineChart lineChartTemperature;

    @BindView(R.id.line_chart_ph)
    ValueLineChart lineChartPh;

    public static DataFragment newInstance() {
        Bundle args = new Bundle();
        DataFragment fragment = new DataFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_data, container, false);

        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
            setUnBinder(ButterKnife.bind(this, view));
            mPresenter.onAttach(this);
        }
        return view;
    }

    @Override
    protected void setUp(View view) {
//        mPresenter.getAverageDataAll();
        mPresenter.getDataKoi();
    }

    @Override
    public void onDestroyView() {
        mPresenter.onDetach();
        super.onDestroyView();
    }

    @Override
    public void setupAverageDataAll(List<AverageDataResponse> averageDataResponse) {
        List<String> time = new ArrayList<>();
        List<Integer> temperature = new ArrayList<>();
        List<Integer> soilMoisture = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        List<Integer> water = new ArrayList<>();


//        time.add(dateConverter(averageDataResponse.get(0).getId()));
//        time.add(dateConverter((averageDataResponse.get(1).getId())));
//        time.add(dateConverter((averageDataResponse.get(2).getId())));
//        time.add(dateConverter((averageDataResponse.get(3).getId())));
//        time.add(dateConverter((averageDataResponse.get(4).getId())));
//        time.add(dateConverter((averageDataResponse.get(5).getId())));
//        time.add(dateConverter((averageDataResponse.get(6).getId())));
//        time.add(dateConverter((averageDataResponse.get(7).getId())));
//        time.add(dateConverter((averageDataResponse.get(8).getId())));
//        time.add(dateConverter((averageDataResponse.get(9).getId())));
//        time.add(dateConverter((averageDataResponse.get(10).getId())));
//        time.add(dateConverter((averageDataResponse.get(11).getId())));


//        temperature.add(Math.round(averageDataResponse.get(0).getAvgHumidity()));
//        temperature.add(Math.round((averageDataResponse.get(1).getAvgHumidity())));
//        temperature.add(Math.round((averageDataResponse.get(2).getAvgHumidity())));
//        temperature.add(Math.round((averageDataResponse.get(3).getAvgHumidity())));
//        temperature.add(Math.round((averageDataResponse.get(4).getAvgHumidity())));
//        temperature.add(Math.round((averageDataResponse.get(5).getAvgHumidity())));
//        temperature.add(Math.round((averageDataResponse.get(6).getAvgHumidity())));
//        temperature.add(Math.round((averageDataResponse.get(7).getAvgHumidity())));
//        temperature.add(Math.round((averageDataResponse.get(8).getAvgHumidity())));
//        temperature.add(Math.round((averageDataResponse.get(9).getAvgHumidity())));
//        temperature.add(Math.round((averageDataResponse.get(10).getAvgHumidity())));
//        temperature.add(Math.round((averageDataResponse.get(11).getAvgHumidity())));
//
//        soilMoisture.add(Math.round((averageDataResponse.get(0).getAvgSoilMoisture())));
//        soilMoisture.add(Math.round((averageDataResponse.get(1).getAvgSoilMoisture())));
//        soilMoisture.add(Math.round((averageDataResponse.get(2).getAvgSoilMoisture())));
//        soilMoisture.add(Math.round((averageDataResponse.get(3).getAvgSoilMoisture())));
//        soilMoisture.add(Math.round((averageDataResponse.get(4).getAvgSoilMoisture())));
//        soilMoisture.add(Math.round((averageDataResponse.get(5).getAvgSoilMoisture())));
//        soilMoisture.add(Math.round((averageDataResponse.get(6).getAvgSoilMoisture())));
//        soilMoisture.add(Math.round((averageDataResponse.get(7).getAvgSoilMoisture())));
//        soilMoisture.add(Math.round((averageDataResponse.get(8).getAvgSoilMoisture())));
//        soilMoisture.add(Math.round((averageDataResponse.get(9).getAvgSoilMoisture())));
//        soilMoisture.add(Math.round((averageDataResponse.get(10).getAvgSoilMoisture())));
//        soilMoisture.add(Math.round((averageDataResponse.get(11).getAvgSoilMoisture())));
//
//        temp.add(Math.round((averageDataResponse.get(0).getAvgTemp())));
//        temp.add(Math.round((averageDataResponse.get(1).getAvgTemp())));
//        temp.add(Math.round((averageDataResponse.get(2).getAvgTemp())));
//        temp.add(Math.round((averageDataResponse.get(3).getAvgTemp())));
//        temp.add(Math.round((averageDataResponse.get(4).getAvgTemp())));
//        temp.add(Math.round((averageDataResponse.get(5).getAvgTemp())));
//        temp.add(Math.round((averageDataResponse.get(6).getAvgTemp())));
//        temp.add(Math.round((averageDataResponse.get(7).getAvgTemp())));
//        temp.add(Math.round((averageDataResponse.get(8).getAvgTemp())));
//        temp.add(Math.round((averageDataResponse.get(9).getAvgTemp())));
//        temp.add(Math.round((averageDataResponse.get(10).getAvgTemp())));
//        temp.add(Math.round((averageDataResponse.get(11).getAvgTemp())));
//
//        water.add(Math.round((averageDataResponse.get(0).getAvgWater())));
//        water.add(Math.round((averageDataResponse.get(1).getAvgWater())));
//        water.add(Math.round((averageDataResponse.get(2).getAvgWater())));
//        water.add(Math.round((averageDataResponse.get(3).getAvgWater())));
//        water.add(Math.round((averageDataResponse.get(4).getAvgWater())));
//        water.add(Math.round((averageDataResponse.get(5).getAvgWater())));
//        water.add(Math.round((averageDataResponse.get(6).getAvgWater())));
//        water.add(Math.round((averageDataResponse.get(7).getAvgWater())));
//        water.add(Math.round((averageDataResponse.get(8).getAvgWater())));
//        water.add(Math.round((averageDataResponse.get(9).getAvgWater())));
//        water.add(Math.round((averageDataResponse.get(10).getAvgWater())));
//        water.add(Math.round((averageDataResponse.get(11).getAvgWater())));


//        tvTemp.setText(String.valueOf(temp.get(0)));
//        tvWater.setText(String.valueOf(water.get(0)));

//        Log.d("HUMIDITY", "VALUE" + averageDataResponse.get(0).getAvgHumidity());

//        resultSensor(temperature, soilMoisture);
//        chartSensor(time, temperature, soilMoisture, temp, water);
    }

    @Override
    public void setupDataKoi(DataKoiResponse dataKoiResponse) {
        List<String> pH = new ArrayList<>();
        List<String> temperature = new ArrayList<>();

        temperature.add(dataKoiResponse.getSuhuData().get(0));
        temperature.add(dataKoiResponse.getSuhuData().get(1));
        temperature.add(dataKoiResponse.getSuhuData().get(2));
        temperature.add(dataKoiResponse.getSuhuData().get(3));
        temperature.add(dataKoiResponse.getSuhuData().get(4));
        temperature.add(dataKoiResponse.getSuhuData().get(5));
        temperature.add(dataKoiResponse.getSuhuData().get(6));
        temperature.add(dataKoiResponse.getSuhuData().get(7));
        temperature.add(dataKoiResponse.getSuhuData().get(8));
        temperature.add(dataKoiResponse.getSuhuData().get(9));

        pH.add(dataKoiResponse.getPHdata().get(0));
        pH.add(dataKoiResponse.getPHdata().get(1));
        pH.add(dataKoiResponse.getPHdata().get(2));
        pH.add(dataKoiResponse.getPHdata().get(3));
        pH.add(dataKoiResponse.getPHdata().get(4));
        pH.add(dataKoiResponse.getPHdata().get(5));
        pH.add(dataKoiResponse.getPHdata().get(6));
        pH.add(dataKoiResponse.getPHdata().get(7));
        pH.add(dataKoiResponse.getPHdata().get(8));
        pH.add(dataKoiResponse.getPHdata().get(9));

        tvTemp.setText(String.valueOf(temperature.get(0)));
        tvPh.setText(String.valueOf(pH.get(0)));

//        resultSensor(temperature, pH);
        chartSensor(temperature, pH);
    }

    private void chartSensor(List<String> temperatures, List<String> pHs
                            ){
        ValueLineSeries temperature = new ValueLineSeries();
        temperature.setColor(0xFF55C8F0);

        temperature.addPoint(new ValueLinePoint("", 0));
        temperature.addPoint(new ValueLinePoint("", 1));
        temperature.addPoint(new ValueLinePoint("", 2));
        temperature.addPoint(new ValueLinePoint("", 3));
        temperature.addPoint(new ValueLinePoint("", 4));
        temperature.addPoint(new ValueLinePoint("", 5));
        temperature.addPoint(new ValueLinePoint("", 6));
        temperature.addPoint(new ValueLinePoint("", 7));
        temperature.addPoint(new ValueLinePoint("", 8));
        temperature.addPoint(new ValueLinePoint("", 9));

        lineChartTemperature.addSeries(temperature);
        lineChartTemperature.startAnimation();

        ValueLineSeries pH = new ValueLineSeries();
        pH.setColor(0xFF78DC96);

        pH.addPoint(new ValueLinePoint("", 0));
        pH.addPoint(new ValueLinePoint("", 1));
        pH.addPoint(new ValueLinePoint("", 2));
        pH.addPoint(new ValueLinePoint("", 3));
        pH.addPoint(new ValueLinePoint("", 4));
        pH.addPoint(new ValueLinePoint("", 5));
        pH.addPoint(new ValueLinePoint("", 6));
        pH.addPoint(new ValueLinePoint("", 7));
        pH.addPoint(new ValueLinePoint("", 8));
        pH.addPoint(new ValueLinePoint("", 9));

        lineChartPh.addSeries(pH);
        lineChartPh.startAnimation();

//        ValueLineSeries temperature = new ValueLineSeries();
//        temperature.setColor(0xFFFFA500);
//
//        temperature.addPoint(new ValueLinePoint(times.get(0), temps.get(0)));
//        temperature.addPoint(new ValueLinePoint(times.get(1), temps.get(1)));
//        temperature.addPoint(new ValueLinePoint(times.get(2), temps.get(2)));
//        temperature.addPoint(new ValueLinePoint(times.get(3), temps.get(3)));
//        temperature.addPoint(new ValueLinePoint(times.get(4), temps.get(4)));
//        temperature.addPoint(new ValueLinePoint(times.get(5), temps.get(5)));
//        temperature.addPoint(new ValueLinePoint(times.get(6), temps.get(6)));
//        temperature.addPoint(new ValueLinePoint(times.get(7), temps.get(7)));
//        temperature.addPoint(new ValueLinePoint(times.get(8), temps.get(8)));
//        temperature.addPoint(new ValueLinePoint(times.get(9), temps.get(9)));
//        temperature.addPoint(new ValueLinePoint(times.get(10), temps.get(10)));
//        temperature.addPoint(new ValueLinePoint(times.get(11), temps.get(11)));
//
//        lineChartTemperature.addSeries(temperature);
//        lineChartTemperature.startAnimation();

//        ValueLineSeries water = new ValueLineSeries();
//        water.setColor(0xFF56B7F1);
//
//        water.addPoint(new ValueLinePoint(times.get(0), waters.get(0)));
//        water.addPoint(new ValueLinePoint(times.get(1), waters.get(1)));
//        water.addPoint(new ValueLinePoint(times.get(2), waters.get(2)));
//        water.addPoint(new ValueLinePoint(times.get(3), waters.get(3)));
//        water.addPoint(new ValueLinePoint(times.get(4), waters.get(4)));
//        water.addPoint(new ValueLinePoint(times.get(5), waters.get(5)));
//        water.addPoint(new ValueLinePoint(times.get(6), waters.get(6)));
//        water.addPoint(new ValueLinePoint(times.get(7), waters.get(7)));
//        water.addPoint(new ValueLinePoint(times.get(8), waters.get(8)));
//        water.addPoint(new ValueLinePoint(times.get(9), waters.get(9)));
//        water.addPoint(new ValueLinePoint(times.get(10), waters.get(10)));
//        water.addPoint(new ValueLinePoint(times.get(11), waters.get(11)));
//
//        lineChartWater.addSeries(water);
//        lineChartWater.startAnimation();
    }

//    private void resultSensor(List<Float> humidity, List<Float> soilMoisture){
//        ValueAnimator humiditys = ValueAnimator.ofInt(0, humidity.get(0));
//        ValueAnimator soilMoistures = ValueAnimator.ofInt(0, soilMoisture.get(0));
//
//        humiditys.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                Integer progress = (Integer) animation.getAnimatedValue();
//                try{
//                    if ( progress != null) {
//                        cpHumidity.setProgress(progress);
//                    }else {
//                        cpHumidity.setProgress(0);
//                    }
//                }catch (Exception e){
//                    e.printStackTrace();
//                }
//            }
//        });
//        humiditys.setDuration(2000);
//        humiditys.start();
//        soilMoistures.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                Integer progress = (Integer) animation.getAnimatedValue();
//                try{
//                    if ( progress != null) {
//                        cpSoilMoisture.setProgress(progress);
//                    }else {
//                        cpSoilMoisture.setProgress(0);
//                    }
//                }catch (Exception e){
//                    e.printStackTrace();
//                }
//            }
//        });
//        soilMoistures.setDuration(2000);
//        soilMoistures.start();
//    }

    private String dateConverter(String dateInput){
        try {
            SimpleDateFormat spf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
            Date newDate = null;
            newDate = spf.parse(dateInput);
            spf= new SimpleDateFormat("HH:mm a");
            String returnDate = spf.format(newDate);
            return returnDate;

        }catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
