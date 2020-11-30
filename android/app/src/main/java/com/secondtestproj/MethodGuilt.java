package com.secondtestproj;

import android.widget.Toast;
import android.content.Context;

import java.util.concurrent.ThreadLocalRandom;

public class MethodGuilt
{
    static String[] guiltMsgs = {"Guilt Msg1a", "Guilt Msg2b", "Guilt Msg3c"};

    MethodGuilt()
    {

    }

    public void setGuiltMsg1(String msg)
    {guiltMsgs[0] = msg;}

    public void setGuiltMsg2(String msg)
    {guiltMsgs[1] = msg;}

    public void setGuiltMsg3(String msg)
    {guiltMsgs[2] = msg;}

    public void printRandomGuiltMsg(Context context)
    {
        int randomNum = ThreadLocalRandom.
        current().
        nextInt(0, 
        guiltMsgs.length);
        //2);
        Toast.makeText(context, guiltMsgs[randomNum], Toast.LENGTH_LONG).show();
    }

}