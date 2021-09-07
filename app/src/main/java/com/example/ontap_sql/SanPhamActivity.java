package com.example.ontap_sql;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

public class SanPhamActivity extends AppCompatActivity {
    EditText et_id , et_name, et_donvi, et_gia;
    Button bt_reset , bt_save,bt_exit;
    DBHelper dbHelper = new DBHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_san_pham);

        et_id = findViewById(R.id.idt_id);
        et_name = findViewById(R.id.idt_ten);
        et_donvi = findViewById(R.id.idt_donvi);
        et_gia = findViewById(R.id.idt_gia);

        bt_save = findViewById(R.id.bt_save);
        bt_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SanPham sanPham = new SanPham();
                sanPham.setId(Integer.parseInt(et_id.getText().toString()));
                sanPham.setTen(et_name.getText().toString());
                sanPham.setDonVi(et_donvi.getText().toString());
                sanPham.setGia(Double.parseDouble(et_gia.getText().toString()));
                if (dbHelper.insertSanPham(sanPham) > 0)
                    Toast.makeText(getApplicationContext(), "Đã lưu thành công", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getApplicationContext(), "Lưu không thành công", Toast.LENGTH_LONG).show();
            }
        });

        bt_reset = findViewById(R.id.bt_reset);
        bt_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_id.setText("");
                et_name.setText("");
                et_donvi.setText("");
                et_gia.setText("");
            }
        });

        bt_exit = findViewById(R.id.bt_exit);
        bt_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SanPhamActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

}