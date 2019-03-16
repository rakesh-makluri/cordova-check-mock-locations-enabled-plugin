package com.shubbak.plugins;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import 	android.provider.Settings;
import android.location.Location;
import android.location.LocationManager;

public class CheckMockLocationsEnabled extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        /*callbackContext.success(1);
        return true;*/

        if (action.equals("check")) {
            this.check(callbackContext);
            return true;
        }
        return false;

    }

    private void check(CallbackContext callbackContext) {
      try {
            Location location = new Location(LocationManager.GPS_PROVIDER);

        //   if (Settings.Secure.getString(this.cordova.getActivity().getContentResolver(), Settings.Secure.ALLOW_MOCK_LOCATION).equals("0")) {
        if(location.isFromMockProvider()) {
              callbackContext.success("From Mock Provider");
          } else {
              callbackContext.success("Not From Mock Provider");
          }
      } catch (Exception e) {
        callbackContext.error(e.getMessage());
      }
    }
}
