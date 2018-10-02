package comet.com.slidepagerdemo;

import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<ViewPagerModelClass> arrayList = new ArrayList<>();
    LinearLayout linearLayout;
    ViewPager viewPager;
    TextView[] favouriteDots;
    ViewPagerAdapter viewPagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewPager);
        linearLayout = findViewById(R.id.layout);

        arrayList.add(new ViewPagerModelClass(R.drawable.burger, "Burger"));
        arrayList.add(new ViewPagerModelClass(R.drawable.pasta, "Pasta"));
        arrayList.add(new ViewPagerModelClass(R.drawable.ice_cream, "Ice Cream"));
        arrayList.add(new ViewPagerModelClass(R.drawable.burger, "Burger"));
        arrayList.add(new ViewPagerModelClass(R.drawable.pasta, "Pasta"));
        arrayList.add(new ViewPagerModelClass(R.drawable.ice_cream, "Ice Cream"));

        viewPagerAdapter = new ViewPagerAdapter(arrayList, getApplicationContext());
        viewPager.setAdapter(viewPagerAdapter);

        viewPagerAdapter.notifyDataSetChanged();

        setFavouriteDots(0);
        viewPager.addOnPageChangeListener(onPageChangeListener);



    }


    public void setFavouriteDots(int position) {

        linearLayout.removeAllViews();

        favouriteDots = new TextView[arrayList.size()];

        for (int i = 0; i < favouriteDots.length; i++) {

            favouriteDots[i] = new TextView(getApplicationContext());
            favouriteDots[i].setText(Html.fromHtml("&#8226;"));
            favouriteDots[i].setTextSize(50);
            favouriteDots[i].setTextColor(getResources().getColor(R.color.colorTransparent));
            favouriteDots[i].setGravity(Gravity.CENTER_VERTICAL);
            linearLayout.addView(favouriteDots[i]);

        }

        if (favouriteDots.length > 0) {
            favouriteDots[position].setTextColor(Color.parseColor("#000000"));
        }


    }

    ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            LayoutInflater layoutInflater = LayoutInflater.from(getApplicationContext());
            View view = layoutInflater.inflate(R.layout.viewpager_item_layout,null);

            TextView textView = view.findViewById(R.id.totalOrders);
            textView.setText(String.valueOf(viewPagerAdapter.itemAddedToCart[position]));
        }

        @Override
        public void onPageSelected(int position) {

            setFavouriteDots(position);

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };



}
