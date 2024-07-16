package com.example.store.userdatabase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.store.User;

import java.util.List;

@Dao
public interface UserDAO {

    @Insert
    void regisUser( User user);

    @Query("SELECT * FROM User WHERE account = :account AND password = :password AND role = :role")
    User loginUser(String account, String password, String role );

    @Query("SELECT COUNT(*) FROM User WHERE account = :account")
    int checkUserExists(String account);

    @Query("SELECT * FROM User")
    List<User> getListUser();

    @Delete
    void deleteUser(User user);


}
