package com.example.courseondemand;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.courseondemand.home_fragment_list.UserResponse;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.core.Tag;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import static android.support.constraint.Constraints.TAG;

import java.util.ArrayList;

public class AccountFragment extends Fragment implements View.OnClickListener {
    private FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private String uid = firebaseAuth.getCurrentUser().getUid();
    private DocumentReference tentorRef = db.collection("users").document(uid);
    private TextView tvNameTentor, tvStatus;
    private Button btnLogout;
    private ArrayList<UserResponse> mUser = new ArrayList<>();
    private ImageView ivTentorAcc;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.fragment_account, null);

        setHasOptionsMenu(true);

        tvNameTentor = v.findViewById(R.id.tvNameTentor);
        tvStatus = v.findViewById(R.id.tvStatus);
        ivTentorAcc = v.findViewById(R.id.ivTentorAccount);

        getTentor();

        btnLogout = (Button) v.findViewById(R.id.btnLogout);

        btnLogout.setOnClickListener(this);

        return v;
    }

    private void getTentor(){
        tentorRef.get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if (documentSnapshot.exists()){
                            UserResponse dbUser = documentSnapshot.toObject(UserResponse.class);
                            mUser.add(dbUser);

                            Tools.setImage(ivTentorAcc,mUser.get(0).picture);
                            tvNameTentor.setText(mUser.get(0).name);
                            if (mUser.get(0).role == 2) {
                                tvStatus.setText("Tentor");
                            }
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

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater){
        menu.clear();
        inflater.inflate(R.menu.menu_acc_fragment,menu);
        super.onCreateOptionsMenu(menu,inflater);
    }


    @Override
    public void onClick(View view) {
        if (view == btnLogout){
            firebaseAuth.signOut();
        }
    }
}
