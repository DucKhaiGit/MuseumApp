package com.example.store;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableField;

import com.example.store.userdatabase.UserDAO;
import com.example.store.userdatabase.UserDatabase;

public class LoginVM  extends BaseObservable {
    private String email;
    private String password;

    private String role;

    private UserDatabase userDatabase;
    public ObservableField<String> messageLogin = new ObservableField<>();

    public ObservableField<Boolean> isColorSuccess = new ObservableField<>();

    public LoginVM(Context context){
        userDatabase = UserDatabase.getInstance(context);
    }
    @Bindable
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        notifyPropertyChanged(BR.email);
    }
    @Bindable
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        notifyPropertyChanged(BR.password);
    }
    @Bindable
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
        notifyPropertyChanged(BR.role);
    }

    public void onClickLogin(View v)
    {

        User user = new User(getEmail(),getPassword(),getRole());
        if(userDatabase.userDAO().loginUser(user.getAccount(), user.getPassword(), user.getRole()) != null)
        {
            Context context = v.getContext();
            isColorSuccess.set(true);
            messageLogin.set("Dang nhap thanh cong !");
            Intent intent = new Intent(context, SplashActivity.class);
            intent.putExtra("userRole",user.getRole());
            context.startActivity(intent);
        }
        else {
            isColorSuccess.set(false);
            messageLogin.set("Tai khoan khong dung !");
        }
    }
    public void onClickRegist(View v)
    {

        User user = new User(getEmail(),getPassword(),getRole());
        if(userDatabase.userDAO().checkUserExists(user.getAccount())>0)
        {
            messageLogin.set("Tài khoản đã tồn tại, hãy thử tài khoản khác.");
        }
        else{
            userDatabase.userDAO().regisUser(user);
            isColorSuccess.set(true);
            messageLogin.set("Đã đăng kí tài khoản thành công, mời bạn đăng nhập.");
        }

    }


}
