package com.bumslap.bum.menuedit;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.bumslap.bum.R;

/**
 * Created by jaein on 12/13/17.
 */

public class ViewHolderCost extends RecyclerView.ViewHolder {
    TextView Ingradient_name, Ingradient_price;
    CheckBox checkbox;
    public ViewHolderCost(final View itemView) {
        super(itemView);
        Ingradient_name = (TextView)itemView.findViewById(R.id.Ingradient_name);
        Ingradient_price = (TextView)itemView.findViewById(R.id.Ingradient_price);
        checkbox = (CheckBox)itemView.findViewById(R.id.checkBox);
    }


}
