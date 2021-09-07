package com.example.ontap_sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE SanPham("+"id interger primary key,"
                +"ten text,"
                +"donvi text,"
                +"gia double)");
    }
    public DBHelper(@Nullable Context context){
        super(context,"DB",null,1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS SanPham");
        onCreate(db);
    }
    public int insertSanPham( SanPham sanPham){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id",sanPham.getId());
        contentValues.put("ten",sanPham.getTen());
        contentValues.put("donvi",sanPham.getDonVi());
        contentValues.put("gia",sanPham.getGia());
        int result = (int) db.insert("SanPham",null,contentValues);
        db.close();
        return result;
    }
    public ArrayList<SanPham> getAllSanPham(){
        ArrayList<SanPham> sanPhams = new ArrayList<>();
        SQLiteDatabase db =this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from SanPham",null);
        if (cursor != null)
            cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            sanPhams.add(new SanPham(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getDouble(3)));
            cursor.moveToNext();
        }
        cursor.close();
        db.close();
        return sanPhams;
    }

    public ArrayList<SanPham> getIdSanPham(int id){
        ArrayList<SanPham> list = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from SanPham where id="+id,null);
        if(cursor != null)
            cursor.moveToFirst();
        SanPham sanPham = new SanPham(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getDouble(3));
        list.add(sanPham);
        cursor.close();
        db.close();
        return list;
    }
    public void updateSanPham(int id, String name){
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("ten",name);
        db.update("SanPham",contentValues,"id =?",new String[]{String.valueOf(id)});
        db.close();
    }
    public void deleteSanPham(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("SanPham", "id=?", new String[] { String.valueOf(id) });
        db.close();
    }
}
