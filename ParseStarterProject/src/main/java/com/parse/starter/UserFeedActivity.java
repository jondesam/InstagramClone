package com.parse.starter;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.parse.FindCallback;
import com.parse.GetDataCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;
import java.util.Objects;

public class UserFeedActivity extends AppCompatActivity {

    LinearLayout linLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_feed);

        Intent intent = getIntent();
        String username = intent.getStringExtra("username");

        setTitle(username + "'s Photos");

        linLayout = findViewById(R.id.linLayout);



        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Image");

        query.whereNotEqualTo("username", username );
        query.orderByDescending("createdAt");

        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> list, ParseException e) {
                if (e == null && list.size() > 0) {
                    for (ParseObject object :list)  {
                        ParseFile file = (ParseFile) object.get("image");

                        file.getDataInBackground(new GetDataCallback() {
                            @Override
                            public void done(byte[] bytes, ParseException e) {
                                if(e == null && bytes != null) {
                                    Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0,bytes.length );

                                    ImageView imageView = new ImageView((getApplicationContext()));

                                    imageView.setLayoutParams(new ViewGroup.LayoutParams(
                                            ViewGroup.LayoutParams.MATCH_PARENT,
                                            ViewGroup.LayoutParams.WRAP_CONTENT
                                    ));

                                    imageView.setImageBitmap(bitmap);
                                    linLayout.addView(imageView);
                                }
                            }
                        });
                    }
                }
            }
        });

        // move to top
//        LinearLayout linLayout = findViewById(R.id.linLayout);
//
        // moved to up
//        ImageView imageView = new ImageView((getApplicationContext()));
//
//        imageView.setLayoutParams(new ViewGroup.LayoutParams(
//                ViewGroup.LayoutParams.MATCH_PARENT,
//                ViewGroup.LayoutParams.WRAP_CONTENT
//        ));
//
//        imageView.setImageDrawable(getResources().getDrawable(R.drawable.instagram ));
//        linLayout.addView(imageView);
    }
}
