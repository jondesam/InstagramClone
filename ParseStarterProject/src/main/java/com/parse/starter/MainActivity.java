/*
 * Copyright (c) 2015-present, Parse, LLC.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.
 */
package com.parse.starter;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Switch;

import com.parse.GetCallback;
import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseAnalytics;
import com.parse.ParseAnonymousUtils;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;


public class MainActivity extends AppCompatActivity {


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    /*
    ParseObject score = new ParseObject("Score");
    score.put("username", "sean");
    score.put("score", 65);
    score.saveInBackground(new SaveCallback() {
      @Override
      public void done(ParseException e) {
        if (e == null){
          //ok

          Log.i("Success", "We saved the score");
        } else {
          e.printStackTrace();
        }
      }
    });


    ParseQuery<ParseObject> query = ParseQuery.getQuery("Score");

    query.getInBackground("zvxEE8XYBv", new GetCallback<ParseObject>() {
      @Override
      public void done(ParseObject parseObject, ParseException e) {
        if (e == null && parseObject != null) {

          parseObject.put("score", 85);
          parseObject.saveInBackground();


          Log.i("username", parseObject.getString("username"));
          Log.i("score", String.valueOf(parseObject.getInt("score")));

        }
      }
    });


    ParseObject tweet = new ParseObject("Tweet");
    tweet.put("username", "T-rex");
    tweet.put("tweet", "I'm T-rex");
    tweet.saveInBackground(new SaveCallback() {
      @Override
      public void done(ParseException e) {
        if (e == null){
          Log.i("Success","We saved the tweet" );
        } else {
          e.printStackTrace();
        }
      }
    });
    */

    ParseQuery<ParseObject> query = ParseQuery.getQuery("Tweet");

    query.getInBackground("YHdQ5KPHXL", new GetCallback<ParseObject>() {
      @Override
      public void done(ParseObject parseObject, ParseException e) {
        if (e == null && parseObject != null){

          parseObject.put("tweet", "I'm doing well");
          parseObject.saveInBackground();

          Log.i("username", parseObject.getString("username"));
          Log.i("tweet", parseObject.getString("tweet"));


        }
      }
    });






    ParseAnalytics.trackAppOpenedInBackground(getIntent());
  }

}