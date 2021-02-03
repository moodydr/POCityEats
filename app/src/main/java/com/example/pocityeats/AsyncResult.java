package com.example.pocityeats;

import org.json.JSONObject;

interface AsyncResult {
    void onResult(JSONObject object);
}
