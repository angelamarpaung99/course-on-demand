package com.example.courseondemand;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import static android.support.constraint.Constraints.TAG;

public class BalanceFragment extends Fragment implements View.OnClickListener {
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    private String uid = firebaseAuth.getCurrentUser().getUid();
    private DocumentReference userRef = db.collection("users").document(uid);
    private static final String KEY_BALANCE = "balance";
    private TextView tvBalance;
    private Button btnWithdraw;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_balance, null);
        ((HomeNotActive) getActivity()).getSupportActionBar().show();

        tvBalance = v.findViewById(R.id.tvBalance);
        btnWithdraw = v.findViewById(R.id.btnWithdraw);

        getBalance();

        btnWithdraw.setOnClickListener(this);

        return v;
    }

   private void getBalance(){
      userRef.get()
              .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                  @Override
                  public void onSuccess(DocumentSnapshot documentSnapshot) {
                    if (documentSnapshot.exists()){
                        String balance = documentSnapshot.getLong(KEY_BALANCE).toString();

                        tvBalance.setText(balance);
                    } else {
                        Toast.makeText(getActivity(), "Document does not exist", Toast.LENGTH_SHORT).show();
                    }
                  }
              })
              .addOnFailureListener(new OnFailureListener() {
                  @Override
                  public void onFailure(@NonNull Exception e) {
                      Toast.makeText(getActivity(), "Error! ", Toast.LENGTH_SHORT).show();
                      Log.d(TAG, e.toString());
                  }
              });
   }

    @Override
    public void onClick(View view) {
        if (view == btnWithdraw){
            Intent intent = new Intent(getActivity(), WithdrawalActivity.class);
            startActivity(intent);
        }
    }
}
