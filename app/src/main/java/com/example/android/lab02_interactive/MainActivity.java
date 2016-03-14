package com.example.android.lab02_interactive;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    // Order 按鈕按下時執行 (好萊塢會找我們)
    public void submitOrder(View view) {
        display(2);
    }

    private void display(int number) {
        TextView quantityTextView = (TextView)findViewById(R.id.quantity_text_view);
        quantityTextView.setText(String.valueOf(number));

        TextView priceTextView = (TextView)findViewById(R.id.price_text_view);
        int price = 10;
        int total = price * number;
        String myString = NumberFormat.getCurrencyInstance().format(total);
        priceTextView.setText(myString);

    }

    public void increment(View view) {
        // 從 TextView 取得目前數量，數量加 1 並顯示
        int quanitty = getQuanitty();
        display(++quanitty);
    }

    private int getQuanitty() {
        TextView quantityTextView = (TextView)findViewById(R.id.quantity_text_view);
        String quantityString = quantityTextView.getText().toString();
        return Integer.parseInt(quantityString);
    }

    public void decrement(View view) {
        // 從 TextView 取得目前數量，數量減 1 並顯示
        int quanitty = getQuanitty();
        if(quanitty > 0) {
            display(--quanitty);
        }
    }

}
