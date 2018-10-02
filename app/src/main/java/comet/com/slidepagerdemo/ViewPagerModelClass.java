package comet.com.slidepagerdemo;

import android.widget.ImageView;

/**
 * Created by starhawk on 24/06/18.
 */

public class ViewPagerModelClass {

    int imageView;
    String itemName;

    ViewPagerModelClass(int imageView,String itemName){
        this.imageView = imageView;
        this.itemName = itemName;
    }

    public int getImageView() {
        return imageView;
    }

    public void setImageView(int imageView) {
        this.imageView = imageView;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

}
