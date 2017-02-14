package com.computer.hdu.truckrental;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.computer.hdu.truckrental.adapter.MyAdapter;
import com.computer.hdu.truckrental.domain.Order;

import java.util.ArrayList;
import java.util.List;

public class DriverAllOrdersShowActivity extends AppCompatActivity {

    private ListView allOrdersListView;
    private List<Order> allOrdersList = new ArrayList<>();
    private MyAdapter allOrdersAdapter;
    private int totalNum,pageNum;
    private int pageSize = 15;
    private int currentPage = 1;
    private boolean isDivPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_all_orders_show);

        allOrdersListView = (ListView) findViewById(R.id.all_orders_ListView);
        put_info_list();
        allOrdersAdapter = new MyAdapter(this,allOrdersList);
        allOrdersListView.setAdapter(allOrdersAdapter);

        allOrdersListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                ListView listView = (ListView) parent;
                Order order = (Order) listView.getItemAtPosition(position);

                Bundle bundle = new Bundle();
                put_info_Bundle(bundle, order);
                Intent intent = new Intent(DriverAllOrdersShowActivity.this, DriverOrderDetailsShowActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    private void put_info_Bundle(Bundle bundle, Order order){
        bundle.putString("运货时间", order.getOrder_start_date());
        bundle.putString("下单时间", order.getOrder_date());
        bundle.putString("订单号", order.getOrder_number());
        bundle.putString("出发地址", order.getOrder_departure());
        bundle.putString("目的地址", order.getOrder_destination());
        bundle.putString("备注", order.getOrder_remarks());
        bundle.putFloat("路程数", order.getOrder_distance());
        bundle.putFloat("金额", order.getOrder_price());
        bundle.putInt("是否回程", order.getOrder_back());
        bundle.putInt("是否搬运", order.getOrder_carry());
        bundle.putInt("跟车人数", order.getOrder_followers());
    }

    private void put_info_list(){
        Order order1 = new Order();
        order1.setOrder_start_date("2017/2/10");
        order1.setFk_user_id(1);
        order1.setOrder_departure("兰溪");
        order1.setOrder_destination("金华");
        order1.setOrder_date("2017/2/10");
        order1.setOrder_number("111");
        order1.setOrder_remarks("无");
        order1.setOrder_distance(12);
        order1.setOrder_price(54);
        order1.setOrder_back(1);
        order1.setOrder_carry(1);
        order1.setOrder_followers(2);
        allOrdersList.add(order1);
    }
}
