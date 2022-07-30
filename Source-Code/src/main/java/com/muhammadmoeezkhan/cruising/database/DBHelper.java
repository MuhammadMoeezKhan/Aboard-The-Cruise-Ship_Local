package com.muhammadmoeezkhan.cruising.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "cruise.db";
    public static final int DB_VERSION  = 1;

    public static DBHelper helper;

    public static final String TABLE_PASSENGER = "Passenger";
    public static final String COL_PASSENGER_ID = "id";
    public static final String COL_PASSENGER_FIRST_NAME = "first_name";
    public static final String COL_PASSENGER_LAST_NAME = "last_name";
    public static final String COL_PASSENGER_PASSPORT = "passport";
    public static final String COL_PASSENGER_BIRTHDATE = "birthdate";
    public static final String COL_PASSENGER_CITY = "city";
    public static final String COL_PASSENGER_STATE = "state";

    private DBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public static DBHelper getInstance(Context context){
        if(helper==null){
            helper = new DBHelper(context);
        }
            return helper;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    String sql = "CREATE TABLE " + TABLE_PASSENGER + " (" +
            COL_PASSENGER_ID + " INTEGER," +
            COL_PASSENGER_FIRST_NAME + " TEXT NOT NULL," +
            COL_PASSENGER_LAST_NAME + " TEXT NOT NULL," +
            COL_PASSENGER_PASSPORT + " INTEGER," +
            COL_PASSENGER_BIRTHDATE + " TEXT NOT NULL,"+
            COL_PASSENGER_CITY + " TEXT NOT NULL," +
            COL_PASSENGER_STATE + " TEXT NOT NULL," +
            "PRIMARY KEY(" + COL_PASSENGER_ID + " AUTOINCREMENT)" +
            ")";
    db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {  }

    public long insertPassenger(Passenger p){

        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COL_PASSENGER_FIRST_NAME, p.getFirstName());
        cv.put(COL_PASSENGER_LAST_NAME, p.getLastName());
        cv.put(COL_PASSENGER_PASSPORT, p.getPassportNumber());
        cv.put(COL_PASSENGER_BIRTHDATE, p.getBirthdate());
        cv.put(COL_PASSENGER_CITY, p.getCity());
        cv.put(COL_PASSENGER_STATE, p.getState());

        long result = db.insert(TABLE_PASSENGER, null, cv);
        db.close();
        return result;
    }

    public List<Passenger> getAllPassengers(){

        SQLiteDatabase db = getReadableDatabase();
        String sql = "SELECT * FROM " + TABLE_PASSENGER;

        Cursor myCursor = db.rawQuery(sql, null);
        int idx_id = myCursor.getColumnIndex(COL_PASSENGER_ID);
        int idx_firstName = myCursor.getColumnIndex(COL_PASSENGER_FIRST_NAME);
        int idx_lastName = myCursor.getColumnIndex(COL_PASSENGER_LAST_NAME);
        int idx_passportNumber = myCursor.getColumnIndex(COL_PASSENGER_PASSPORT);
        int idx_birthDate = myCursor.getColumnIndex(COL_PASSENGER_BIRTHDATE);
        int idx_city = myCursor.getColumnIndex(COL_PASSENGER_CITY);
        int idx_state = myCursor.getColumnIndex(COL_PASSENGER_STATE);

        List<Passenger> passengers = new ArrayList<Passenger>();

        if(myCursor.moveToFirst()){
            do {
                int id = myCursor.getInt(idx_id);
                String firstName = myCursor.getString(idx_firstName);
                String lastName = myCursor.getString(idx_lastName);
                int passportNumber = myCursor.getInt(idx_passportNumber);
                String birthDate = myCursor.getString(idx_birthDate);
                String city = myCursor.getString(idx_city);
                String state = myCursor.getString(idx_state);

                Passenger p = new Passenger(id, firstName, lastName, passportNumber, birthDate, city, state);
                passengers.add(p);

            }   while(myCursor.moveToNext());
        }
        db.close();
        return passengers;
    }

    public Passenger getPassengerById(int searchID){
        SQLiteDatabase db = getReadableDatabase();

        String sql = String.format("SELECT * FROM %s WHERE %s = %s", TABLE_PASSENGER, COL_PASSENGER_ID, searchID);
        Cursor myCursor = db.rawQuery(sql, null);

        int idx_id = myCursor.getColumnIndex(COL_PASSENGER_ID);
        int idx_firstName = myCursor.getColumnIndex(COL_PASSENGER_FIRST_NAME);
        int idx_lastName = myCursor.getColumnIndex(COL_PASSENGER_LAST_NAME);
        int idx_passportNumber = myCursor.getColumnIndex(COL_PASSENGER_PASSPORT);
        int idx_birthDate = myCursor.getColumnIndex(COL_PASSENGER_BIRTHDATE);
        int idx_city = myCursor.getColumnIndex(COL_PASSENGER_CITY);
        int idx_state = myCursor.getColumnIndex(COL_PASSENGER_STATE);

        if(myCursor.moveToFirst()){
            int id = myCursor.getInt(idx_id);
            String firstName = myCursor.getString(idx_firstName);
            String lastName = myCursor.getString(idx_lastName);
            int passportNumber = myCursor.getInt(idx_passportNumber);
            String birthDate = myCursor.getString(idx_birthDate);
            String city = myCursor.getString(idx_city);
            String state = myCursor.getString(idx_state);

            Passenger p = new Passenger(id, firstName, lastName, passportNumber, birthDate, city, state);
            db.close();
            return p;
        }
        else{
            db.close();
            return null;
        }
    }

    public int updatePassenger(Passenger updatedPassenger){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COL_PASSENGER_FIRST_NAME, updatedPassenger.getFirstName());
        cv.put(COL_PASSENGER_LAST_NAME, updatedPassenger.getLastName());
        cv.put(COL_PASSENGER_PASSPORT, updatedPassenger.getPassportNumber());
        cv.put(COL_PASSENGER_BIRTHDATE, updatedPassenger.getBirthdate());
        cv.put(COL_PASSENGER_CITY, updatedPassenger.getCity());
        cv.put(COL_PASSENGER_STATE, updatedPassenger.getState());

        String whereClause = String.format("%s = %s", COL_PASSENGER_ID, updatedPassenger.getId());
        int numRows = db.update(TABLE_PASSENGER, cv, whereClause, null);
        db.close();
        return numRows;
    }

    public int deletePassenger(int passportNo){

        SQLiteDatabase db = getWritableDatabase();

        String whereClause = String.format("%s LIKE %s", COL_PASSENGER_PASSPORT, passportNo);
        int numRows = db.delete(TABLE_PASSENGER, whereClause, null);

        db.close();
        return numRows;
    }

}
