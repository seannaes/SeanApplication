package igs.android.sean.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import igs.android.sean.R;
import igs.android.sean.ui.view.DividerGridItemDecoration;

/**
 *
 */
public class MainActivity extends Activity {

    private RecyclerView mRecyclerView;
    private List<String> mDatas = null;
    private HomeAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.RV_Content);
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
        mRecyclerView.setAdapter(mAdapter = new HomeAdapter());
        //设置Item增加、移除动画
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        //添加分割线
        mRecyclerView.addItemDecoration(new DividerGridItemDecoration(MainActivity.this));
        initData();
    }

    protected void initData() {
        mDatas = new ArrayList<String>();
        for (int i = 'A'; i < 'z'; i++) {
            mDatas.add("" + (char) i);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_appcompat, menu);
//        return super.onCreateOptionsMenu(menu);
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
    }

//    @Override
//    public boolean onMenuItemSelected(int featureId, MenuItem item) {
//        Log.w(this.getPackageName(),item.getTitle().toString());
//        return super.onMenuItemSelected(featureId, item);
//    }

    class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
                    MainActivity.this).inflate(R.layout.item_main, parent,
                    false));
            return holder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.TV_ItemActivity.setText(mDatas.get(position));
            holder.TV_ItemActivity.setHeight(50+(int)(Math.random()*100));
        }

        @Override
        public int getItemCount() {
            if (mDatas == null) {
                return 0;
            }
            return mDatas.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder {

            TextView TV_ItemActivity;

            public MyViewHolder(View view) {
                super(view);
                TV_ItemActivity = (TextView) view.findViewById(R.id.TV_ItemActivity);
            }
        }
    }

}
