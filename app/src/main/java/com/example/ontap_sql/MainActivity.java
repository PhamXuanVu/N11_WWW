package com.example.ontap_sql;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menubar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.mnThem:
                Intent intent = new Intent(this,SanPhamActivity.class);
                startActivity(intent);
                return true;
            case R.id.mnTra:
                Intent intent1 = new Intent(this,SanPhamActivity2.class);
                startActivity(intent1);
                return true;
            case R.id.mnExit:
                finish();
                return true;
            default: return super.onOptionsItemSelected(item);

        }
    }
}