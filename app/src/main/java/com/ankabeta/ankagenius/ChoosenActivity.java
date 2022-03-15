package com.ankabeta.ankagenius;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ChoosenActivity extends AppCompatActivity {
    CardView instruction, testing;
    String prevStarted = "yesChoosen";
    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedpreferences = getSharedPreferences(getString(R.string.app_name), Context.MODE_PRIVATE);
        if (!sharedpreferences.getBoolean(prevStarted, false)) {
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putBoolean(prevStarted, Boolean.TRUE);
            editor.apply();

            final AlertDialog.Builder alert = new AlertDialog.Builder(ChoosenActivity.this);
            View mView = getLayoutInflater().inflate(R.layout.custom_dialog,null);

            Button btn_okay = (Button)mView.findViewById(R.id.btn_okay);
            TextView headingText=mView.findViewById (R.id.headings);
            headingText.setVisibility( View.INVISIBLE );
            TextView textView=mView.findViewById (R.id.textFormodal);
            textView.setText ("IR ışınları yayan gizli kameralar, telefon kameranızın gece görüşü kullanılarak kolayca tespit edilebilir. Ancak bu günlerde piyasada IR ışınları bile yaymayan çok yüksek teknolojili gizli kameralar mevcuttur, bu nedenle manyetometre sensör simülasyonumuz bu casusları tespit etmenize yardımcı olur. kameralar çok kolay..");
            alert.setView(mView);
            final AlertDialog alertDialog = alert.create();
            alertDialog.setCanceledOnTouchOutside(false);
            btn_okay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    alertDialog.dismiss();
                }
            });
            alertDialog.show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_choosen );

        instruction = findViewById( R.id.inst );
        testing = findViewById(R.id.mag);

        instruction.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent( getApplicationContext(), MagnoInst.class ) );
            }
        } );

        testing.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent( getApplicationContext(), Magnetometer.class ) );
            }
        } );


    }
}