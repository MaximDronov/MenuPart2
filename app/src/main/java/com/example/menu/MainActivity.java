package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.media.RouteListingPreference;
import android.view.View;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);

        if(menu.getClass().getSimpleName()
                .equals("MenuBuilder")){
            try{
                Method m = menu.getClass()
                        .getDeclaredMethod (
                                "setOptionalIconsVisible",
                                Boolean.TYPE);
                m.setAccessible(true);
                m.invoke(menu, true);
            }
            catch(NoSuchMethodException e){
                System.err.println("onCreateOptionsMenu");
            }
            catch(Exception e){
                throw new RuntimeException(e);
            }
        }
        return true;
    }

    public void onHelpClick(MenuItem item)
    {
        Toast.makeText(getApplicationContext(),
                "Help clicked", Toast.LENGTH_LONG).show();
    }
    public boolean onOptionsItemSelected(MenuItem item)
    {
        String msg = "";

        if (item.getItemId() == R.id.CART) {
            msg = "Cart clicked";
        } else if (item.getItemId() == R.id.callPhone) {
            msg = "Call clicked";
        } else if (item.getItemId() == R.id.card) {
            item.setChecked(true);
            msg = "Camera clicked";
        } else if (item.getItemId() == R.id.video) {
            item.setChecked(true);
            msg = "Video clicked";
        } else if (item.getItemId() == R.id.EMAIL) {
            msg = "Email clicked";
        } else if (item.getItemId() == R.id.ADD) {
            msg = "Add clicked";
        } else if (item.getItemId() == R.id.COPY) {
            msg = "Copy clicked";
        } else if (item.getItemId() == R.id.PASTE) {
            msg = "Paste clicked";
        } else {
            return super.onOptionsItemSelected(item);
        }
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
        return true;
    }
}
