package ucucite.edu.finger_licken_good;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class home extends AppCompatActivity {

    TextView tview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //tview=findViewById(R.id.textview);

        // tview.setTextColor(Color.rgb(21,34,105));
        //tview.setShadowLayer(1.6f,4.5f,1.3f,Color.WHITE);

    }

    //Code Go to List of recipes
    public void gotohome(View view) {
        Intent intent = new Intent(home.this, chooserecipe.class);
        startActivity(intent);
    }

    //Code to Exit or cancel the app
    public void exit(View view) {

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("Are you sure you want to Exit?");
        alertDialogBuilder.setPositiveButton("Yes",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        finish();
                        System.exit(0);
                    }
                });

        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    public void prog(View view) {
        Intent intent = new Intent(home.this, programmer.class);
        startActivity(intent);
    }
}