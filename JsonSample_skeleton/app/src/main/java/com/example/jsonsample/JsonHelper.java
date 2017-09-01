package com.example.jsonsample;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonHelper {

    public static ArrayList<Item> parseJson(String strJson) {
        ArrayList<Item> list = new ArrayList<Item>();
        try {
            // TODO JSON解析
            JSONObject json = new JSONObject(strJson);
            JSONObject feed = json.getJSONObject("feed");
            JSONArray entries = feed.getJSONArray("entries");
            for (int i = 0; i < entries.length(); i++) {
                JSONObject entry = entries.getJSONObject(i);
                list.add(toItem(entry));
            }
        } catch (Exception e) {
            Log.e("JsonHelper", e.getMessage(), e);
        }

        return list;
    }

    public static Item toItem(JSONObject json) throws JSONException {
        Item item = new Item();
        // TODO JSON解析 entriesキーから取り出したJSONObjectをItemにパースする
        item.id = json.getString("id");
        JSONObject group = json.getJSONObject("group");
        item.title = group.getString("title");
        item.description = group.getString("description");
        item.thumbnailImageURL = group.getString("thumbnail_url");

        Log.v("JsonHelper", item.toString());
        return item;
    }
}
