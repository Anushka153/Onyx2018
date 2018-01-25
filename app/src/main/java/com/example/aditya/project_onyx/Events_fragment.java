package com.example.aditya.project_onyx;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Anushka on 19-01-2018.
 */

public class Events_fragment extends Fragment{

    String event[]={"Game Of Thrones","Kavi Sammelan","Gangs of Wasseypur","How It Should Have Ended"
            ,"Mindspark","Shipwreck","evr","rerbe"};
    int content[]={R.string.got_content,R.string.poetry_content,R.string.gangs_content,R.string.how_it_content,
            R.string.mindspark_content, R.string.ship_content,R.string.content_1,R.string.content_2};
    String day[]={"1, 9th February","1, 9th February","1, 9th February","1, 9th February"
            ,"2, 10th February","2, 10th February","2, 10th February","2, 10th February"};
    String corName[]={"sknfisnfw","wefwefwerf","ergerger","ergerg","regerger","ergerg","ergerg","ergerg"};
    String corPhone[]={"31645626549","664465161","615849416303","516511849416","515151156","5165161513",
            "514653165136","25413161651"};
    //int posters[]={R.drawable.got,R.drawable.gangs,};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_events,null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

       ListView listView = (ListView)getView().findViewById(R.id.list_view);

        Events_fragment.CustomAdapter customAdapter = new Events_fragment.CustomAdapter();
        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getActivity(),DetailsActivity.class);
                Bundle bundle = ActivityOptionsCompat.makeSceneTransitionAnimation( getActivity(),
                        view.findViewById(R.id.cat),
                        ViewCompat.getTransitionName(view.findViewById(R.id.cat)).toString()).toBundle();
                intent.putExtra("title",event[position]);
                intent.putExtra("desc",content[position]);
                intent.putExtra("name", corName[position]);
                intent.putExtra("call", corPhone[position]);
                startActivity(intent,bundle);

            }
        });
    }

    class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return event.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView= getLayoutInflater().inflate(R.layout.item,null);
            ImageView imageView=convertView.findViewById(R.id.cat);
            TextView textView =  convertView.findViewById(R.id.a);
            //TextView textView1= convertView.findViewById(R.id.b);
            TextView textView2= convertView.findViewById(R.id.dayText);
            imageView.setImageResource(R.drawable.propic);
            textView.setText(event[position]);
            //textView1.setText(content[position]);
            textView2.setText("Day "+day[position]);
            return convertView;
        }

    }

}

