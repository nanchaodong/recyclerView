package com.wolf.recyclerview.utils;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * Created by nanchaodong on 2017/3/20.
 */

public class HttpParams {
    private String country;
    private int catId;
    private int startIndex;
    private int pageSize;
    private String platform;
    private String device_token;
    private String version;
    private String offset;
    private Map<String, Object> map;
    private Map<String, RequestBody> bodyMap;
    private Map<String, RequestBody> otherMap;
    private static final MediaType text_type = MediaType.parse("text/plain");
    private static final MediaType image_type = MediaType.parse("multipart/form-data");


    public HttpParams() {
        map = new HashMap<String, Object>();
        bodyMap = new HashMap<String, RequestBody>();
        otherMap = new HashMap<String, RequestBody>();
    }

    public void setPlatform(String platform) {
        this.platform = platform;
        map.put("platform", platform);
        otherMap.put("platform", convertToRequestBody(platform));

    }

    public void setDevice_token(String device_token) {
        this.device_token = device_token;
        map.put("device_token", device_token);
        otherMap.put("device_token", convertToRequestBody(device_token));


    }

    public void setVersion(String version) {
        this.version = version;
        map.put("version", version);
        otherMap.put("version", convertToRequestBody(version));

    }

    public void setOffset(String offset) {
        this.offset = offset;
        map.put("offset", offset);
        otherMap.put("offset", convertToRequestBody(offset));

    }

    public void setCountry(String country) {
        this.country = country;
        map.put("country", country);
    }

    public void setCatId(int catId) {
        this.catId = catId;
        map.put("catId", catId);
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
        map.put("startIndex", startIndex);
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
        map.put("pageSize", pageSize);
    }

    public Map<String, RequestBody> getBodyMap() {
        Gson gson = new Gson();
        bodyMap.put("jsonParams", RequestBody.create(MediaType.parse("text/plain"), gson.toJson(map)));
        return bodyMap;
    }

    public RequestBody convertToRequestBody(String value) {
        return RequestBody.create(text_type, value);
    }
    public Map<String, RequestBody> getOtherMap(){
        return otherMap;
    }

}
