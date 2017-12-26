package com.hsy.express.ui;

import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.hsy.express.R;
import com.hsy.express.base.BaseActivity;
import com.hsy.express.bean.DeliveryBean;
import com.hsy.express.utils.Utils;
import com.show.api.ShowApiRequest;

import java.util.List;

public class QueryExpressActivity extends BaseActivity implements View.OnClickListener {
    RecyclerView recylerView;
    TextView     express_title;
    private TextView title;

    @Override
    protected int setLayoutResourceID() {
        return R.layout.activity_query_express;
    }

    @Override
    protected void setUpView() {
        findViewById(R.id.btn_query).setOnClickListener(this);
        recylerView = (RecyclerView) findViewById(R.id.recyler_view);
        express_title = (TextView) findViewById(R.id.express_title);
        title = (TextView) findViewById(R.id.title);
        findViewById(R.id.back).setOnClickListener(this);
        title.setText("运单查询");
    }

    @Override
    protected void setUpData() {
        super.setUpData();
        recylerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private EditText getTextNumber() {
        return (EditText) findViewById(R.id.text_number);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_query:
                queryNum();
                break;
            case R.id.back:
                finish();
                break;
        }
    }

    protected Handler mHandler = new Handler();

    private void queryNum() {
        final String num = getTextNumber().getText().toString();
        if (Utils.isEmpty(num)) {
            showMessage("运单号不能为空");
            return;
        }
        new Thread() {
            //在新线程中发送网络请求
            public void run() {
                String appid = "52984";//要替换成自己的
                String secret = "ce5d938e4a9b4c9d96d06f92516e6111";//要替换成自己的
                final String res = new ShowApiRequest("http://route.showapi.com/64-19", appid, secret)
                        .addTextPara("nu", num)
                        .addTextPara("com", "auto")
                        .post();
                System.out.println(res);
                //把返回内容通过handler对象更新到界面
                mHandler.post(new Thread() {
                    public void run() {
                        Gson gson = new Gson();
                        DeliveryBean deliver = gson.fromJson(res, DeliveryBean.class);
                        express_title.setText(deliver.getShowapi_res_body().getExpTextName());
                        RecyclerViewAdapter adapter = new RecyclerViewAdapter(deliver.getShowapi_res_body().getData());
                        recylerView.setAdapter(adapter);
                        adapter.notifyDataSetChanged();
                    }
                });
            }
        }.start();
    }

    private class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
        List<DeliveryBean.ShowapiResBodyBean.DataBean> data;

        public RecyclerViewAdapter(List<DeliveryBean.ShowapiResBodyBean.DataBean> data) {
            this.data = data;
        }

        @Override
        public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listview_item_logistics, parent, false);
            RecyclerViewAdapter.ViewHolder viewHolder = new RecyclerViewAdapter.ViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(RecyclerViewAdapter.ViewHolder holder, int position) {
            holder.logistics_time.setText(data.get(position).getTime());
            holder.logistics_address.setText(data.get(position).getContext());

        }

        @Override
        public int getItemCount() {
            return data.size() > 0 ? data.size() : 0;
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            public TextView line;
            public TextView logistics_address;
            public TextView logistics_time;

            public ViewHolder(View itemView) {
                super(itemView);

                logistics_address = (TextView) itemView
                        .findViewById(R.id.logistics_address);
                line = (TextView) itemView
                        .findViewById(R.id.line);
                logistics_time = (TextView) itemView
                        .findViewById(R.id.logistics_time);
            }
        }
    }
}
