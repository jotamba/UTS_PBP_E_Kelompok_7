package com.example.salonkita_utspbp;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.HashMap;
import java.util.Map;


public class ProfileFragment extends Fragment {

    public static final String TAG = "TAG";
    EditText profileName, profileAddress, profilePhone;
    Button saveBtn;
    FirebaseAuth fAuth;
    String userId;
    FirebaseFirestore fStore;
    FirebaseUser user;
    StorageReference storageReference;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View root = inflater.inflate(R.layout.fragment_profile, container, false);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        storageReference = FirebaseStorage.getInstance().getReference();

        profileName = root.findViewById(R.id.profileName);
        profileAddress = root.findViewById(R.id.profileAddress);
        profilePhone = root.findViewById(R.id.profileTelp);
        saveBtn = root.findViewById(R.id.saveProfileInfo);


        userId = fAuth.getCurrentUser().getUid();
        user = fAuth.getCurrentUser();

        final DocumentReference documentReference = fStore.collection("users").document(userId);
        documentReference.addSnapshotListener(getActivity(), new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                if (documentSnapshot.exists()) {
                    profileName.setText(documentSnapshot.getString("email"));
                    profileName.setText(documentSnapshot.getString("fName"));
                    profilePhone.setText(documentSnapshot.getString("telp"));
                    profileAddress.setText(documentSnapshot.getString("alamat"));
                } else {
                    Log.d("tag", "onEvent: Document do not exists");
                }
            }
        });


        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (profileName.getText().toString().isEmpty() || profileAddress.getText().toString().isEmpty() || profilePhone.getText().toString().isEmpty()) {
                    Toast.makeText(getActivity(), "One or Many fields are empty.", Toast.LENGTH_SHORT).show();
                    return;
                }


                DocumentReference docRef = fStore.collection("users").document(user.getUid());
                Map<String, Object> edited = new HashMap<>();
                edited.put("fName", profileName.getText().toString());
                edited.put("alamat", profileAddress.getText().toString());
                edited.put("telp", profilePhone.getText().toString());
                docRef.update(edited).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(getActivity(), "Profile Updated", Toast.LENGTH_SHORT).show();

                    }
                });
            }

        });
        return root;
    }
}