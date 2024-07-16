package com.example.store.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.store.R;
import com.example.store.User;
import com.example.store.UserAdapter;
import com.example.store.userdatabase.UserDatabase;

import java.util.ArrayList;
import java.util.List;


public class LuckyFragment extends Fragment {

    private RecyclerView rcv_user;
    private UserAdapter userAdapter;
    private List<User> mListUser;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    public LuckyFragment() {
        // Required empty public constructor
    }


    public static LuckyFragment newInstance(String param1, String param2) {
        LuckyFragment fragment = new LuckyFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_lucky, container, false);
        rcv_user = view.findViewById(R.id.rcv_user);
        userAdapter = new UserAdapter(new UserAdapter.ClickItemUser() {
            @Override
            public void DeleteUser(User user) {
                ClickDeleteUser(user);
            }
        });
        mListUser = new ArrayList<>();
        userAdapter.setData(mListUser);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
        rcv_user.setLayoutManager(linearLayoutManager);
        rcv_user.setAdapter(userAdapter);



        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ShowUser();
    }
    private  void ShowUser()
    {
        mListUser = UserDatabase.getInstance(getView().getContext()).userDAO().getListUser();
        userAdapter.setData(mListUser);
    }

    private void ClickDeleteUser(User user){
        new AlertDialog.Builder(getContext())
                .setTitle("Confirm Delete User")
                .setMessage("Bạn có chắc chắn xóa không ?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        UserDatabase.getInstance(getView().getContext()).userDAO().deleteUser(user);
                        Toast.makeText(getView().getContext(),"Xóa tài khoản thành công",Toast.LENGTH_SHORT).show();
                        ShowUser();

                    }
                })
                .setNegativeButton("No",null)
                .show();
    }
}