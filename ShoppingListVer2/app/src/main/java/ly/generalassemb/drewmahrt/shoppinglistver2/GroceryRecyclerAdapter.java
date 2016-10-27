package ly.generalassemb.drewmahrt.shoppinglistver2;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NikitaShuvalov on 10/25/16.
 */

public class GroceryRecyclerAdapter extends RecyclerView.Adapter<GroceryViewHolder> {

    ArrayList<GroceryItem> mGroceryItemArrayList;

    public GroceryRecyclerAdapter(ArrayList<GroceryItem> groceryItemArrayList) {
        mGroceryItemArrayList = groceryItemArrayList;
    }

    @Override
    public GroceryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_holder_form, null);
        return new GroceryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GroceryViewHolder holder, int position) {
        TextView nameView = (TextView) holder.itemView.findViewById(R.id.nameView);
        TextView descriptionView = (TextView) holder.itemView.findViewById(R.id.descriptionView);
        TextView priceView = (TextView) holder.itemView.findViewById(R.id.priceview);
        TextView typeView = (TextView) holder.itemView.findViewById(R.id.typeview);

        descriptionView.setText(mGroceryItemArrayList.get(position).getDescription());
        nameView.setText(mGroceryItemArrayList.get(position).getItemName());
        priceView.setText(mGroceryItemArrayList.get(position).getPrice());
        typeView.setText(mGroceryItemArrayList.get(position).getType());
    }

    @Override
    public int getItemCount() {
        return mGroceryItemArrayList.size();
    }
    public void replaceData(List<GroceryItem> newList){
        mGroceryItemArrayList = (ArrayList) newList;
        notifyDataSetChanged();
    }
}
