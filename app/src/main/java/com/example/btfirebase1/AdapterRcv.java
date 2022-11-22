package com.example.btfirebase1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterRcv extends RecyclerView.Adapter<AdapterRcv.UserViewHolder>{

    private List<User> mListUsers;

    public AdapterRcv(List<User> mListUsers) {
        this.mListUsers = mListUsers;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlist, parent, false);

        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = mListUsers.get(position);
        if(user == null){
            return;
        }
        holder.tvid.setText(user.getId());
        holder.tvtenthuonggoi.setText(user.getTenthuonggoi());
        holder.tvtenkhoahoc.setText(user.getTenkhoahoc());
        holder.tvmausac.setText(user.getMaula());
        holder.tvdactinh.setText(user.getDactinh());
    }

    @Override
    public int getItemCount() {
        if(mListUsers != null){
            return mListUsers.size();
        }
        return 0;
    }

    public class UserViewHolder extends RecyclerView.ViewHolder{

        private TextView tvid;
        private TextView tvtenthuonggoi;
        private TextView tvtenkhoahoc;
        private TextView tvmausac;
        private TextView tvdactinh;
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            tvid = itemView.findViewById(R.id.txtid);
            tvtenthuonggoi = itemView.findViewById(R.id.txttenthuonggoi);
            tvtenkhoahoc = itemView.findViewById(R.id.txttenkhoahoc);
            tvmausac = itemView.findViewById(R.id.txtmaula);
            tvdactinh = itemView.findViewById(R.id.txtdactinh);
        }
    }
}
