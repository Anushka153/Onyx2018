package com.example.aditya.project_onyx;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.security.Key;

public class DetailsActivity extends AppCompatActivity {
    String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        ImageView imageView=(ImageView)findViewById(R.id.image);
        TextView textView=(TextView)findViewById(R.id.ttle);
        TextView textView1=(TextView) findViewById(R.id.descr);
        ImageView corPic = (ImageView) findViewById(R.id.corPic);
        TextView corName = (TextView) findViewById(R.id.corName);
        TextView corCall = (TextView) findViewById(R.id.corCall);

        Bundle b=getIntent().getExtras();
        if(b==null)
            return;
        else {
            title = b.getString("title");
            textView.setText(title);
            textView1.setText(b.getInt("desc"));
            imageView.setImageResource(R.drawable.propic);
            corName.setText(b.getString("name"));
            corCall.setText(b.getString("call"));
        }
    }

    public void onButtonClick(View v)
    {
        if (v.getId()== R.id.register)
        {
            Intent i= new Intent(DetailsActivity.this,Register.class);
            i.putExtra("EventName",title);
            startActivity(i);
        }
    }
}
