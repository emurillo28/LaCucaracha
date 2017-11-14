package mx.edu.uabc.ernesto.lacucaracha;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SwipeRefreshLayout indicatorRefresh;
    ListView myList;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addFAB();

        indicatorRefresh = (SwipeRefreshLayout) findViewById(R.id.indicatorRefresh);
        myList = (ListView) findViewById(R.id.myList);

                 String[] numbers = getResources().getStringArray(R.array.numbers);
        myList.setAdapter(new ArrayAdapter(this,android.R.layout.simple_list_item_1,numbers));
        indicatorRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshingContent();
            }
        });
    }

    public void refreshingContent() {
        String numbers[] = getResources().getStringArray(R.array.numbers);
        myList.setAdapter(new ArrayAdapter(this,android.R.layout.simple_list_item_1,numbers));
        indicatorRefresh.setRefreshing(false);
    }

    public void addFAB() {
        FloatingActionButton myFAB = (FloatingActionButton) findViewById(R.id.fabMyFAB);
        myFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getBaseContext(),getResources().getString(R.string.message),Toast.LENGTH_SHORT).show();
                //Snackbar.make(view ,getResources().getString(R.string.message),Snackbar.LENGTH_SHORT).show();
                Snackbar.make(view ,getResources().getString(R.string.message),Snackbar.LENGTH_SHORT).setAction(getResources().getString(R.string.txt_action), new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        Log.i("SNACKBAR", "Click on Snackbar");
                    }
                }).show();
            }
        });
    }
}
