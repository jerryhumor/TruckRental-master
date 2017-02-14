package com.computer.hdu.truckrental;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class DriverRunningOrdersDetailsShowActivity extends AppCompatActivity {

    private TextView ShowPriceTextView,ShowStartDateTextView,ShowDistanceTextView,ShowRemarksTextView,ShowStatementTextView;
    private TextView ShowDepartureTextView,ShowDestinationTextView;
    private TextView ShowCarryTextView,ShowBackTextView,ShowFollowersTextView;
    private static final String TAG = "DriverRunningOrdersDeta";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_running_orders_details_show);
        Bundle bundle = getIntent().getExtras();

        Log.d(TAG, "onCreate: getBundle");
        ShowPriceTextView = (TextView) findViewById(R.id.details_price);
        ShowStartDateTextView = (TextView) findViewById(R.id.details_start_date);
        ShowDistanceTextView = (TextView) findViewById(R.id.details_distance);
        ShowRemarksTextView = (TextView) findViewById(R.id.details_remarks);
        //tv_show_statement = (TextView)findViewById(R.id.details_statement);
        ShowDepartureTextView = (TextView) findViewById(R.id.details_departure);
        ShowDestinationTextView = (TextView) findViewById(R.id.details_destination);
        ShowCarryTextView = (TextView) findViewById(R.id.details_carry);
        ShowBackTextView = (TextView) findViewById(R.id.details_back);
        ShowFollowersTextView = (TextView) findViewById(R.id.details_followers);
        Log.d(TAG, "onCreate: findViewById");

        if (bundle.getInt("是否回程") == 1) {
            ShowBackTextView.setText(R.string.back);
        }
        if (bundle.getInt("是否搬运") == 1) {
            ShowCarryTextView.setText(R.string.carry);
        }

        ShowStartDateTextView.setText(bundle.getString("运货时间"));
        ShowDistanceTextView.setText("" + bundle.getFloat("路程数") + "公里");
        ShowFollowersTextView.setText("跟车人数：" + Integer.toString(bundle.getInt("跟车人数")));
        ShowPriceTextView.setText("" + bundle.getFloat("金额") + "元");
        ShowDepartureTextView.setText(bundle.getString("出发地址"));
        ShowDestinationTextView.setText(bundle.getString("目的地址"));
        ShowRemarksTextView.setText("备注：" + bundle.getString("备注"));
        Log.d(TAG, "onCreate: setText");
    }

    public void btn_operate(View view){
        switch (view.getId())
        {
            case R.id.btn_price_details:
                Intent intent = new Intent(DriverRunningOrdersDetailsShowActivity.this,DriverPriceDetailsShowActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_take_order:
                //跳转订单进行页面
                intent = new Intent(DriverRunningOrdersDetailsShowActivity.this,DriverPriceDetailsShowActivity.class);
                startActivity(intent);
                break;
        }
    }
}
