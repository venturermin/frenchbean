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
        /*
        Ingradient_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder ad = new AlertDialog.Builder(CostSettingActivity.context);

                Context context = CostSettingActivity.context;
                LinearLayout layout = new LinearLayout(context);
                layout.setOrientation(LinearLayout.VERTICAL);

                ad.setTitle("원가 설정");

                final EditText titleBox = new EditText(context);
                titleBox.setHint("재료 명");
                layout.addView(titleBox);

                final EditText descriptionBox = new EditText(context);
                descriptionBox.setHint("재료 가격");
                layout.addView(descriptionBox);

                final Button updateBtn = new Button(context);
                updateBtn.setText("UPDATE");
                layout.addView(updateBtn);

                ad.setView(layout);
                ad.show();
            }
        });*/
    }


}
