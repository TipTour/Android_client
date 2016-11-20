package com.example.cholmink.tiptour_login;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.TextView;

import com.example.cholmink.tiptour_login.activities.NavigationDrawerActivity;
import com.example.cholmink.tiptour_login.data.StaticData;
import com.example.cholmink.tiptour_login.fragments.Fragment1_Information;
import com.example.cholmink.tiptour_login.fragments.Fragment2_GuideSettings;
import com.example.cholmink.tiptour_login.fragments.Fragment3_ProfileSetting;
import com.example.cholmink.tiptour_login.fragments.Fragment4_TourBox;
import com.example.cholmink.tiptour_login.fragments.Fragment5_TourSelection;

public class MainActivity extends NavigationDrawerActivity {
    private StaticData mData = StaticData.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }



    public void onMenuClickListener(View v){
        Fragment fragment = getFragment(v.getId());
        String toolbarString = ((TextView) findViewById(v.getId())).getText().toString();
        Bundle b = new Bundle();
        b.putString("text", toolbarString);

        try{
            fragment.setArguments(b);
        }catch (Exception e){
            e.printStackTrace();
        }

//        try{
//            fragment = (Fragment) fragmentClass.newInstance();
//        }catch (Exception e){
//            e.printStackTrace();
//        }

        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.mainFrame, fragment).commit();
        setToolbarText(toolbarString);
        closeDrawer();
    }

    private Fragment getFragment(int resId){
        Fragment newFragment = null;
        switch (resId) {
            case R.id.g1_menu1:
                newFragment = new Fragment5_TourSelection();
                break;
            case R.id.g1_menu2:
                newFragment = new Fragment4_TourBox();
                break;
            case R.id.g2_menu1:
                newFragment = new Fragment3_ProfileSetting();
                break;
            case R.id.g2_menu2:
                newFragment = new Fragment2_GuideSettings();
                break;
            case R.id.g2_menu3:
                newFragment = new Fragment1_Information();
                break;
        }
        return newFragment;
    }






}
