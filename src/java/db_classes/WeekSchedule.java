/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db_classes;

import java.io.Serializable;
import java.sql.Time;

/**
 *
 * @author gianma
 */
public class WeekSchedule implements Serializable{
    private boolean monday;
    private boolean tuesday;
    private boolean wednesday;
    private boolean thursday;
    private boolean friday;
    private boolean saturday;
    private boolean sunday;
    
    private Time monday_l_op;
    private Time monday_l_cl;
    private Time monday_d_op;
    private Time monday_d_cl;
    
    private Time tuesday_l_op;
    private Time tuesday_l_cl;
    private Time tuesday_d_op;
    private Time tuesday_d_cl;
    
    private Time wednesday_l_op;
    private Time wednesday_l_cl;
    private Time wednesday_d_op;
    private Time wednesday_d_cl;
    
    private Time thursday_l_op;
    private Time thursday_l_cl;
    private Time thursday_d_op;
    private Time thursday_d_cl;
    
    private Time friday_l_op;
    private Time friday_l_cl;
    private Time friday_d_op;
    private Time friday_d_cl;
    
    private Time saturday_l_op;
    private Time saturday_l_cl;
    private Time saturday_d_op;
    private Time saturday_d_cl;
    
    private Time sunday_l_op;
    private Time sunday_l_cl;
    private Time sunday_d_op;
    private Time sunday_d_cl;
    
    /**
     *
     */
    public WeekSchedule(){
        this.monday = false;
        this.tuesday = false;
        this.wednesday = false;
        this.thursday = false;
        this.friday = false;
        this.saturday = false;
        this.sunday = false;
    }
    
    /**
     * @return the monday
     */
    public boolean isMonday() {
        return monday;
    }

    /**
     * @param monday the monday to set
     */
    public void setMonday(boolean monday) {
        this.monday = monday;
    }

    /**
     * @return the tuesday
     */
    public boolean isTuesday() {
        return tuesday;
    }

    /**
     * @param tuesday the tuesday to set
     */
    public void setTuesday(boolean tuesday) {
        this.tuesday = tuesday;
    }

    /**
     * @return the wednesday
     */
    public boolean isWednesday() {
        return wednesday;
    }

    /**
     * @param wednesday the wednesday to set
     */
    public void setWednesday(boolean wednesday) {
        this.wednesday = wednesday;
    }

    /**
     * @return the thursday
     */
    public boolean isThursday() {
        return thursday;
    }

    /**
     * @param thursday the thursday to set
     */
    public void setThursday(boolean thursday) {
        this.thursday = thursday;
    }

    /**
     * @return the friday
     */
    public boolean isFriday() {
        return friday;
    }

    /**
     * @param friday the friday to set
     */
    public void setFriday(boolean friday) {
        this.friday = friday;
    }

    /**
     * @return the saturday
     */
    public boolean isSaturday() {
        return saturday;
    }

    /**
     * @param saturday the saturday to set
     */
    public void setSaturday(boolean saturday) {
        this.saturday = saturday;
    }

    /**
     * @return the sunday
     */
    public boolean isSunday() {
        return sunday;
    }

    /**
     * @param sunday the sunday to set
     */
    public void setSunday(boolean sunday) {
        this.sunday = sunday;
    }

    /**
     * @return the monday_l_op
     */
    public Time getMonday_l_op() {
        return monday_l_op;
    }

    /**
     * @param monday_l_op the monday_l_op to set
     */
    public void setMonday_l_op(Time monday_l_op) {
        this.monday_l_op = monday_l_op;
    }

    /**
     * @return the monday_l_cl
     */
    public Time getMonday_l_cl() {
        return monday_l_cl;
    }

    /**
     * @param monday_l_cl the monday_l_cl to set
     */
    public void setMonday_l_cl(Time monday_l_cl) {
        this.monday_l_cl = monday_l_cl;
    }

    /**
     * @return the tuesday_l_op
     */
    public Time getTuesday_l_op() {
        return tuesday_l_op;
    }

    /**
     * @param tuesday_l_op the tuesday_l_op to set
     */
    public void setTuesday_l_op(Time tuesday_l_op) {
        this.tuesday_l_op = tuesday_l_op;
    }

    /**
     * @return the tuesday_l_cl
     */
    public Time getTuesday_l_cl() {
        return tuesday_l_cl;
    }

    /**
     * @param tuesday_l_cl the tuesday_l_cl to set
     */
    public void setTuesday_l_cl(Time tuesday_l_cl) {
        this.tuesday_l_cl = tuesday_l_cl;
    }

    /**
     * @return the wednesday_l_op
     */
    public Time getWednesday_l_op() {
        return wednesday_l_op;
    }

    /**
     * @param wednesday_l_op the wednesday_l_op to set
     */
    public void setWednesday_l_op(Time wednesday_l_op) {
        this.wednesday_l_op = wednesday_l_op;
    }

    /**
     * @return the wednesday_l_cl
     */
    public Time getWednesday_l_cl() {
        return wednesday_l_cl;
    }

    /**
     * @param wednesday_l_cl the wednesday_l_cl to set
     */
    public void setWednesday_l_cl(Time wednesday_l_cl) {
        this.wednesday_l_cl = wednesday_l_cl;
    }

    /**
     * @return the thursday_l_op
     */
    public Time getThursday_l_op() {
        return thursday_l_op;
    }

    /**
     * @param thursday_l_op the thursday_l_op to set
     */
    public void setThursday_l_op(Time thursday_l_op) {
        this.thursday_l_op = thursday_l_op;
    }

    /**
     * @return the thursday_l_cl
     */
    public Time getThursday_l_cl() {
        return thursday_l_cl;
    }

    /**
     * @param thursday_l_cl the thursday_l_cl to set
     */
    public void setThursday_l_cl(Time thursday_l_cl) {
        this.thursday_l_cl = thursday_l_cl;
    }

    /**
     * @return the friday_l_op
     */
    public Time getFriday_l_op() {
        return friday_l_op;
    }

    /**
     * @param friday_l_op the friday_l_op to set
     */
    public void setFriday_l_op(Time friday_l_op) {
        this.friday_l_op = friday_l_op;
    }

    /**
     * @return the friday_l_cl
     */
    public Time getFriday_l_cl() {
        return friday_l_cl;
    }

    /**
     * @param friday_l_cl the friday_l_cl to set
     */
    public void setFriday_l_cl(Time friday_l_cl) {
        this.friday_l_cl = friday_l_cl;
    }

    /**
     * @return the saturday_l_op
     */
    public Time getSaturday_l_op() {
        return saturday_l_op;
    }

    /**
     * @param saturday_l_op the saturday_l_op to set
     */
    public void setSaturday_l_op(Time saturday_l_op) {
        this.saturday_l_op = saturday_l_op;
    }

    /**
     * @return the saturday_l_cl
     */
    public Time getSaturday_l_cl() {
        return saturday_l_cl;
    }

    /**
     * @param saturday_l_cl the saturday_l_cl to set
     */
    public void setSaturday_l_cl(Time saturday_l_cl) {
        this.saturday_l_cl = saturday_l_cl;
    }

    /**
     * @return the sunday_l_op
     */
    public Time getSunday_l_op() {
        return sunday_l_op;
    }

    /**
     * @param sunday_l_op the sunday_l_op to set
     */
    public void setSunday_l_op(Time sunday_l_op) {
        this.sunday_l_op = sunday_l_op;
    }

    /**
     * @return the sunday_l_cl
     */
    public Time getSunday_l_cl() {
        return sunday_l_cl;
    }

    /**
     * @param sunday_l_cl the sunday_l_cl to set
     */
    public void setSunday_l_cl(Time sunday_l_cl) {
        this.sunday_l_cl = sunday_l_cl;
    }

    /**
     * @return the monday_d_op
     */
    public Time getMonday_d_op() {
        return monday_d_op;
    }

    /**
     * @param monday_d_op the monday_d_op to set
     */
    public void setMonday_d_op(Time monday_d_op) {
        this.monday_d_op = monday_d_op;
    }

    /**
     * @return the monday_d_cl
     */
    public Time getMonday_d_cl() {
        return monday_d_cl;
    }

    /**
     * @param monday_d_cl the monday_d_cl to set
     */
    public void setMonday_d_cl(Time monday_d_cl) {
        this.monday_d_cl = monday_d_cl;
    }

    /**
     * @return the tuesday_d_op
     */
    public Time getTuesday_d_op() {
        return tuesday_d_op;
    }

    /**
     * @param tuesday_d_op the tuesday_d_op to set
     */
    public void setTuesday_d_op(Time tuesday_d_op) {
        this.tuesday_d_op = tuesday_d_op;
    }

    /**
     * @return the tuesday_d_cl
     */
    public Time getTuesday_d_cl() {
        return tuesday_d_cl;
    }

    /**
     * @param tuesday_d_cl the tuesday_d_cl to set
     */
    public void setTuesday_d_cl(Time tuesday_d_cl) {
        this.tuesday_d_cl = tuesday_d_cl;
    }

    /**
     * @return the wednesday_d_op
     */
    public Time getWednesday_d_op() {
        return wednesday_d_op;
    }

    /**
     * @param wednesday_d_op the wednesday_d_op to set
     */
    public void setWednesday_d_op(Time wednesday_d_op) {
        this.wednesday_d_op = wednesday_d_op;
    }

    /**
     * @return the wednesday_d_cl
     */
    public Time getWednesday_d_cl() {
        return wednesday_d_cl;
    }

    /**
     * @param wednesday_d_cl the wednesday_d_cl to set
     */
    public void setWednesday_d_cl(Time wednesday_d_cl) {
        this.wednesday_d_cl = wednesday_d_cl;
    }

    /**
     * @return the thursday_d_op
     */
    public Time getThursday_d_op() {
        return thursday_d_op;
    }

    /**
     * @param thursday_d_op the thursday_d_op to set
     */
    public void setThursday_d_op(Time thursday_d_op) {
        this.thursday_d_op = thursday_d_op;
    }

    /**
     * @return the thursday_d_cl
     */
    public Time getThursday_d_cl() {
        return thursday_d_cl;
    }

    /**
     * @param thursday_d_cl the thursday_d_cl to set
     */
    public void setThursday_d_cl(Time thursday_d_cl) {
        this.thursday_d_cl = thursday_d_cl;
    }

    /**
     * @return the friday_d_op
     */
    public Time getFriday_d_op() {
        return friday_d_op;
    }

    /**
     * @param friday_d_op the friday_d_op to set
     */
    public void setFriday_d_op(Time friday_d_op) {
        this.friday_d_op = friday_d_op;
    }

    /**
     * @return the friday_d_cl
     */
    public Time getFriday_d_cl() {
        return friday_d_cl;
    }

    /**
     * @param friday_d_cl the friday_d_cl to set
     */
    public void setFriday_d_cl(Time friday_d_cl) {
        this.friday_d_cl = friday_d_cl;
    }

    /**
     * @return the saturday_d_op
     */
    public Time getSaturday_d_op() {
        return saturday_d_op;
    }

    /**
     * @param saturday_d_op the saturday_d_op to set
     */
    public void setSaturday_d_op(Time saturday_d_op) {
        this.saturday_d_op = saturday_d_op;
    }

    /**
     * @return the saturday_d_cl
     */
    public Time getSaturday_d_cl() {
        return saturday_d_cl;
    }

    /**
     * @param saturday_d_cl the saturday_d_cl to set
     */
    public void setSaturday_d_cl(Time saturday_d_cl) {
        this.saturday_d_cl = saturday_d_cl;
    }

    /**
     * @return the sunday_d_op
     */
    public Time getSunday_d_op() {
        return sunday_d_op;
    }

    /**
     * @param sunday_d_op the sunday_d_op to set
     */
    public void setSunday_d_op(Time sunday_d_op) {
        this.sunday_d_op = sunday_d_op;
    }

    /**
     * @return the sunday_d_cl
     */
    public Time getSunday_d_cl() {
        return sunday_d_cl;
    }

    /**
     * @param sunday_d_cl the sunday_d_cl to set
     */
    public void setSunday_d_cl(Time sunday_d_cl) {
        this.sunday_d_cl = sunday_d_cl;
    }

}
