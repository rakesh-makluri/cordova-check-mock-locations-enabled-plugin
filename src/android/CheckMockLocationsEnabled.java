package com.shubbak.plugins;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import 	android.provider.Settings;
import 	android.os.Bundle;

import android.location.Location;
import android.location.LocationManager;
import android.location.LocationListener;

public class CheckMockLocationsEnabled extends CordovaPlugin implements LocationListener {

    private boolean mockLocationEnabled;
    protected LocationManager locationManager;
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        /*callbackContext.success(1);
        return true;*/

        //if (action.equals("check")) {
            // this.check(callbackContext);
            // return true;
        //}
        //return false;
        // if(this.mockLocationEnabled) {
        //     callbackContext.success("From Mock Provider");
        // } else {
        //     callbackContext.success("Real Location");
        // }

        this.check(callbackContext);

        return true;
    }

    @Override
    public void onLocationChanged(Location location) {
        this.mockLocationEnabled = location.isFromMockProvider();
    }

    @Override
    public void onProviderDisabled(String location) {
    }

    @Override
    public void onProviderEnabled(String location) {
    }

     @Override
     public void onStatusChanged(String location, int status, Bundle extras) {
     }

    private void check(CallbackContext callbackContext) {
    //   try {
    //         this.locationManager = (LocationManager) callbackContext.getSystemService(LOCATION_SERVICE);

    //         boolean isGPSEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);

    //         Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);


    //     //   if (Settings.Secure.getString(this.cordova.getActivity().getContentResolver(), Settings.Secure.ALLOW_MOCK_LOCATION).equals("0")) {
    //     if(location.isFromMockProvider()) {
    //           callbackContext.success("From Mock Provider");
    //       } else {
    //           callbackContext.success("Not From Mock Provider");
    //       }
    //   } catch (Exception e) {
    //     callbackContext.error(e.getMessage());
    //   }
        try {
            if(this.mockLocationEnabled) {
                callbackContext.success("From Mock Provider");
            } else {
                callbackContext.success("Real Location");
            }
        } catch(Exception e) {
            callbackContext.error(e.getMessage());
        }
    }
}