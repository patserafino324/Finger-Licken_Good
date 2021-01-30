package ucucite.edu.finger_licken_good;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class chooserecipe extends AppCompatActivity {
    ImageButton chicken;
    ImageButton beef;
    ImageButton pork;
    ImageButton vegetables;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chooserecipe);

    }

    public void chicken(View view) {
        Intent intent = new Intent(chooserecipe.this, StartActivity.class);
        startActivity(intent);
    }

    public void vegetables(View view) {
        Intent intent = new Intent(chooserecipe.this, VegeStartActivity.class);
        startActivity(intent);
    }

    public void pork(View view) {
        Intent intent = new Intent(chooserecipe.this, PorkStartActivity.class);
        startActivity(intent);
    }

    public void beef(View view) {
        Intent intent = new Intent(chooserecipe.this, BeefStartActivity.class);
        startActivity(intent);
    }
}