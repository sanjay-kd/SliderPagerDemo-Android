package comet.com.slidepagerdemo;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by starhawk on 24/06/18.
 */

public class ViewPagerAdapter extends PagerAdapter {

    ArrayList<ViewPagerModelClass> arrayList = new ArrayList<>();
    Context context;
    public int itemAddedToCart[];
    TextView totalOrders;

    ViewPagerAdapter(ArrayList<ViewPagerModelClass> arrayList , Context context){
        this.arrayList = arrayList;
        this.context = context;
        itemAddedToCart = new int[arrayList.size()];
    }

    public void removeView(int index) {
        arrayList.remove(index);
        notifyDataSetChanged();
    }

    @Override
    public int getItemPosition(Object object) {
        if (arrayList.contains((View) object)) {
            return arrayList.indexOf((View) object);
        }
        else {
            return POSITION_NONE;
        }
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);

    }

    @Override
    public Object instantiateItem(final ViewGroup container, final int position) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.viewpager_item_layout,container,false);

        ImageView imageView = view.findViewById(R.id.imageView);
        ImageView removeItem = view.findViewById(R.id.removeItem);
        ImageView addToCart = view.findViewById(R.id.addToCart);
        totalOrders = view.findViewById(R.id.totalOrders);

        ViewPagerModelClass viewPagerModelClass = arrayList.get(position);

        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                itemAddedToCart[position] = itemAddedToCart[position]+1;
                System.out.println("Item at "+position+" "+itemAddedToCart[position]);
                totalOrders.setText(String.valueOf(itemAddedToCart[position]));
            }
        });

        removeItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeView(position);
            }
        });

        imageView.setImageResource(viewPagerModelClass.getImageView());
        removeItem.setImageResource(R.drawable.cancel);
        addToCart.setImageResource(R.drawable.cart);

        container.addView(view);

        return view;
    }
}
