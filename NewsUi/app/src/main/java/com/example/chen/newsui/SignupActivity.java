package com.example.chen.newsui;

/**
 * Created by Administrator on 2016/5/22.
 */
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignupActivity extends BaseActivity {
    private static final String TAG = "SignupActivity";

 private EditText _nameText;
 private EditText _emailText;
 private EditText _passwordText;
 private Button _signupButton;
 private TextView _loginLink;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        _nameText=(EditText) findViewById(R.id.input_name);
        _emailText=(EditText) findViewById(R.id.input_email);
        _passwordText=(EditText) findViewById(R.id.input_password);
        _signupButton=(Button) findViewById(R.id.btn_signup);
        _loginLink=(TextView) findViewById(R.id.link_login);
        _signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
            }
        });

        _loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Finish the registration screen and return to the Login activity
                finish();
            }
        });
    }

    public void signup() {
        Log.d(TAG, "Signup");

        if (!validate()) {
            onSignupFailed();
            return;
        }

        _signupButton.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(SignupActivity.this,
                R.style.AppTheme);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Creating Account...");
        progressDialog.show();

/*        String name = _nameText.getText().toString();
        private String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();*/

        // TODO: Implement your own signup logic here.

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onSignupSuccess or onSignupFailed
                        // depending on success
                        onSignupSuccess();
                        // onSignupFailed();
                        progressDialog.dismiss();
                    }
                }, 3000);
    }


    public void onSignupSuccess() {
        String name = _nameText.getText().toString();
        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();
        _signupButton.setEnabled(true);
        Intent intent=new Intent();
        intent.putExtra("email_c",email);
        intent.putExtra("password_c",password);
        setResult(RESULT_OK, intent);
        finish();
    }

    public void onSignupFailed() {
        Toast.makeText(getBaseContext(), "登录失败", Toast.LENGTH_LONG).show();

        _signupButton.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        String name = _nameText.getText().toString();
        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();

        if (name.isEmpty() || name.length() < 3) {
            _nameText.setError("至少三个字母或数字");
            valid = false;
        } else {
            _nameText.setError(null);
        }

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            _emailText.setError("邮箱地址错误");
            valid = false;
        } else {
            _emailText.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            _passwordText.setError("请输入4到10个字母或数字或字符");
            valid = false;
        } else {
            _passwordText.setError(null);
        }

        return valid;
    }
}
