package com.example.sleeptracker;

import android.util.Log;
import android.widget.SimpleExpandableListAdapter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static java.lang.Integer.parseInt;

//Clock class used to acquire month/day/year/time to later be used on the creation of files for audio recordings
public class pClock {
    private String day;
    private String month;
    private String year;

    public pClock(){
        updateDate();
    }

    //Time is used for file name of audio recordings
    public String getTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH-mm-ss", Locale.getDefault());
        String currentTime = sdf.format(new Date());

        String currentTimeArray[] = currentTime.split("-");

        Boolean isPM = false;

        int hour = parseInt(currentTimeArray[0]);

        if(hour >= 12) {
            if(hour != 24) {
                isPM = true;
            }

            hour -= 12;
        }

        String res = hour + ":" + currentTimeArray[1] + ":" + currentTimeArray[2];

        if(isPM) {
            res += " PM";
        }else {
            res += " AM";
        }

        return res;
    }

    //Function Updates the current date
    public void updateDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        String currentDate = sdf.format(new Date());

        String currentDateArray[] = currentDate.split("-");

        setYear(currentDateArray[0]);
        setMonth(currentDateArray[1]);
        setDay(currentDateArray[2]);
    }

    public String getDay() {
        return day;
    }

    public String getMonth() {
        return month;
    }

    public String getYear() {
        return year;
    }

    public void setDay(String newDay) {
        day = newDay;
    }

    public void setMonth(String newMonth) {
        month = convertMonth(newMonth);
    }

    public void setYear(String newYear) {
        year = newYear;
    }

    //Function converts integer month to appropriate named month
    public String convertMonth(String currentMonth) {
        int month = parseInt(currentMonth);
        String res;

        switch(month) {
            case 1:
                res = "January";
                break;
            case 2:
                res = "February";
                break;
            case 3:
                res = "March";
                break;
            case 4:
                res = "April";
                break;
            case 5:
                res = "May";
                break;
            case 6:
                res = "June";
                break;
            case 7:
                res = "July";
                break;
            case 8:
                res = "August";
                break;
            case 9:
                res = "September";
                break;
            case 10:
                res = "October";
                break;
            case 11:
                res = "November";
                break;
            case 12:
                res = "December";
                break;
            default:
                Log.w("CLOCK ERROR", "Month was unobtainable!");
                res = null;
                break;
        }

        return res;
    }

    //Test function for current date
    public void printCurrentDate() {
        Log.d("Clock Test", day);
        Log.d("Clock Test", month);
        Log.d("Clock Test", year);
        Log.d("Clock Test", getTime());
    }
}
