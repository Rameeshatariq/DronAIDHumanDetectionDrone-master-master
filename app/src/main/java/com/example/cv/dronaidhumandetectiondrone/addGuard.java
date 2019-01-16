package com.example.cv.dronaidhumandetectiondrone;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class addGuard extends AppCompatActivity implements View.OnClickListener{
    private static int PICK_IMAGE = 100;
    private Uri mImageUri;
    ImageView imageView;

    private Button button;
    private EditText email;
    private EditText password;
    private EditText cnic;
    private EditText name;
    private EditText contactno;
    private Spinner employeetype;
    int currentItem = 0;

    private ProgressDialog progressDialog;

    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;
    private StorageReference mStorageRef;


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE && resultCode == RESULT_OK) {
            mImageUri = data.getData();
            imageView = (ImageView) findViewById(R.id.image);
            imageView.setImageURI(mImageUri);

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_guard);
        imageView = (ImageView) findViewById(R.id.image);
        imageView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent i = new Intent(
                        Intent.ACTION_PICK,
                        MediaStore.Images.Media.INTERNAL_CONTENT_URI);

                startActivityForResult(i, PICK_IMAGE);
            }
        });


        mStorageRef = FirebaseStorage.getInstance().getReference("adminprofile");

        firebaseAuth = FirebaseAuth.getInstance();

        databaseReference = FirebaseDatabase.getInstance().getReference("system/employee/guard");


        progressDialog = new ProgressDialog(this);

        button = (Button) findViewById(R.id.register);

        contactno = (EditText) findViewById(R.id.contact);

        cnic = (EditText) findViewById(R.id.cnic);

        name = (EditText) findViewById(R.id.name);

        employeetype = (Spinner) findViewById(R.id.spinner);


        button.setOnClickListener((View.OnClickListener) this);


        employeetype.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(currentItem==position){
                    return;
                }
                else{
                    Intent intent=new Intent(addGuard.this, systemmanager.class);
                    startActivity(intent);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void registerUser() {
        final String username = name.getText().toString().trim();
        final String cnicno = cnic.getText().toString().trim();
        final String type = employeetype.getSelectedItem().toString().trim();
        final String userphonenumber = contactno.getText().toString().trim();


        if (TextUtils.isEmpty(username)) {
            //password is empty
            Toast.makeText(this, "Please Enter User Name", Toast.LENGTH_LONG).show();
            //stopping the function execution further
            return;
        }

        if (TextUtils.isEmpty(cnicno)) {
            //password is empty
            Toast.makeText(this, "Please Enter Cnic", Toast.LENGTH_LONG).show();
            //stopping the function execution further
            return;
        }

        if (TextUtils.isEmpty(userphonenumber)) {
            //password is empty
            Toast.makeText(this, "Please Enter Contact Number", Toast.LENGTH_LONG).show();
            //stopping the function execution further
            return;
        } else {
            uploadFile();
        }


        progressDialog.setMessage("Registering User...");
        progressDialog.show();

    }

    private String getFileExtension(Uri uri) {
        ContentResolver cR = getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(cR.getType(uri));
    }


    private void uploadFile() {
        final String username = name.getText().toString().trim();
        final String cnicno = cnic.getText().toString().trim();
        final String type = employeetype.getSelectedItem().toString().trim();
        final String userphonenumber = contactno.getText().toString().trim();

        if (mImageUri != null) {
            StorageReference fileReference = mStorageRef.child(System.currentTimeMillis()
                    + "." + getFileExtension(mImageUri));

            fileReference.putFile(mImageUri)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                            Toast.makeText(addGuard.this, "Pic Upload", Toast.LENGTH_SHORT).show();

                            String id=databaseReference.push().getKey();
                            guardInfo userInfo = new guardInfo(type, username, cnicno, userphonenumber, taskSnapshot.getDownloadUrl().toString());
                            databaseReference.child(id).setValue(userInfo);


                            progressDialog.dismiss();

                            Toast.makeText(addGuard.this, "Guard Registered Successfully", Toast.LENGTH_SHORT).show();

                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(addGuard.this, e.getMessage(), Toast.LENGTH_LONG).show();


                        }
                    });
        } else {
            Toast.makeText(this, "No Image Selected", Toast.LENGTH_LONG).show();
        }
    }
    @Override
    public void onClick(View view) {
        if (view == button) {
            registerUser();
        }

    }
}