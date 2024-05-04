package com.example.orderingapp;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CustomToast
{
    ImageView iv;
    TextView tv_status, tv_message;
    public void myToast(Context context, int imgRID, String status, String message)
    {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_toast_layout, null);


        iv = view.findViewById(R.id.ivToastIcon);
        tv_status = view.findViewById(R.id.tvToastStatus);
        tv_message = view.findViewById(R.id.tvToastMessage);

        iv.setImageResource(imgRID);
        tv_status.setText(status);
        tv_message.setText(message);

        Toast toast = new Toast(context);
        toast.setView(view);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();

    }
}
