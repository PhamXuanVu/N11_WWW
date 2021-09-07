package com.example.ontap_sql;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class SanPhamActivity2 extends AppCompatActivity {
    EditText et_id , et_ten;
    Button bt_delete , bt_select , bt_update , bt_exit;
    DBHelper dbHelper = new DBHelper(this);
    GridView gv_display;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_san_pham2);

        et_id = findViewById(R.id.idt_id);
        et_ten = findViewById(R.id.idt_ten);
        gv_display = findViewById(R.id.gv_display);

        bt_select = findViewById(R.id.bt_select);
        bt_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<SanPham> sanPhams = null;
                ArrayList<String> strings = new ArrayList<>();

                if (et_id.getText().toString().equals(""))
                    sanPhams = dbHelper.getAllSanPham();
                else
                    sanPhams = dbHelper.getIdSanPham(Integer.parseInt(et_id.getText().toString()));

                for (SanPham sanPham : sanPhams) {
                    strings.add(sanPham.getId() + "");
                    strings.add(sanPham.getTen());
                    strings.add(sanPham.getDonVi());
                    strings.add(sanPham.getGia() + "");
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<>(SanPhamActivity2.this, android.R.layout.simple_list_item_1, strings);
                gv_display.setAdapter(adapter);
            }
        });

        bt_delete = findViewById(R.id.bt_delete);
        bt_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.deleteSanPham(Integer.parseInt(et_id.getText().toString()));
                Toast.makeText(getApplicationContext(), "Xóa thành công", Toast.LENGTH_LONG).show();
            }
        });

        bt_update = findViewById(R.id.bt_update);
        bt_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.updateSanPham(Integer.parseInt(et_id.getText().toString()),et_ten.getText().toString());
                Toast.makeText(getApplicationContext(), "Cập nhật thành công", Toast.LENGTH_LONG).show();
            }
        });

        bt_exit = findViewById(R.id.bt_exit);
        bt_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SanPhamActivity2.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}