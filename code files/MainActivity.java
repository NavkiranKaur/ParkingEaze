//parkingEazeTeam
package eaze.parking;
import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    EditText mTextUsername;
    EditText mTextPassword;
    Button mButtonLogin;
    Button mButtonRegister;
    private FirebaseAuth mAuth;
    private static final int REQUEST_CODE_ASK_PERMISSIONS = 300;
    LocationManager locationManager;
    Criteria criteria;
    private static final int REQUEST_LOCATION = 2;
    protected void onCreate(Bundle savedInstanceState) {
        //setTheme(R.style.AppTheme_NoActionBar);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        findAllViewsfromLayout();
        handleLogin();

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        // Creating an empty criteria object
        criteria = new Criteria();

// Get the location from the given provider
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) ==
                PackageManager.PERMISSION_GRANTED
                || ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) ==
                PackageManager.PERMISSION_GRANTED) {
            onResume();
        } else {

// request permission from the user
            // Check Permissions Now

            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {

            }

            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    REQUEST_LOCATION);

        }
    }


    private void findAllViewsfromLayout() {
        mTextUsername = (EditText) findViewById(R.id.edittext_username);
        mTextPassword = (EditText) findViewById(R.id.edittext_password);
        mButtonLogin = (Button) findViewById(R.id.button_login);
        mButtonRegister = (Button) findViewById(R.id.button_register);
        mButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createNewUser();
            }
        });
    }




    private void handleLogin(){
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser(String.valueOf(mTextUsername.getText()), String.valueOf(mTextPassword.getText()));
            }
        });





        /*signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignoutfromDatabase();
            }
        });*/
    }


    private void loginUser(String email, String password){


        if(email.length()==0 || password.length()==0)
        {
            Toast.makeText(getApplicationContext(), "Email & Password Can't be empty",
                    Toast.LENGTH_LONG).show();
            return;
        }
        // TODO: Login with Email and Password on Firebase.
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            // Log.d("MapleLeaf", "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            /*message.setText("User "+ user.getEmail() + " is now Logged In");
                            setButtonStatus(true);
                            gotoRead();*/
                            gotoMainReadingsPage();

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("MapleLeaf", "signInWithEmail:failure", task.getException());
                            Toast.makeText(getApplicationContext(), "Success.",
                                    Toast.LENGTH_LONG).show();
                            Intent intent1 = new Intent(getApplicationContext(), selectLocation.class);
                            startActivity(intent1);
                            finish();
                        }

                        // ...
                    }
                });


    }
    private void createNewUser(){
        Intent register = new Intent(getApplicationContext(), Register.class);
        startActivity(register);
        finish();

    }

    private void gotoMainReadingsPage() {
        // TODO : Start the read option After login
        Intent intent1 = new Intent(getApplicationContext(), AfterLoginScreen.class);
        startActivity(intent1);
        finish();
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE_ASK_PERMISSIONS:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
// Permission Granted
                    onResume();
                } else {
// Permission Denied
                    finish();

                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Closing Activity")
                .setMessage("Are you sure you want to close this activity?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                        System.exit(0);
                    }

                })
                .setNegativeButton("No", null)
                .show();
    }



}