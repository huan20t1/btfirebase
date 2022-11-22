package com.example.btfirebase1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {
    private EditText txtname,txttenthuongoi,txttenkhoahoc, txtmaula, txtid;
    Button btpush;
    private RecyclerView rcvUsers;
    private AdapterRcv adapter;
    private List<User> mListUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        getSupportActionBar().hide();

        initKey();

        btpush.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = Integer.parseInt(txtid.getText().toString().trim());
                String tenthuongoi = txttenthuongoi.getText().toString().trim();
                String tenkhoahoc = txttenkhoahoc.getText().toString().trim();
                String maula = txtmaula.getText().toString().trim();
                String dactinh = txtname.getText().toString().trim();
                User user = new User(id, tenthuongoi, tenkhoahoc, maula, dactinh);
                onClickPushData(user);
            }
        });
        getList();
    }
    private void initKey(){
        txtname = findViewById(R.id.edtdactinh);
        txtmaula = findViewById(R.id.edtmaula);
        txttenkhoahoc = findViewById(R.id.edttenkh);
        txttenthuongoi = findViewById(R.id.edttenbt);
        txtid = findViewById(R.id.edtid);
        btpush = findViewById(R.id.btnadd);

        rcvUsers = findViewById(R.id.rcvlist);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvUsers.setLayoutManager(linearLayoutManager);
        mListUser = new ArrayList<>();
        adapter  = new AdapterRcv(mListUser);
        rcvUsers.setAdapter(adapter);
    }

    private void onClickPushData(User user){
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Tree");

        String pathObject = String.valueOf(user.getId());
        myRef.child(pathObject).setValue(user, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                Toast.makeText(ListActivity.this,"Success", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getList(){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Tree");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                    User tree = dataSnapshot.getValue(User.class);
                    mListUser.add(tree);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Toast.makeText(ListActivity.this,"Fail",Toast.LENGTH_SHORT).show();
            }
        });
    }
}