package ly.generalassemb.drewmahrt.shoppinglistver2;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by NikitaShuvalov on 10/25/16.
 */

public class GroceryViewHolder extends RecyclerView.ViewHolder {
    TextView textView0, textView1, textView2, textView3;
    public GroceryViewHolder(View itemView) {
        super(itemView);
        textView0 = (TextView) itemView.findViewById(R.id.nameView);
        textView1 = (TextView) itemView.findViewById(R.id.descriptionView);
        textView2 = (TextView) itemView.findViewById(R.id.priceview);
        textView3 = (TextView) itemView.findViewById(R.id.typeview);

    }
}
