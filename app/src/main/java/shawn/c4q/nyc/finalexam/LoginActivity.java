package shawn.c4q.nyc.finalexam;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText userEditText;
    private EditText passEditText;
    private Button submitButton;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userEditText = (EditText) findViewById(R.id.edit_text_user);
        passEditText = (EditText) findViewById(R.id.edit_text_pass);
        submitButton = (Button) findViewById(R.id.submit_btn);
        initSubmit();
    }

    private void initSubmit(){
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isUserFilled()){
                    Toast.makeText(getApplicationContext(), "Username  required", Toast.LENGTH_SHORT).show();
                }else if(isPassFilled()){
                    Toast.makeText(getApplicationContext(), "Password required", Toast.LENGTH_SHORT).show();
                }else {
                    profileActivityBound();
                }

            }
        });
    }

    private boolean isPassFilled() {
        return passEditText.getText().toString().isEmpty();
    }

    private boolean isUserFilled(){
        return userEditText.getText().toString().isEmpty();
    }

    private void profileActivityBound(){
        intent = new Intent(getApplicationContext(), ProfileActivity.class);
        startActivity(intent);
        finish();
    }


}
