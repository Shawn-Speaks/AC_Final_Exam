package shawn.c4q.nyc.finalexam;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Context context;
    private ImageButton[] buttonList = new ImageButton[4];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        context = getApplicationContext();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        initButtons();
        initButtonListener();

    }


    private void initButtons(){
        ImageButton btn1, btn2, btn3, btn4;

        btn1 = (ImageButton) findViewById(R.id.row_btn_1);
        btn2 = (ImageButton) findViewById(R.id.row_btn_2);
        btn3 = (ImageButton) findViewById(R.id.row_btn_3);
        btn4 = (ImageButton) findViewById(R.id.row_btn_4);

        buttonList[0] = btn1;
        buttonList[1] = btn2;
        buttonList[2] = btn3;
        buttonList[3] = btn4;
    }

    private void initButtonListener(){
        for(ImageButton iButton: buttonList){
            iButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    switch(view.getId()) {
                        case R.id.row_btn_1:
                            btn1Action();
                            break;
                        case R.id.row_btn_2:
                            btn2Action();
                            break;
                        case R.id.row_btn_3:
                            btn3Action();
                            break;
                        case R.id.row_btn_4:
                            btn4Action();
                            break;
                    }
                }
            });
        }
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            btn1Action();
        } else if (id == R.id.nav_gallery) {
            btn2Action();
        } else if (id == R.id.nav_slideshow) {
            btn3Action();
        } else if (id == R.id.nav_manage) {
            btn4Action();
        }
        return true;
    }





    private void btn1Action(){
        String button1Text = "Selected Heart Activity";
        Toast.makeText(context, button1Text, Toast.LENGTH_SHORT).show();
    }

    private void btn2Action(){
        String button2Text = "Selected Message Activity";
        Toast.makeText(context, button2Text, Toast.LENGTH_SHORT).show();
    }

    private void btn3Action(){
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }

    private void btn4Action(){
        String button4Text = "Selected Logout Actiity";
        Toast.makeText(context, button4Text, Toast.LENGTH_SHORT).show();
        int q = android.os.Process.myPid();
        android.os.Process.killProcess(q);
        System.exit(0);
    }

}
