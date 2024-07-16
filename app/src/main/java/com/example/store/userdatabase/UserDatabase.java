package com.example.store.userdatabase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.store.User;

@Database(entities = {User.class},version = 2)

public abstract class UserDatabase extends RoomDatabase {
    private static final String DATABASE_NAME = "User";
    private static UserDatabase instance;

    public static synchronized UserDatabase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),UserDatabase.class,DATABASE_NAME)
                    .addMigrations(MIGRATION_1_2) // Thêm Migration
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
    public abstract UserDAO userDAO();

    // Migration từ phiên bản 1 lên phiên bản 2
    static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            // Thêm cột 'role' vào bảng User
            database.execSQL("ALTER TABLE User ADD COLUMN role TEXT DEFAULT 'guest' ");
        }
    };
}
