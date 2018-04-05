package weatherforecast.simpleapp.com.weatherforecast;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.widget.TextView;

import static weatherforecast.simpleapp.com.weatherforecast.R.id.humidity_field;
import static weatherforecast.simpleapp.com.weatherforecast.R.id.pressure_field;

public class MainActivity extends AppCompatActivity {

    TextView cityField;
    TextView detailsField;
    TextView currentTemperatureField;
    TextView humidityField;
    TextView pressureField;
    TextView updatedField;
    TextView weatherIcon;

    Typeface weatherFont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        weatherFont = Typeface.createFromAsset(getAssets(), "fonts/weathericons-regular-webfont.ttf");

        cityField = (TextView)findViewById(R.id.city_field);
        updatedField = (TextView)findViewById(R.id.updated_field);
        detailsField = (TextView)findViewById(R.id.details_field);
        currentTemperatureField = (TextView)findViewById(R.id.current_temperature_field);
        humidityField = (TextView)findViewById(humidity_field);
        pressureField = (TextView)findViewById(pressure_field);
        weatherIcon = (TextView)findViewById(R.id.weather_icon);
        weatherIcon.setTypeface(weatherFont);


        Function.placeIdTask asyncTask =new Function.placeIdTask(new Function.AsyncResponse() {
            public void processFinish(String weather_city,
                                      String weather_description,
                                      String weather_temperature,
                                      String weather_humidity,
                                      String weather_pressure,
                                      String weather_updatedOn,
                                      String weather_iconText,
                                      String sun_rise) {

                cityField.setText(weather_city);
                updatedField.setText(weather_updatedOn);
                detailsField.setText(weather_description);
                currentTemperatureField.setText(weather_temperature);
                humidityField.setText("Humidity: "+weather_humidity);
                pressureField.setText("Pressure: "+weather_pressure);
                weatherIcon.setText(Html.fromHtml(weather_iconText));

            }
        });
        asyncTask.execute("45.50884", "-73.58781"); //  asyncTask.execute("Latitude", "Longitude")



    }


}