package calculator.calulation.lesson4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textViewLable = findViewById(R.id.textViewLable);
        TextView textView = findViewById(R.id.textView);
        textViewLable.setText(getString(R.string.textLanguageLable_java));
        textView.setText(getString(R.string.textLanguage_java));

        Typeface tf = Typeface.createFromAsset(getAssets(),"fonts/19659.ttf");
        textView.setTypeface(tf);
        textViewLable.setTypeface(tf);

        AppCompatImageView appCompatImageView = findViewById(R.id.imageView);
        try {
            InputStream inputStream = getAssets().open("android.png");
            Drawable d = Drawable.createFromStream(inputStream,"android.png");
            appCompatImageView.setBackgroundDrawable(d);
        }catch (IOException e){

        }


        LinearLayout linearLayout = findViewById(R.id.linearLayout);

        String[] version = getResources().getStringArray(R.array.version_names);
        TypedArray typedArray = getResources().obtainTypedArray(R.array.version_icons);
        for(int i=0;i<typedArray.length();i++){
            View view = getLayoutInflater().inflate(R.layout.item,linearLayout,false);
            TextView textViewVersionName = view.findViewById(R.id.textViewVersionName);
            textViewVersionName.setText(version[i]);

            AppCompatImageView imageViewVersion  =view.findViewById(R.id.imageViewVersion);
            imageViewVersion.setImageResource(typedArray.getResourceId(i,0));
            linearLayout.addView(view);
        }
    }
}