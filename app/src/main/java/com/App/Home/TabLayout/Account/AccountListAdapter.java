package com.App.Home.TabLayout.Account;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.App.test.R;

import java.util.List;

public class AccountListAdapter extends RecyclerView.Adapter<AccountListAdapter.ViewHolder>{
    Context context;
    List<AccountData> accountList;

    public AccountListAdapter(Context context, List<AccountData> accountList) {
        this.context = context;
        this.accountList = accountList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        AccountData account = accountList.get(position);
        holder.userId.setText(account.getUserId());
        holder.Id.setText(account.getId());
        holder.title.setText(account.getTitle());
        holder.body.setText(account.getBody());

    }

    @Override
    public int getItemCount() {
        return accountList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView userId, Id, title, body;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            userId= itemView.findViewById(R.id.userId);
            Id= itemView.findViewById(R.id.Id);
            title= itemView.findViewById(R.id.title);
            body= itemView.findViewById(R.id.body);

        }
    }

}
