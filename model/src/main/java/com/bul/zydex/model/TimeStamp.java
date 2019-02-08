/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Teja
 */
public class TimeStamp {
    
    private String timeStamp;
    private String time;
    private String date;
    private int hours;
    private int min;
    private int sec;
    private int day;
    private int month;
    private int year;
    private int minDiff;
    private int endTimeHour;
    private int startTimeHour;
    private int endTimeMin;
    private int startTimeMin;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getSec() {
        return sec;
    }

    public void setSec(int sec) {
        this.sec = sec;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMinDiff() {
        return minDiff;
    }

    public void setMinDiff(int minDiff) {
        this.minDiff = minDiff;
    }

    public int getEndTimeHour() {
        return endTimeHour;
    }

    public void setEndTimeHour(int endTimeHour) {
        this.endTimeHour = endTimeHour;
    }

    public int getStartTimeHour() {
        return startTimeHour;
    }

    public void setStartTimeHour(int startTimeHour) {
        this.startTimeHour = startTimeHour;
    }

    public int getEndTimeMin() {
        return endTimeMin;
    }

    public void setEndTimeMin(int endTimeMin) {
        this.endTimeMin = endTimeMin;
    }

    public int getStartTimeMin() {
        return startTimeMin;
    }

    public void setStartTimeMin(int startTimeMin) {
        this.startTimeMin = startTimeMin;
    }

    public LocalDateTime getNow() {
        return now;
    }

    public void setNow(LocalDateTime now) {
        this.now = now;
    }

    public SimpleDateFormat getFormat() {
        return format;
    }

    public void setFormat(SimpleDateFormat format) {
        this.format = format;
    }

    public DateTimeFormatter getDtf() {
        return dtf;
    }

    public void setDtf(DateTimeFormatter dtf) {
        this.dtf = dtf;
    }
	
    LocalDateTime now = LocalDateTime.now();
    SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            
    public void setTimeStamp(String timeDate){
            this.timeStamp        =   timeDate;
            this.time             =   timeDate.split(" ")[1];
            this.date             =   timeDate.split(" ")[0];
            this.hours            =   new Integer(this.time.split(":")[0]);
            this.min              =   new Integer(this.time.split(":")[1]);
            this.sec              =   new Integer(this.time.split(":")[2]);
            this.day              =   new Integer(this.date.split("/")[0]);
            this.month            =   new Integer(this.date.split("/")[1]);
            this.year             =   new Integer(this.date.split("/")[2]);
    }
	
    public int getMinDiff(TimeStamp outTime){
        if(outTime.getDay()<this.day){
            this.minDiff = this.min==0?(((24-outTime.hours)+(this.hours))*60)-(outTime.min-this.min):(((24-outTime.hours)+(this.hours))*60)+(outTime.min-this.min);
            return minDiff;
        }else{
//            this.minDiff = this.min==0?((this.hours-outTime.hours)*60)-(outTime.min-this.min):((this.hours-outTime.hours)*60)+(outTime.min-this.min);
            this.minDiff = ((this.hours-outTime.hours)*60)+(this.min-outTime.min);
            return minDiff;
        }
            
    }

    public String getErrorText(){
            return ((this.minDiff-60)/60) +" Hours "+ ((this.minDiff-60)%60)+ " Minutes late at "+ (this.time)+"\n";
    }

    public void setShifts(String inTime,String outTime){
        this.endTimeHour = Integer.parseInt(outTime.split(":")[0].trim());
        this.endTimeMin = Integer.parseInt(outTime.trim().split(":")[1].trim());
        this.startTimeHour = Integer.parseInt(inTime.trim().split(":")[0].trim());
        this.startTimeMin = Integer.parseInt(inTime.trim().split(":")[1].trim());
    }

    public String checkShiftBound() throws ParseException{
            int a = (((((this.hours+12)%24)-((this.endTimeHour+12)%24))*60)+(this.min-this.endTimeMin));
            
            TimeStamp currTime = new TimeStamp();
            currTime.setTimeStamp(dtf.format(now));
            
            if(a<0){
                    TimeStamp timeStamp = new TimeStamp();
                    timeStamp.setTimeStamp(currTime.toString());
                    int b = ((this.hours-timeStamp.hours)*60)+(this.min-timeStamp.min);
                    this.minDiff = b;
                    if(b>60){
                            return ((this.minDiff-60)/60) + " Hours "+ ((this.minDiff-60)%60) + " Minutes at "+ this.time+"\n";
                    }
                    else{
                            return "";
                    }
            }else{
                    return "";
            }
    }
}
