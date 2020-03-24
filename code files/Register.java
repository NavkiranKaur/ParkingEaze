//parkingEazeTeam
package eaze.parking;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.regex.Pattern;

public class Register extends AppCompatActivity {

    EditText mTextUsername;
    EditText mTextPassword;
    EditText mTextCnfPassword;
    Button mButtonRegister;
    Button mButtonLogin;

    private FirebaseAuth mAuth;
    private TextView message;
    private EditText email;
    private EditText password1;
    private EditText password2;
    private Button register1;

    private final Pattern hasUppercase = Pattern.compile("[A-Z]");
    private final Pattern hasLowercase = Pattern.compile("[a-z]");
    private final Pattern hasNumber = Pattern.compile("\\d");
    private final Pattern hasSpecialChar = Pattern.compile("[^a-zA-Z0-9 ]");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //setTheme(R.style.AppTheme_NoActionBar);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        findAllViewsfromLayout();
        mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Login = new Intent(Register.this,MainActivity.class);
                startActivity(Login);
            }
        });
        register1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startRegisteration();
            }
        });
    }
    private void findAllViewsfromLayout()
    {
        mButtonLogin = findViewById(R.id.button_login_2);
        register1 = findViewById(R.id.button_register_2);
        email = findViewById(R.id.edittext_username_2);
        password1 = findViewById(R.id.edittext_password_2);
        password2 = findViewById(R.id.edittext_cnf_password_2);
    }
    private void startRegisteration() {
        // TODO: Create new users on Firebase.
        String registerEmail = String.valueOf(email.getText());
        String registerPassword1 = String.valueOf(password1.getText());
        String registerPassword2 = String.valueOf(password2.getText());

        if (registerEmail.length() == 0 || password1.length() == 0 || password2.length() == 0){
            Toast.makeText(getApplicationContext(), "The email and/or password cannot be empty",
                    Toast.LENGTH_LONG).show();
            return; // do nothing if empty.
        }
        else if (!registerPassword1.equals(registerPassword2))
        {
            Toast.makeText(getApplicationContext(), "The password does't match, cannot continue",
                    Toast.LENGTH_LONG).show();
        }

        if( password1.length()<=6 || password1.length()>=12 || password2.length()<=6 || password2.length()>=12  )
        {
            Toast.makeText(getApplicationContext(), "The password length should be between 6 to 12 characters",
                    Toast.LENGTH_LONG).show();
            return;
        }
        if( !hasUppercase.matcher(registerPassword1).find() )
        {
            Toast.makeText(getApplicationContext(), "The password must contain uppercase alphabet",
                    Toast.LENGTH_LONG).show();
            return;
        }

        if( !hasLowercase.matcher(registerPassword1).find() )
        {
            Toast.makeText(getApplicationContext(), "The password must contain a lowercase alphabet",
                    Toast.LENGTH_LONG).show();
            return;
        }



        if( !hasNumber.matcher(registerPassword1).find() )
        {
            Toast.makeText(getApplicationContext(), "The password must contain a number",
                    Toast.LENGTH_LONG).show();
            return;
        }

        if( !hasSpecialChar.matcher(registerPassword1).find() )
        {
            Toast.makeText(getApplicationContext(), "The password must contain a Special Character",
                    Toast.LENGTH_LONG).show();
            return;
        }

        mAuth = FirebaseAuth.getInstance();
        mAuth.createUserWithEmailAndPassword(registerEmail, registerPassword1)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("MapleLeaf", "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            //  message.setText("New user "+ user.getEmail() + " is now registered");
                            finish();
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("MapleLeaf", "createUserWithEmail:failure", task.getException());
                            Toast.makeText(getApplicationContext(), "Create new user failed.",
                                    Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
}