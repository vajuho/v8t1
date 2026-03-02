package com.example.v8t1;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText EuroInput;
    private TextView ResultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EuroInput = findViewById(R.id.EuroInput);
        ResultText = findViewById(R.id.ResultText);
    }

    public void usdButton(View view) {
        String euroText = EuroInput.getText().toString();
        double usdValue = Double.parseDouble(euroText) * 1.05;
        ResultText.setText(String.format("$%.2f", usdValue));
    }

    public void gdpButton(View view) {
        String euroText = EuroInput.getText().toString();
        double gdpValue = Double.parseDouble(euroText) * 0.83;
        ResultText.setText(String.format("£%.2f", gdpValue));
    }
}