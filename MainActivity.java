package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.os.Bundle;
import android.widget.TabHost;

public class MainActivity extends AppCompatActivity {

    private ListView lvNavList;
    private FrameLayout flContainer;
    private DrawerLayout dlDrawerLayout;
    private Button btn;
    private Boolean isAll;
    private Boolean allState;

    @Override
    public void onBackPressed() {
        if (dlDrawerLayout.isDrawerOpen(lvNavList)) {
            dlDrawerLayout.closeDrawer(lvNavList);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        isAll = false;
        allState = false;


        // Create a BaseAdapter instance.
        BaseAdapter customBaseAdapter = new BaseAdapter() {
            // Return list view item count.
            @Override
            public int getCount() {
                return 4;
            }

            @Override
            public Object getItem(int i) {
                return null;
            }

            @Override
            public long getItemId(int i) {
                return 0;
            }

            @Override
            public View getView(int itemIndex, View itemView, ViewGroup viewGroup) {

                if (itemView == null) {   // First inflate the RelativeView object.
                    itemView = LayoutInflater.from(MainActivity.this).inflate(R.layout.activity_list_view_base_adapter, null);
                }


                TextView titleView = (TextView)itemView.findViewById(R.id.textView);

                if (0 == itemIndex) {
                    titleView.setText("All");
                } else if (1 == itemIndex) {
                    titleView.setText("1");
                } else if (2 == itemIndex) {
                    titleView.setText("2");
                } else if (3 == itemIndex) {
                    titleView.setText("3");
                }


                TextView lableView = (TextView)itemView.findViewById(R.id.lableView);
                lableView.setText("OFF");
                

                return itemView;
            }
        };


        lvNavList = (ListView) findViewById(R.id.lv_activity_main_nav_list);

        // Set the custom base adapter to it.
        lvNavList.setAdapter(customBaseAdapter);

        flContainer = (FrameLayout) findViewById(R.id.fl_activity_main_container);


        dlDrawerLayout = (DrawerLayout) findViewById(R.id.dl_activity_main_drawerlayout);
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                dlDrawerLayout.openDrawer(lvNavList);
            }
        });


        lvNavList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView lableView = (TextView)view.findViewById(R.id.lableView);

                if (0 == position) {
                    isAll = true;

                    if (lableView.getText().equals("OFF")) {
                        allState = true;
                        lableView.setText("ON");

                        lvNavList.performItemClick(lvNavList.getChildAt(1), 1, lvNavList.getChildAt(1).getId());
                        lvNavList.performItemClick(lvNavList.getChildAt(2), 2, lvNavList.getChildAt(2).getId());
                        lvNavList.performItemClick(lvNavList.getChildAt(3), 3, lvNavList.getChildAt(3).getId());
                    } else if (lableView.getText().equals("ON")) {
                        allState = false;
                        lableView.setText("OFF");

                        lvNavList.performItemClick(lvNavList.getChildAt(1), 1, lvNavList.getChildAt(1).getId());
                        lvNavList.performItemClick(lvNavList.getChildAt(2), 2, lvNavList.getChildAt(2).getId());
                        lvNavList.performItemClick(lvNavList.getChildAt(3), 3, lvNavList.getChildAt(3).getId());
                    }

                    isAll = false;
                } else if (1 == position) {
                    if (isAll == true) {
                        if (allState == true) {
                            if (lableView.getText().equals("OFF")) {
                                lableView.setText("ON");
                            }
                        } else {
                            if (lableView.getText().equals("ON")) {
                                lableView.setText("OFF");
                            }
                        }
                    } else {
                        if (lableView.getText().equals("OFF")) {
                            lableView.setText("ON");
                        } else if (lableView.getText().equals("ON")) {
                            lableView.setText("OFF");
                        }
                    }
                } else if (2 == position) {
                    if (isAll == true) {
                        if (allState == true) {
                            if (lableView.getText().equals("OFF")) {
                                lableView.setText("ON");
                            }
                        } else {
                            if (lableView.getText().equals("ON")) {
                                lableView.setText("OFF");
                            }
                        }
                    } else {
                        if (lableView.getText().equals("OFF")) {
                            lableView.setText("ON");
                        } else if (lableView.getText().equals("ON")) {
                            lableView.setText("OFF");
                        }
                    }
                } else if (3 == position) {
                    if (isAll == true) {
                        if (allState == true) {
                            if (lableView.getText().equals("OFF")) {
                                lableView.setText("ON");
                            }
                        } else {
                            if (lableView.getText().equals("ON")) {
                                lableView.setText("OFF");
                            }
                        }
                    } else {
                        if (lableView.getText().equals("OFF")) {
                            lableView.setText("ON");
                        } else if (lableView.getText().equals("ON")) {
                            lableView.setText("OFF");
                        }
                    }
                }

//                dlDrawerLayout.closeDrawer(lvNavList);
            }
        });

        TabHost tabHost1 = (TabHost) findViewById(R.id.tabHost1);
        tabHost1.setup();

        // 첫 번째 Tab. (탭 표시 텍스트:"TAB 1"), (페이지 뷰:"content1")
        TabHost.TabSpec ts1 = tabHost1.newTabSpec("Tab Spec 1");
        ts1.setContent(R.id.content1);
        ts1.setIndicator("TAB 1");
        tabHost1.addTab(ts1);

        // 두 번째 Tab. (탭 표시 텍스트:"TAB 2"), (페이지 뷰:"content2")
        TabHost.TabSpec ts2 = tabHost1.newTabSpec("Tab Spec 2");
        ts2.setContent(R.id.content2);
        ts2.setIndicator("TAB 2");
        tabHost1.addTab(ts2);

        // 세 번째 Tab. (탭 표시 텍스트:"TAB 3"), (페이지 뷰:"content3")
        TabHost.TabSpec ts3 = tabHost1.newTabSpec("Tab Spec 3");
        ts3.setContent(R.id.content3);
        ts3.setIndicator("TAB 3");
        tabHost1.addTab(ts3);
    }
}
