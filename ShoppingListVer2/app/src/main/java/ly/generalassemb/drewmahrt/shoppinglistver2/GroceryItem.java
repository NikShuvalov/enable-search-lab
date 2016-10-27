package ly.generalassemb.drewmahrt.shoppinglistver2;

/**
 * Created by NikitaShuvalov on 10/25/16.
 */

public class GroceryItem {
    public String mItemName, mDescription, mPrice, mType, mId;

    public GroceryItem(String itemName, String description,  String price, String type, String id) {
        mItemName = itemName;
        mDescription = description;
        mPrice = price;
        mType = type;
        mId = id;
    }

    public String getItemName() {
        return mItemName;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getPrice() {
        return mPrice;
    }

    public String getType() {
        return mType;
    }

    public String getId() {
        return mId;
    }
}
