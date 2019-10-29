package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TabHost;

public class MainActivity extends AppCompatActivity {

    private final String[] navItems = {"1", "2", "3", "4", "5"};
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

        lvNavList = (ListView) findViewById(R.id.lv_activity_main_nav_list);
        flContainer = (FrameLayout) findViewById(R.id.fl_activity_main_container);
        btn = (Button) findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                dlDrawerLayout.openDrawer(lvNavList);
            }
        });

        dlDrawerLayout = (DrawerLayout) findViewById(R.id.dl_activity_main_drawerlayout);
        lvNavList.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, navItems));
        lvNavList.setOnItemClickListener(new DrawerItemClickListener());
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
