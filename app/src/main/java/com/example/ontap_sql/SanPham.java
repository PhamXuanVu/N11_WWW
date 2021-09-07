package com.example.ontap_sql;

public class SanPham {
    private int id;
    private String ten;
    private String donVi;
    private Double gia;

    public SanPham(int id, String ten, String donVi, Double gia) {
        this.id = id;
        this.ten = ten;
        this.donVi = donVi;
        this.gia = gia;
    }

    public SanPham() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDonVi() {
        return donVi;
    }

    public void setDonVi(String donVi) {
        this.donVi = donVi;
    }

    public Double getGia() {
        return gia;
    }

    public void setGia(Double gia) {
        this.gia = gia;
    }

    @Override
    public String toString() {
        return "SanPham{" +
                "id=" + id +
                ", ten='" + ten + '\'' +
                ", donVi='" + donVi + '\'' +
                ", gia=" + gia +
                '}';
    }
}
