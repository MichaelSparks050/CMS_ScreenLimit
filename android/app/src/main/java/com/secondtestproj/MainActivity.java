package com.secondtestproj;

import com.facebook.react.ReactActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import android.os.IBinder;
import android.os.Binder;

import android.content.ComponentName;

import android.content.pm.PackageManager;
import android.content.pm.ApplicationInfo;
//import com.google.android.material.floatingactionbutton.FloatingActionButton;
//import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.provider.Settings;
import android.util.Log;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;

import java.util.*;
import java.util.ArrayList;

import android.os.IBinder;
import android.content.ServiceConnection;

import com.secondtestproj.YourService.MyLocalBinder;

import android.widget.Button;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;

//import org.apache.http.impl.client.HttpClientBuilder;
//import org.apache.http.impl.client.DefaultHttpClient;

//http and json stuff

import java.net.URL;
import java.net.HttpURLConnection;
import org.json.JSONObject;
import java.io.DataOutputStream;
import java.net.URLEncoder;

/*

android {
    useLibrary 'org.apache.http.legacy'
}

in build.gradle

*/

//http and json stuff

//public class MainActivity extends AppCompatActivity {
public class MainActivity extends ReactActivity {

  private Button button;

  private AppHashTable appHashTable = new AppHashTable();
  static MainActivity myActivity;

  boolean isBound = false;


  YourService myService;// = new YourService();



  
@Override
protected String getMainComponentName() {
  return "secondTestProj";
}

   

public String getTestMessage2()
{return "testMessage4343";}

public String getTestMessage()
{
  PackageManager pm = getPackageManager();
  List<ApplicationInfo> apps = pm.getInstalledApplications(0);

  ApplicationInfo p = new ApplicationInfo();
  List<ApplicationInfo> installedApps = new ArrayList<ApplicationInfo>();

  for(ApplicationInfo app : 
  apps) {

      installedApps.add(app);

      //checks for flags; if flagged, check if updated system app
      /*
      if((app.flags & ApplicationInfo.FLAG_UPDATED_SYSTEM_APP) != 0) 
      {
          installedApps.add(app);
      //it's a system app, not interested
      } 
      else 
      if ((app.flags & ApplicationInfo.FLAG_SYSTEM) != 0) 
      {
          //Discard this one
      //in this case, it should be a user-installed app
      } 
      else 
      {
          installedApps.add(app);
      }
      */
  }

  boolean foundString = false;

/*

  for(int i = 0; i < installedApps.size(); i++)
  {
      //if(installedApps.get(i).processName.equals("com.google.android.youtube"))
      if(installedApps.get(i).processName.equals("asdflkjfjFUCKFUCKFUCKFUCK"))
      {
          return "found youtube";
      }
  }
  return "did not find youtube";
  //com.google.android.youtube
  
  //return "testMessage5";
  //return installedApps.get(0).toString();
  //return "1 " + installedApps.get(0).processName;
  */

  if(isServiceNull())
  {
    return "service null";
  }
  else
  {
    //myService.setMainActivity(this);
    myService.setString("test STRING");
    return "service not null";

  }


}

public AppHashTable getAppHashTable()
{
  return appHashTable;
}

public boolean isAppInTable(String p)
{
      return appHashTable.isAppInTable(p);
}

private ServiceConnection myConnection = new ServiceConnection()
{
  @Override
  public void onServiceConnected(ComponentName name, IBinder service)
  {
    YourService.MyLocalBinder binder = (YourService.MyLocalBinder) service;
    myService = binder.getService();
    isBound = true;

    myService.setString("serviceString");

    Log.wtf("serviceConnected43", "serviceConnected43");

  }

  @Override
  public void onServiceDisconnected(ComponentName name)
  {
    isBound = false;
  }
};

public boolean isServiceNull()
{
  if (myService == null)
  {
    return true;
  }
  return false;
}

public void giveAlarmString(String p)
{
    myService.setString(p);
}

  @Override
  protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      //setContentView(R.layout.activity_main);

    //TimeSlice timeSlice = new TimeSlice();
    //timeSlice.check("com.whatever.youtube", (long)50000);



      /*
      button = (Button) findViewById(R.id.button_1);

      if(button != null) {
        button.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            toggleAlarm();
          }
        });
      }
      */

      //startChecker();

      Log.wtf("mainAct", "mainAct");

      myActivity = this;

      /*
      Intent i = new Intent(this, YourService.class);

      bindService(i, myConnection, Context.BIND_AUTO_CREATE);
      */

      //startService(i);

      startActivity(new Intent(Settings.ACTION_USAGE_ACCESS_SETTINGS));

      //if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
          //startForegroundService(i);
      //}


      //appHashTable.putAppsInTable("com.google.android.youtube;whocares;ddd");

      //System.out.println("test print");

      //myService.setMainActivity(this);

  }

  public void toggleAlarm()
  {
      Intent intent = new Intent("my.action.string");
      intent.putExtra("extra", "bubby;com.android.vending;beeby;com.example.alarmtestapplication");

      ComponentName componentName = new ComponentName(getApplicationContext(), Alarm.class);
      intent.setComponent(componentName);

      sendBroadcast(intent);

    myService.toggleAlarm("passedServString");
    //Log.v("main toggle", "main toggle");
  }

  public void setUpService(String appString)
  {
    Intent intent = new Intent("my.action.string");
    intent.putExtra("extra", appString);

    ComponentName componentName = new ComponentName(getApplicationContext(), Alarm.class);
    intent.setComponent(componentName);

    sendBroadcast(intent);

  //myService.toggleAlarm("passedServString");
  //Log.v("main toggle", "main toggle");   
  }

  public void changeMode()
  {
    
  }

  public void changeAppList()
  {

  }

  public void changeTime()
  {
    
  }

  public void startChecker()
  {
      //if(isBound == false)
      {
        Intent i = new Intent(this, YourService.class);

        bindService(i, myConnection, Context.BIND_AUTO_CREATE);
      }
      //else
      {
        //myConnection.restartBackgroundChecker();
      }
  }

  public void broadcastStopApp()
  {
    Intent i = new Intent(this, YourService.class);
    stopService(i);

    Toast.makeText(getApplicationContext(), "isBound " + isBound, Toast.LENGTH_LONG).show();   

    Intent intent = new Intent("my.action.stopChecker");
    intent.putExtra("extra", "stop");

    ComponentName componentName = new ComponentName(getApplicationContext(), Alarm.class);
    intent.setComponent(componentName);

    sendBroadcast(intent);
  }

  public void broadcastAppString(String appString)
  {
    Intent intent = new Intent("my.action.appString");
    intent.putExtra("extra", appString);

    ComponentName componentName = new ComponentName(getApplicationContext(), Alarm.class);
    intent.setComponent(componentName);

    sendBroadcast(intent);

    //Toast.makeText(getApplicationContext(), "testBroadcast1", Toast.LENGTH_LONG).show();    
  }

  public void broadcastAppMode(String appMode)
  {
    Intent intent = new Intent("my.action.appMode");
    intent.putExtra("extra", appMode);

    ComponentName componentName = new ComponentName(getApplicationContext(), Alarm.class);
    intent.setComponent(componentName);

    sendBroadcast(intent);
  }

  public void broadcastTimeLeft(String timeLeft)
  {
    Intent intent = new Intent("my.action.timeLeft");
    intent.putExtra("extra", timeLeft);

    ComponentName componentName = new ComponentName(getApplicationContext(), Alarm.class);
    intent.setComponent(componentName);

    sendBroadcast(intent);
  }

  public void broadcastUserID(String ID)
  {
    Intent intent = new Intent("my.action.userID");
    intent.putExtra("extra", ID);

    ComponentName componentName = new ComponentName(getApplicationContext(), Alarm.class);
    intent.setComponent(componentName);

    sendBroadcast(intent);
  }

  public void broadcastGuilt1(String msg)
  {
    Intent intent = new Intent("my.action.guilt1");
    intent.putExtra("extra", msg);

    ComponentName componentName = new ComponentName(getApplicationContext(), Alarm.class);
    intent.setComponent(componentName);

    sendBroadcast(intent);
  }

  public void broadcastGuilt2(String msg)
  {
    Intent intent = new Intent("my.action.guilt2");
    intent.putExtra("extra", msg);

    ComponentName componentName = new ComponentName(getApplicationContext(), Alarm.class);
    intent.setComponent(componentName);

    sendBroadcast(intent);
  }

  public void broadcastGuilt3(String msg)
  {
    Intent intent = new Intent("my.action.guilt3");
    intent.putExtra("extra", msg);

    ComponentName componentName = new ComponentName(getApplicationContext(), Alarm.class);
    intent.setComponent(componentName);

    sendBroadcast(intent);
  }

  public void setUpServiceGuilt(String appString)
  {
    Intent intent = new Intent("my.action.string");
    intent.putExtra("extra", appString + ",0");

    ComponentName componentName = new ComponentName(getApplicationContext(), Alarm.class);
    intent.setComponent(componentName);

    sendBroadcast(intent);

    Toast.makeText(getApplicationContext(), "setUpServiceGuilt", Toast.LENGTH_LONG).show();

  //myService.toggleAlarm("passedServString");
  //Log.v("main toggle", "main toggle");   
  }

  public void sendUpAlarmPackage(String appString, String timeLeft, String appMode)
  {
    //String combinedStr = new StringBuilder().append(appString).append("+").append(timeLeft).append("+").append(appMode).toString();
    String combinedStr = "biggle";

    Intent intent = new Intent("com.secondtestproj");

    intent.putExtra("combStr", combinedStr);

    ComponentName componentName = new ComponentName(getApplicationContext(), Alarm.class);
    intent.setComponent(componentName);

    sendBroadcast(intent);

    Toast.makeText(getApplicationContext(), "sendUpAlarmPackage" + combinedStr, Toast.LENGTH_LONG).show();
  }

  public String getListOfApps()
  {



    PackageManager pm = getPackageManager();
    List<ApplicationInfo> apps = pm.getInstalledApplications(0);
  
    ApplicationInfo p = new ApplicationInfo();
    List<ApplicationInfo> installedApps = new ArrayList<ApplicationInfo>();
  
    for(ApplicationInfo app : 
    apps) {
  
        installedApps.add(app);
  
        //checks for flags; if flagged, check if updated system app
        
        if((app.flags & ApplicationInfo.FLAG_UPDATED_SYSTEM_APP) != 0) 
        {
            installedApps.add(app);
        //it's a system app, not interested
        } 
        else 
        if ((app.flags & ApplicationInfo.FLAG_SYSTEM) != 0) 
        {
            //Discard this one
        //in this case, it should be a user-installed app
        } 
        else 
        {
            installedApps.add(app);
        }
        
    }

    String appReturnString = new String();

    for(int i = 0; i < installedApps.size(); i++)
    {
      if(i == installedApps.size() - 1)
      {appReturnString += installedApps.get(i).processName;}
      else
      {appReturnString += installedApps.get(i).processName + ";";}
    }

    return appReturnString;
  }
}