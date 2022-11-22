package com.example.btfirebase1;

import java.util.HashMap;
import java.util.Map;

public class User {
    private int id;
    private String tenkhoahoc;
    private String tenthuonggoi;
    private String maula;
    private String dactinh;

    public User(){
    }

    public User(Integer id, String tenkhoahoc, String tenthuonggoi, String maula, String dactinh) {
        this.id = id;
        this.tenkhoahoc = tenkhoahoc;
        this.tenthuonggoi = tenthuonggoi;
        this.maula = maula;
        this.dactinh = dactinh;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenkhoahoc() {
        return tenkhoahoc;
    }

    public void setTenkhoahoc(String tenkhoahoc) {
        this.tenkhoahoc = tenkhoahoc;
    }

    public String getTenthuonggoi() {
        return tenthuonggoi;
    }

    public void setTenthuonggoi(String tenthuonggoi) {
        this.tenthuonggoi = tenthuonggoi;
    }

    public String getMaula() {
        return maula;
    }

    public void setMaula(String maula) {
        this.maula = maula;
    }

    public String getDactinh() {
        return dactinh;
    }

    public void setDactinh(String dactinh) {
        this.dactinh = dactinh;
    }

    public Map<String, Object> toMap(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("tenkhoahoc",tenkhoahoc);
        result.put("tenthuonggoi",tenthuonggoi);
        result.put("maula",maula);
        result.put("dactinh",dactinh);

        return result;
    }
}
