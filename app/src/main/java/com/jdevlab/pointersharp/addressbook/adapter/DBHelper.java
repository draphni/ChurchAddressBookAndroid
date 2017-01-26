package com.jdevlab.pointersharp.addressbook.adapter;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.jdevlab.pointersharp.addressbook.model.Member;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteAssetHelper {

    private static final String DB_NAME = "local.db";
    private static final int DB_VERSION = 1;

    public static final String TABLE_CHURCHMEMBER = "ChurchMember";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_ENAME = "eName";
    public static final String COLUMN_TYPE = "type";

    private static final String orderBy = DBHelper.COLUMN_ENAME + " ASC";

    private Context mContext;
    private SQLiteDatabase mDB;

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

        mContext = context;
        setForcedUpgrade();
    }

    public List<Member> GetAllMembers() {
        List<Member> members = new ArrayList<Member>();

        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM ChurchMember", null);

        if (cursor != null) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                Member m = CursorToMember(cursor);
                members.add(m);
                cursor.moveToNext();
            }
            cursor.close();
        }

        return members;
    }

    public Member GetMemberById(int id) {
        Member m = null;

        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.query(
                DBHelper.TABLE_CHURCHMEMBER, null, DBHelper.COLUMN_ID + " = ?",
                new String[]{String.valueOf(id)}, null, null, orderBy);
        if (cursor != null) {
            cursor.moveToFirst();
            m = CursorToMember(cursor);
            cursor.close();
        }

        return m;
    }

    public List<Member> GetMembersByType(String type) {
        List<Member> members = new ArrayList<Member>();

        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.query(
                DBHelper.TABLE_CHURCHMEMBER, null, DBHelper.COLUMN_TYPE + " =?",
                new String[]{type}, null, null, orderBy);

        if (cursor != null) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                Member m = CursorToMember(cursor);
                members.add(m);
                cursor.moveToNext();
            }
            cursor.close();
        }

        return members;
    }

    private Member CursorToMember(Cursor cursor) {
        int idIndex = cursor.getColumnIndex("Id");
        int kNameIndex = cursor.getColumnIndex("kName");
        int eNameIndex = cursor.getColumnIndex("eName");
        int regionIndex = cursor.getColumnIndex("Region");
        int dobIndex = cursor.getColumnIndex("DOB");
        int dosIndex = cursor.getColumnIndex("DOS");
        int addrIndex = cursor.getColumnIndex("Street");
        int cityIndex = cursor.getColumnIndex("City");
        int zipIndex = cursor.getColumnIndex("Zip");
        int cellIndex = cursor.getColumnIndex("Phone");
        int genderIndex = cursor.getColumnIndex("Gender");
        int typeIndex = cursor.getColumnIndex("type");

        String id = cursor.getString(idIndex);
        String kName = cursor.getString(kNameIndex);
        String eName = cursor.getString(eNameIndex);
        String region = cursor.getString(regionIndex);
        String dob = cursor.getString(dobIndex);
        String dos = cursor.getString(dosIndex);
        String addr = cursor.getString(addrIndex);
        String city = cursor.getString(cityIndex);
        String zip = cursor.getString(zipIndex);
        String cell = cursor.getString(cellIndex);
        String gender = cursor.getString(genderIndex);
        String type = cursor.getString(typeIndex);

        Member m = new Member(id, kName, eName, region, dob, dos, addr, city, zip, cell, gender, type);

        return m;
    }
}
