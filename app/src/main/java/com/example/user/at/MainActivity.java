package com.example.user.at;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    TextView toolbarTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme_NoActionBar);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);               //커스텀 타이틀 사용
        toolbarTitle = (TextView) findViewById(R.id.toolbar_Title);

        getSupportActionBar().setDisplayShowTitleEnabled(false);        //커스텀 타이틀을 사용하기 때문에 기존 타이틀 사용 안함

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    public void my_info(View v){            //내정보(네비게이션 드로어 헤더 부분) 클릭 시
        My_Info_List_Fragment My_Info_List_Fragment=new My_Info_List_Fragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,My_Info_List_Fragment).addToBackStack(null).commit();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }

    @Override
    public void onBackPressed() {                       //뒤로가기 클릭 시
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {     //드로우어가 열려있다면 닫음
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {         //옵션메뉴 생성
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {           //옵션아이템(홈버튼) 클릭 시
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_GoHome) {         //홈버튼 클릭 시
            FragmentTest fragmentTest = new FragmentTest();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragmentTest).commit();     //처음화면으로
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {        //네비게이션 아이템 클릭 시
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_text) {          //글 클릭 시
            // Handle the camera action
        } else if (id == R.id.nav_image) {  //그림 클릭 시

        } else if (id == R.id.nav_music) {  //음악 클릭 시

        } else if (id == R.id.nav_message) {    //쪽지 클릭 시
            Letter_Main Letter_Main = new Letter_Main();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, Letter_Main).addToBackStack(null).commit();

        } else if (id == R.id.nav_like) {       //관심 있는 작품 클릭 시

        } else if (id == R.id.nav_help) {       //고객센터 클릭 시
            FragmentHelp fragmentHelp = new FragmentHelp();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragmentHelp).addToBackStack(null).commit();
        } else if (id == R.id.nav_setting) {    //설정 클릭 시

        } else if (id == R.id.nav_logout) {     //로그아웃 클릭 시

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);        //네비게이션 아이템 클릭 후에는 드로우어 닫음
        return true;
    }

}
