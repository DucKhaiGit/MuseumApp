package com.example.store;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder>{
    private List<User> mListUser;

    private ClickItemUser clickItemUser;
    public interface ClickItemUser{
        void DeleteUser(User user);

    }

    public UserAdapter(ClickItemUser clickItemUser) {
        this.clickItemUser = clickItemUser;
    }

    public void setData(List<User> list){
        this.mListUser = list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user,parent,false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = mListUser.get(position);
        if(user ==null){
            return;
        }

        holder.tv_username.setText(user.getAccount());
        holder.tv_password.setText(user.getPassword());
        holder.tv_role.setText(user.getRole());

        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickItemUser.DeleteUser(user);
            }
        });
    }

    @Override
    public int getItemCount() {
        if(mListUser != null)
        {
            return  mListUser.size();
        }
        return 0;
    }

    public class UserViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_username;
        private TextView tv_password;

        private TextView tv_role;

        private Button btnDelete;

        public UserViewHolder(@NonNull View itemView) {

            super(itemView);
            tv_username = itemView.findViewById(R.id.tv_username);
            tv_password = itemView.findViewById(R.id.tv_password);
            tv_role = itemView.findViewById(R.id.tv_role);
            btnDelete= itemView.findViewById(R.id.btnDeleteUser);
        }
    }
}
