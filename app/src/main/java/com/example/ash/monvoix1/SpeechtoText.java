package com.example.ash.monvoix1;


        import java.util.ArrayList;
        import java.util.Locale;

        import android.annotation.SuppressLint;
        import android.app.Activity;
        import android.content.ActivityNotFoundException;
        import android.content.Intent;
        import android.os.Bundle;
        import android.speech.RecognizerIntent;
        import android.support.design.widget.FloatingActionButton;
        import android.view.Menu;
        import android.view.View;
        import android.widget.ImageButton;
        import android.widget.TextView;
        import android.widget.Toast;

        import static com.example.ash.monvoix1.R.id.fab;

public class SpeechtoText extends Activity {


        private TextView txtSpeechInput;
        private ImageButton btnSpeak;
        private final int REQ_CODE_SPEECH_INPUT = 100;

@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speechto_text);
        txtSpeechInput = (TextView) findViewById(R.id.txtSpeechInput);
        btnSpeak = (ImageButton) findViewById(R.id.btnSpeak);
    ImageButton fab = (ImageButton) findViewById(R.id.fab);

    final String theText = txtSpeechInput.getText().toString();
    fab.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //here
            Intent i= new Intent(SpeechtoText.this,Sending.class);
            i.putExtra("text_label", theText);
            startActivity(i);
        }
    });
        btnSpeak.setOnClickListener(new View.OnClickListener() {

@Override
public void onClick(View v) {
        promptSpeechInput();
        }
        });
        }

        private void promptSpeechInput() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
        RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
        getString(R.string.speech_prompt));
        try {
        startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
        } catch (ActivityNotFoundException a) {
        Toast.makeText(getApplicationContext(),
        getString(R.string.speech_not_supported),
        Toast.LENGTH_SHORT).show();
        }


        }

/**
 * Receiving speech input
 */
@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
        case REQ_CODE_SPEECH_INPUT: {
        if (resultCode == RESULT_OK&&null != data) {

        ArrayList<String> result = data
        .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
        txtSpeechInput.setText(result.get(0));
        }
        break;
        }

        }
        }

@Override
public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.

        return true;
        }
        }
