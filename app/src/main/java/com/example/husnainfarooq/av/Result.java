package com.example.husnainfarooq.av;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.ParseException;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.example.husnainfarooq.av.MainActivity.PInfo;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Result extends FragmentActivity implements ActionBar.TabListener {

    private ViewPager mViewPager;
    private PagerAdapter mPagerAdapter;
    private String title;
    public ArrayList<PInfo> lista;

    public ArrayList<PInfo> can_cost_money_obj;
    public ArrayList<PInfo> can_see_personal_info_obj;
    public ArrayList<PInfo> can_impact_battery_obj;
    public ArrayList<PInfo> can_change_system_obj;
    public ArrayList<PInfo> can_see_location_info_obj;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);


        can_cost_money_obj = getIntent().getParcelableArrayListExtra("can_cost_money_obj");
        can_see_personal_info_obj = getIntent().getParcelableArrayListExtra("can_see_personal_info_obj");
        can_impact_battery_obj = getIntent().getParcelableArrayListExtra("can_impact_battery_obj");
        can_change_system_obj = getIntent().getParcelableArrayListExtra("can_change_system_obj");
        can_see_location_info_obj = getIntent().getParcelableArrayListExtra("can_see_location_info_obj");

        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());

        final android.app.ActionBar actionBar = getActionBar();
        actionBar.setHomeButtonEnabled(false);
        actionBar.setNavigationMode(android.app.ActionBar.NAVIGATION_MODE_TABS);

        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mPagerAdapter);

        mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                actionBar.setSelectedNavigationItem(position);
            }
        });

        // For each of the sections in the app, add a tab to the action bar.
        for (int i = 0; i < mPagerAdapter.getCount(); i++) {
            actionBar.addTab(
                    actionBar.newTab()
                            .setText(mPagerAdapter.getPageTitle(i))
                            .setTabListener((android.app.ActionBar.TabListener) this));
        }


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }


    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        // When the given tab is selected, switch to the corresponding page in the ViewPager.
        mViewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Result Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }


    /**
     * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
     * sequence.
     */
    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            //if(position =)
            //can_cost_money_obj

            switch (position) {
                case 0:
                    lista = can_cost_money_obj;
                    break;
                case 1:
                    lista = can_see_personal_info_obj;
                    break;
                case 2:
                    lista = can_impact_battery_obj;
                    break;
                case 3:
                    lista = can_change_system_obj;
                    break;
                case 4:
                    lista = can_see_location_info_obj;
                    break;
            }

            return new ScreenSlidePageFragment(lista);

        }

        @Override
        public int getCount() {
            return 5;
        }

        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    title = "CAN COST ME MONEY";
                    break;
                case 1:
                    title = "CAN SEE PERSONAL INFO";
                    break;
                case 2:
                    title = "CAN IMPACT BATTERY";
                    break;
                case 3:
                    title = "CAN CHANGE SYSTEM";
                    break;
                case 4:
                    title = "CAN SEE LOCATION INFO";
                    break;
            }
            return title;
        }
    }


    public class ScreenSlidePageFragment extends Fragment {

        public ArrayList<PInfo> appovi;
        public ListView Lista;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_screen_slide_page, container, false);


            CustomAdapter adapter = new CustomAdapter(getActivity(), appovi);
            ListView Lista = (ListView) rootView.findViewById(R.id.Lista);
            Lista.setAdapter(adapter);


            return rootView;
        }


        public ScreenSlidePageFragment(ArrayList<PInfo> lista) {
            appovi = lista;

            Collections.sort(appovi, new Comparator<PInfo>() {
                public int compare(PInfo one, PInfo other) {

                    Integer i = new Integer(other.critical.size());

                    return i.compareTo(one.critical.size());
                }
            });
        }
    }


    /**
     * CUSTOM ADAPTER
     */
    public class CustomAdapter extends BaseAdapter {
        private Activity activity;
        private LayoutInflater inflater;
        private ArrayList<PInfo> data;


        public CustomAdapter(Activity activity, ArrayList<PInfo> items) {
            this.activity = activity;
            this.data = items;
        }

        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public Object getItem(int position) {
            return data.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        public void onListItemClick(ListView l, View v, int position, long id) {
            Log.i("FragmentList", "Item clicked: " + id);
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {


            if (inflater == null)
                inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            if (convertView == null)
                convertView = inflater.inflate(R.layout.list_item, null);

            try {

                ImageView slika = (ImageView) convertView.findViewById(R.id.slika);
                TextView naslov = (TextView) convertView.findViewById(R.id.naslov);
                TextView paket = (TextView) convertView.findViewById(R.id.paket);
                TextView critical = (TextView) convertView.findViewById(R.id.critical);


                String pname = data.get(position).pname;
                Drawable icon;

                try {

                    icon = getPackageManager().getApplicationIcon(pname);

                    slika.setImageDrawable(icon);
                    naslov.setText(data.get(position).appname);
                    paket.setText(data.get(position).pname);
                    critical.setText("" + data.get(position).critical.size());

                } catch (PackageManager.NameNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }


            } catch (ParseException e) {

                e.printStackTrace();

            }

            return convertView;

        }
    }


}






















