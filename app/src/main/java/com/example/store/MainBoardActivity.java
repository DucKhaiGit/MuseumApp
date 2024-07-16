package com.example.store;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TableLayout;
import android.widget.Toast;

import com.example.store.fragment.ViewPagerAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainBoardActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private BottomNavigationView bottomNavigationView;

    private LoginVM loginVM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_board);
        viewPager = findViewById(R.id.view_pager);
        bottomNavigationView=findViewById(R.id.bottom_navigation);
        // Lấy giá trị getRole từ Intent
        String userRole = getIntent().getStringExtra("userRole");
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        bottomNavigationView.getMenu().findItem(R.id.menu_forum).setChecked(true);
                        break;
                    case 1:
                        bottomNavigationView.getMenu().findItem(R.id.menu_cart).setChecked(true);
                        break;
                    case 2:
                        bottomNavigationView.getMenu().findItem(R.id.menu_lucky).setChecked(true);
                        break;
                }

            }
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            int currentItem =0;
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int itemId = item.getItemId();
                if (itemId == R.id.menu_forum) {
                    viewPager.setCurrentItem(0);
                    currentItem = 0;
                } else if (itemId == R.id.menu_cart) {
                    viewPager.setCurrentItem(1);
                    currentItem = 1;
                } else if (itemId == R.id.menu_lucky) {
                    if(userRole.equals("admin") == true)
                    {
                        viewPager.setCurrentItem(2);
                    }
                    else{
                        Toast.makeText(MainBoardActivity.this,"Bạn không đủ quyền truy cập vào trang này",Toast.LENGTH_SHORT).show();
                        viewPager.setCurrentItem(currentItem);
                    }

                }
                return true;
            }
        });

    }
}