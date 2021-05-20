package com.example.HandyMan.ui.chat;

import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.HandyMan.Model.ModelClass;
import com.example.HandyMan.R;
import com.example.HandyMan.ui.login.LoginActivityViewModel;
import com.firebase.ui.database.FirebaseListAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ChatActivity extends AppCompatActivity {
    private FirebaseAnalytics firebaseAnalytics;
    private ChatActivityViewModel chatActivityViewModel;
    private FirebaseListAdapter<ModelClass> adapter;
    private FirebaseDatabase database;
    private DatabaseReference myRef;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("Chat");
        firebaseAnalytics = FirebaseAnalytics.getInstance(this);
        chatActivityViewModel = new ViewModelProvider(this).get(ChatActivityViewModel.class);
        setContentView(R.layout.activity_chat);
        FloatingActionButton floatingActionButton = findViewById(R.id.floatingbutton);
        floatingActionButton.setOnClickListener(v -> {
            if(chatActivityViewModel.getCurrentUser().getValue() != null)
            {
                EditText input = findViewById(R.id.input);
                myRef.push().setValue(new ModelClass(input.getText().toString().trim(),
                        chatActivityViewModel.getCurrentUser().getValue().getDisplayName()));
                input.setText("");
            }

        });
        displayChat();
    }

    private void displayChat(){
        ListView listView = findViewById(R.id.listOfChat);
        adapter = new FirebaseListAdapter<ModelClass>(this, ModelClass.class, R.layout.chat_messages, myRef) {
            @Override
            protected void populateView(View view, ModelClass modelClass, int position) {
                TextView textMessage = view.findViewById(R.id.textinmessage);
                TextView timeOfMessage = view.findViewById(R.id.timeofmessage);
                TextView chatMessageUser = view.findViewById(R.id.chatmessageuser);
                textMessage.setText(modelClass.getTextMessage());
                chatMessageUser.setText(modelClass.getTextUser());
                timeOfMessage.setText(DateFormat.format("dd-MM-yyyy (HH:mm:ss)", modelClass.getTimeOfMessage()));
            }
        };
        listView.setAdapter(adapter);
    }
}
