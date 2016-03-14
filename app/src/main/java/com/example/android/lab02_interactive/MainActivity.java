package com.example.android.lab02_interactive;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // m: Member ( Data Member 資料成員)
    private int mQuantity = 0; // 初始值
    private int mPrice = 5;    // 初始值 $5
    private final String mNT$ = "NT$";
    private StringBuilder mTotalPriceMessage = new StringBuilder("NT$");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    // Order 按鈕按下時執行 (好萊塢會找我們)
    public void submitOrder(View view) {
        displayTotalPrice();
    }

    private void displayQuantity() {
        TextView quantityTextView = (TextView)findViewById(R.id.quantity_text_view);
        quantityTextView.setText(String.valueOf(mQuantity));
    }

    private void displayTotalPrice() {
        TextView priceTextView = (TextView)findViewById(R.id.price_text_view);
        int total = mPrice * mQuantity;
        int startIndex = mNT$.length();
        int endIndex = mTotalPriceMessage.length();
        mTotalPriceMessage.delete(startIndex,endIndex).append(total)
                .append(mQuantity == 0 ? "\nFree" : "\nThank you!");
        priceTextView.setText(mTotalPriceMessage);
    }

    public void increment(View view) {
        // 從 TextView 取得目前數量，數量加 1 並顯示
        ++mQuantity;
        displayQuantity();
        resetTotolPrice();
    }

    public void decrement(View view) {
        // 從 TextView 取得目前數量，數量減 1 並顯示
        if(mQuantity > 0) {
            --mQuantity;
            displayQuantity();
            resetTotolPrice();
        }
    }

    private void resetTotolPrice() {
        TextView priceTextView = (TextView)findViewById(R.id.price_text_view);
        priceTextView.setText("");
    }

}
