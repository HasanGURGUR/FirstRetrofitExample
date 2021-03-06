package com.hasangurgur.firstretrofitexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


RecyclerView recyclerView;
AnimeAdapter adapter;
LinearLayoutManager layoutManager;
List<AnimeModel> animelists = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rec1);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter= new AnimeAdapter(animelists, new MyClickListener() {
            @Override
            public void onItemClick(AnimeModel animeModel) {
              Toast.makeText(MainActivity.this, "" +animeModel.getAnimeName() +
                       "\n\n"+ animeModel.getCharName() +"\n\n"+
                        animeModel.getQuoteName(), Toast.LENGTH_SHORT).show();




            }
        });
        recyclerView.setAdapter(adapter);

        fetcAnime();


    }
private void fetcAnime(){

        ApiClient.getRetrofitClient().getAnime().enqueue(new Callback<List<AnimeModel>>() {
            @Override
            public void onResponse(Call<List<AnimeModel>> call, Response<List<AnimeModel>> response) {
                if (response.isSuccessful() && response.body() !=null){

                    animelists.addAll(response.body());
                    adapter.notifyDataSetChanged();
                    
                }
            }

            @Override
            public void onFailure(Call<List<AnimeModel>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error:"+t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
}

}