package com.example.chen.newsui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/5/20.
 */
public class LoginActivity extends BaseActivity{
    private static final String TAG="LoginActivity";
    private static final int REQUEST_SIGNUP=0;
    private EditText _emailText;
    private EditText _passwordText;
    private Button _loginButton;
    private TextView _signupLink;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        _emailText=(EditText) findViewById(R.id.input_email);
        _passwordText=(EditText) findViewById(R.id.input_password);
        _loginButton=(Button) findViewById(R.id.btn_login);
        _signupLink=(TextView) findViewById(R.id.link_signup);
        _loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                login();
            }
        });

        _signupLink.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Start the Signup activity
                Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
                startActivityForResult(intent, REQUEST_SIGNUP);
            }
        });
    }
public void login(){
    Log.d(TAG,"Login");
    if (!validate()){
        onLoginFailed();
        return;
    }
    _loginButton.setEnabled(false);
    final ProgressDialog progressDialog=new ProgressDialog(LoginActivity.this,R.style.AppTheme);
    progressDialog.setIndeterminate(true);
    progressDialog.setMessage("认证中...");
    progressDialog.show();
    String email = _emailText.getText().toString();
    String password = _passwordText.getText().toString();
    new android.os.Handler().postDelayed(
            new Runnable() {
                public void run() {
                    // On complete call either onLoginSuccess or onLoginFailed
                    onLoginSuccess();
                    // onLoginFailed();
                    progressDialog.dismiss();
                }
            }, 3000);
}
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==REQUEST_SIGNUP){
            if (resultCode==RESULT_OK){
                String email1=data.getStringExtra("email_c");
                String password1=data.getStringExtra("password_c");
                _emailText.setText(email1);
                _passwordText.setText(password1);
                //this.finish();
            }
        }
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }

    public void onLoginSuccess(){
        _loginButton.setEnabled(true);
        Intent intent=new Intent(LoginActivity.this,MainActivity.class);
        startActivity(intent);
    }
    public void onLoginFailed(){
        Toast.makeText(getBaseContext(),"登录失败",Toast.LENGTH_LONG).show();
        _loginButton.setEnabled(true);
    }
    public boolean validate(){
        boolean valid=true;
        String email=_emailText.getText().toString();
        String password=_passwordText.getText().toString();
        if(email.isEmpty()||!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            _emailText.setError("邮箱地址错误");
            valid=false;
        }else{
            _emailText.setError(null);
        }
        if (password.isEmpty()||password.length()<4||password.length()>10){
            _passwordText.setError("请输入4到10个字母或数字或字符");
            valid=false;
        }else{
            _passwordText.setError(null);
        }
        return valid;
    }
}

