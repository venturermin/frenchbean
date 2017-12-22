package com.bumslap.bum.menuedit;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumslap.bum.DB.DBProvider;
import com.bumslap.bum.DB.Menu;
import com.bumslap.bum.R;

import java.util.ArrayList;

/**
 * Created by min on 12/8/17.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    ArrayList<Menu> menulist;
    public Menu menu;
    public DBProvider db;
    int layout;
    Context context;
    RecyclerView.Adapter mMyadapter;
    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    MenuSettingActivity menuSettingActivity;
    public MyAdapter(DBProvider db, int layout, ArrayList<Menu> menulist) {
        //ASSIGN THEM LOCALLY
        this.db = db;
        this.layout = layout;
        this.menulist = menulist;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,
                                         int viewType) {
        //VIEW OBJ FROM XML
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_layout, parent, false);

        ViewHolder vh = new ViewHolder(v);
        context = parent.getContext();
        return vh;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        menu = menulist.get(position);
        holder.mTextUniqueId.setText(menu.getMenu_id());
        holder.mTextViewTitle.setText(menu.getMenu_name());
        holder.mTextViewPrice.setText(menu.getMenu_price());

        //menulist = new ArrayList<com.bumslap.bum.DB.Menu>();
        //menulist.get(0).getMenu_id();


        byte[] Menubyteimage = menu.getMenu_image();
        Bitmap bitmap = BitmapFactory.decodeByteArray(Menubyteimage, 0, Menubyteimage.length);

        holder.mImageView.setImageBitmap(bitmap);

        holder.mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final CharSequence[] items = {"수정", "삭제"};
                android.app.AlertDialog.Builder alertDialogBuilder = new android.app.AlertDialog.Builder(
                        context);
                alertDialogBuilder.setTitle("수정및삭제");
                alertDialogBuilder.setItems(

                        items,new DialogInterface.OnClickListener()

                        {
                            public void onClick(DialogInterface dialog,
                                                int id) {

                                // 프로그램을 종료한다
                                switch (id) {
                                    case 0:
                                    Intent intent = new Intent(context, MenuUpdateActivity.class);
                                    intent.putExtra("id",menulist.get(position).getMenu_id());
                                    context.startActivity(intent);

                                        break;
                                    case 1:
                                        menuSettingActivity = new MenuSettingActivity();
                                        db.deleteData(menulist.get(position).getMenu_id());
                                        menulist.remove(position);
                                        notifyItemRemoved(position);
                                        notifyItemRangeChanged(position, menulist.size());
                                        break;

                                }
                                dialog.dismiss();
                            }
                        }

                );

                // 다이얼로그 생성
                android.app.AlertDialog alertDialog = alertDialogBuilder.create();

                // 다이얼로그 보여주기
                alertDialog.show();




        }
        });

    }

    @Override
    public int getItemCount() {
        return menulist.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView mImageView;
        public TextView mTextUniqueId;
        public TextView mTextViewTitle;
        public TextView mTextViewPrice;

        public com.bumslap.bum.DB.DBHelper mDBHelper;
        public RecyclerView.Adapter mAdapter;

        public ViewHolder(View view) {
            super(view);
          //  notifyDataSetChanged();
            mTextUniqueId = (TextView) view.findViewById(R.id.item_uniqueID);
            mImageView = (ImageView) view.findViewById(R.id.item_image);
            mTextViewTitle = (TextView) view.findViewById(R.id.item_title);
            mTextViewPrice = (TextView) view.findViewById(R.id.item_price);

            //occur image click
        }
    }

}

