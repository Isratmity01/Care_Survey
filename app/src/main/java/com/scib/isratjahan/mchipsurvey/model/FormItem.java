package com.scib.isratjahan.mchipsurvey.model;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by israt.jahan on 3/6/2016.
 */
public class FormItem {
    private int id;
    private String qDetails;
    private boolean catActive;

    public FormItem(int id, String qDetails, boolean catActive) {
        this.id = id;
        this.qDetails = qDetails;
        this.catActive = catActive;
    }

    public FormItem(int id, String catName) {
        this.id = id;
        this.qDetails = qDetails;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getqDetails() {
        return qDetails;
    }

    public void setqDetails(String qDetails) {
        this.qDetails = qDetails;
    }

    public boolean isCatActive() {
        return catActive;
    }

    public void setCatActive(boolean catActive) {
        this.catActive = catActive;
    }

    @Override
    public String toString() {
        return "FormItem{" +
                "id=" + id +
                ", qDetails='" + qDetails + '\'' +
                ", catActive=" + catActive +
                '}';
    }

    public static FormItem parseFormItem(JSONObject jo) throws JSONException {
        int id = jo.getInt("category_id");
        String name = jo.getString("name");
        boolean isActive = jo.getBoolean("active");

        return new FormItem(id, name, isActive);
    }
}
