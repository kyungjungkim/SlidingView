package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private ListView lvNavList;
    private FrameLayout flContainer;
    private DrawerLayout dlDrawerLayout;
    private Button btn;


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


        // Create a BaseAdapter instance.
        BaseAdapter customBaseAdapter = new BaseAdapter() {
            // Return list view item count.
            @Override
            public int getCount() {
                return 5;
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


                // final String title = "1";


                TextView titleView = (TextView)itemView.findViewById(R.id.textView);

                if (0 == itemIndex) {
                    titleView.setText("1");
                } else if (1 == itemIndex) {
                    titleView.setText("2");
                } else if (2 == itemIndex) {
                    titleView.setText("3");
                } else if (3 == itemIndex) {
                    titleView.setText("4");
                } else {
                    titleView.setText("5");
                }


                return itemView;
            }
        };


        lvNavList = (ListView) findViewById(R.id.lv_activity_main_nav_list);

        // Set the custom base adapter to it.
        lvNavList.setAdapter(customBaseAdapter);

        flContainer = (FrameLayout) findViewById(R.id.fl_activity_main_container);
        btn = (Button) findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                dlDrawerLayout.openDrawer(lvNavList);
            }
        });


        dlDrawerLayout = (DrawerLayout) findViewById(R.id.dl_activity_main_drawerlayout);
    }


    private class DrawerItemClickListener implements ListView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
            switch (position) {
                case 0:
                    break;
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
            }
            
            /*
        if (isAll1Clicked && clickedSectionNum == 0) { // 전체버튼 클릭
            if (isAll1) { // 선택.
                [cell setSelected:YES animated:YES];
                [selectedName addObject:cell.nameLbl.text];
                [[isSectionSelected objectForKey:[NSNumber numberWithLong:indexPath.section]] isEqualToString:@"YES"];
                
                if (indexPath.row == [sectionData count] - 1)   // 마지막 셀
                    isAll1Clicked = NO;
                
                [menu layoutIfNeeded];
                
                return cell;
            } else if (!isAll1) { // 해제.
                [cell setSelected:NO animated:YES];
                [selectedName removeObjectAtIndex:indexPath.row];
                
                [[isSectionSelected objectForKey:[NSNumber numberWithLong:indexPath.section]] isEqualToString:@"NO"];
                
                if (indexPath.row == [sectionData count] - 1)   // 마지막 셀
                    isAll1Clicked = NO;
                
                [menu layoutIfNeeded];
            }
        }
    */

            dlDrawerLayout.closeDrawer(lvNavList);
        }
    }
}
