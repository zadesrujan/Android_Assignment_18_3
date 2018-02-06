package com.example.user.android_assignment_18_3;
//Package objects contain version information about the implementation and specification of a Java package.
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    //public is a method and fields can be accessed by the members of any class.
    //class is a collections of objects.
    //created MainActivity and extends with AppCompatActivity which is Parent class that implements the onclick listener method.

    @Override
    //we use override to tells the compiler that the following method overrides a method of its superclass.
    protected void onCreate(Bundle savedInstanceState) {
        //protected can be accessed by within the package and class and subclasses
        //The Void class is an uninstantiable placeholder class to hold a reference to the Class object
        //representing the Java keyword void.
        //The savedInstanceState is a reference to a Bundle object that is passed into the onCreate method of every Android Activity
        // Activities have the ability, under special circumstances, to restore themselves to a previous state using the data stored in this bundle.
        super.onCreate(savedInstanceState);
        //Android class works in same.You are extending the Activity class which have onCreate(Bundle bundle) method in which meaningful code is written
        //So to execute that code in our defined activity. You have to use super.onCreate(bundle)
        setContentView(R.layout.activity_main);
        //R means Resource
        //layout means design
        //main is the xml you have created under res->layout->main.xml
        //Whenever you want to change your current Look of an Activity or when you move from one Activity to another .
        //he other Activity must have a design to show . So we call this method in onCreate and this is the second statement to set
        //the design


        Button simple_notification_btn = (Button) findViewById(R.id.button);
        //giving the id as button to object simple_notification_btn.
        simple_notification_btn.setOnClickListener(this);
        //by implementing setOnClickListener by this if we click on button it goes to seconctivtiy

    }
    @Override
    public void onClick(View view) {
    //Called when a view has been clicked.
        Notification.Builder builder = new Notification.Builder(MainActivity.this)
                //craeted new object as builder
                .setSmallIcon(R.drawable.i)
                //setting the image from the drwable folder
                .setContentTitle("Important")
                //Set the first line of text in the platform notification template.
                .setContentText("Messages");
                //Set the second line of text in the platform notification template


        Intent resultIntent = new Intent(this, MainActivity.class);
        //creating intent
        resultIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        //created object of pendingIntent
        PendingIntent piResult = PendingIntent.getActivity(this, 0, resultIntent, 0);
        //created object as piResult and giving to the pending intent which will get the activity by sending the request code.
        Notification notification = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {
            //Applications targeting this or a later release will get these new changes in behavior:
            notification = new Notification.InboxStyle(builder)
                    //adding Some Notification\.addLine("Hello....!!")
                    .addLine("How are you?????")
                    .addLine("Hi !!!!")
                    .addLine("I'm fine")
                    .addLine("what about you?all is well?")
                    .addLine("yes,everything is all right... ")
                    .setBigContentTitle("Event details")
                    .setSummaryText("+3 more")
                    .build();

        }
        builder.setContentIntent(piResult);
        //Supply a PendingIntent to be sent when the notification is clicked.
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        //creating notification manager
        notificationManager.notify(121, notification);
        //Class to notify the user of events that happen. This is how you tell the user that something has happened in the background.

    }
}