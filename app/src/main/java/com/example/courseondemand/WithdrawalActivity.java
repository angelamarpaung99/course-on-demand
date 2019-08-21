package com.example.courseondemand;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import static android.support.constraint.Constraints.TAG;

public class WithdrawalActivity extends AppCompatActivity implements View.OnClickListener {
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    private String uid = firebaseAuth.getCurrentUser().getUid();
    private DocumentReference userRef = db.collection("users").document(uid);
    private EditText txtBank, txtAcc, txtAmount;
    private Button btnWithdraw;
    private Long currBalance;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_withdrawal);

        txtBank = findViewById(R.id.txtBank);
        txtAcc = findViewById(R.id.txtAcc);
        txtAmount = findViewById(R.id.txtAmount);
        btnWithdraw = findViewById(R.id.btnWithdraw1);

        getBalance();

        btnWithdraw.setOnClickListener(this);

    }

    private void getBalance() {
        userRef.get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if (documentSnapshot.exists()){
                             currBalance = documentSnapshot.getLong("balance");
                        } else {
                            Toast.makeText(getApplicationContext(), "Document does not exist", Toast.LENGTH_SHORT).show();
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(), "Error! ", Toast.LENGTH_SHORT).show();
                        Log.d(TAG, e.toString());
                    }
                });
    }

    @Override
    public void onClick(View view) {
        if (view == btnWithdraw){
            userWithdraw();
        }
    }

    private void userWithdraw() {
        String bank = txtBank.getText().toString().trim();
        String acc = txtAcc.getText().toString().trim();
        String amount = txtAmount.getText().toString().trim();
        Long withdrawAmount = Long.parseLong(amount);

        if (bank.isEmpty()){
            txtBank.setError("Bank name is required");
            txtBank.requestFocus();
            return;
        }
        if (acc.isEmpty()){
            txtAcc.setError("Account number is required");
            txtAcc.requestFocus();
            return;
        }
        if (((String) amount).isEmpty()){
            txtAmount.setError("Account number is required");
            txtAmount.requestFocus();
            return;
        }
        if (withdrawAmount> currBalance){
            txtAmount.setError("Withdrawal amount is bigger than current balance!");
            txtAmount.requestFocus();
            return;
        }
        Long newBalance = currBalance - withdrawAmount;
        userRef.update("balance", newBalance);
        Intent intent = new Intent(WithdrawalActivity.this, HomeNotActive.class);
        startActivity(intent);
    }
}
