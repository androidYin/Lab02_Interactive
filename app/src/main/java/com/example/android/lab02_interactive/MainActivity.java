package com.example.android.lab02_interactive;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int mQuantity = 0;
    private int mPrice = 50;
    private String mName = "鳴人";
    private StringBuilder mPriceMessage = new StringBuilder("NT$" + mPrice);
    private StringBuilder mQuantityMessage = new StringBuilder(mQuantity);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayPriceMessage(); // 顯示初始的訊息
    }

    private void displayQuantityMessage() {
        TextView quantityTextView =
                (TextView) findViewById(R.id.quantity_text_view);
        // 將數量字串刪除，替換成新的數量值
        int start = 0;
        int end = mQuantityMessage.length();
        mQuantityMessage.delete(start, end).append(mQuantity);
        quantityTextView.setText(mQuantityMessage);
    }

    // 按下 + - button
    public void increment(View view) {
        ++mQuantity;
        displayQuantityMessage();
        resetPriceMessageString(); // 數量改變，重設價格訊息字串
        displayPriceMessage(); // 重新顯示價格訊息
    }

    public void decrement(View view) {
        if (mQuantity == 0) {
            return;
        }
        --mQuantity;
        displayQuantityMessage();
        resetPriceMessageString(); // 數量改變，重設價格訊息字串
        displayPriceMessage(); // 重新顯示價格訊息
    }

    private void displayPriceMessage() {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(mPriceMessage);
    }

    // 按下 ORDER Button
    public void submitOrder(View view) {
        clearPriceMessageString(); // 刪除 mPriceMessage
        concatPriceMessageString(); // 字串組合 人名 + 臭豆腐 + 是否加泡菜 + Free 或 NT$xxx Thank you!
        displayPriceMessage(); // 重新顯示 mPriceMessage
    }

    private void clearPriceMessageString() {
        int start = 0;
        int end = mPriceMessage.length();
        mPriceMessage.delete(start, end);
    }

    private void concatPriceMessageString() {
        CheckBox checkBox = (CheckBox) findViewById(R.id.toppings_checkbox);
        mPriceMessage.append("Name: ")
                .append(mName)
                .append("\n")
                .append("臭豆腐")
                .append("\n")
                .append("加泡菜 ? ")
                .append(checkBox.isChecked())
                .append("\n");
        if(mQuantity == 0) {
            mPriceMessage.append("Free");
        } else {
            mPriceMessage.append("Quantity: ")
                    .append(mQuantity)
                    .append("\n")
                    .append("Total: ")
                    .append("NT$")
                    .append(mPrice * mQuantity)
                    .append("\n")
                    .append("Thank you!")
                    .append("\n");
        }
    }

    public void clickToppings(View view) {
        resetPriceMessageString();
        displayPriceMessage();
    }

    private void resetPriceMessageString() {
        clearPriceMessageString();
        mPriceMessage.append("臭豆腐")
                .append("NT$").append(mPrice);
    }
}
