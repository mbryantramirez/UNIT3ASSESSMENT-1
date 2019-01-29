package org.pursuit.unit_03_assessment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.pursuit.unit_03_assessment.R;
import org.pursuit.unit_03_assessment.model.PlanetResponse;
import org.pursuit.unit_03_assessment.network.PlanetService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RecyclerActivity extends AppCompatActivity {

    private final String TAG = "Prometheus Error";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        final PlanetService newPlanet = retrofit.create(PlanetService.class);
        Call<PlanetResponse> planets = newPlanet.getPlanets();
        planets.enqueue(new Callback<PlanetResponse>() {
            @Override
            public void onResponse(Call<PlanetResponse> call, Response<PlanetResponse> response) {
                Log.d(TAG,"OnResponse"+ response.body().getPlanets());
                /**
                 *  this is where you would have passed .getPlanets() into an adapter
                 */
            }

            @Override
            public void onFailure(Call<PlanetResponse> call, Throwable t) {
                /**
                 * You need to Log.e t.message instead of t.printStackTrace();
                 *
                 * this would have helped you catch your current error that the json response is currently null
                 */
                t.printStackTrace();
            }
        });
        /*
        * TODO: Add logic that will:
        * TODO 1. Make Retrofit instance for this endpoint: https://raw.githubusercontent.com/JDVila/storybook/master/planets.json
        * TODO 2. Make data model objects based on JSON
        * TODO 3. Make a service interface with method(s) to make a GET request
        * TODO 4. Make a request to the JSON endpoint using the Retrofit instance and the service
        * TODO 5. Subclass a RecyclerView Adapter
        * TODO 6. Subclass a RecyclerView ViewHolder
        * TODO 7. Pass list to RecyclerView
        * TODO 8. Display planet name in a RecyclerView tile
        * TODO 9. Implement an OnClickListener for the itemview
        * TODO 10. Pass the Planet Name, Number, and Image URL data to DisplayActivity when tile is clicked
        */

    }
}
