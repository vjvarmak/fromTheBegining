package com.App.Home.TabLayout.Membership;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.App.test.R;

import java.util.List;


public class MembershipAdapter extends RecyclerView.Adapter<MembershipAdapter.MembershipViewHolder> {

    Context context;
    List<MembershipData> membershipDataList;

    public MembershipAdapter(Context context, List<MembershipData> membershipDataList) {
        this.context = context;
        this.membershipDataList = membershipDataList;
    }


    @NonNull
    @Override
    public MembershipViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_list, parent, false);
        return new MembershipViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MembershipViewHolder holder, int position) {
        MembershipData membershipData =membershipDataList.get(position);
        holder.userId.setText(membershipData.getUserId());
        holder.id.setText(membershipData.getId());
        holder.title.setText(membershipData.getTitle());
        holder.body.setText(membershipData.getBody());
    }

    @Override
    public int getItemCount() {
        return membershipDataList.size();
    }

    public class MembershipViewHolder extends RecyclerView.ViewHolder {
        TextView userId;
        TextView id;
        TextView title;
        TextView body;

        public MembershipViewHolder(@NonNull View itemView) {
            super(itemView);
            userId = itemView.findViewById(R.id.userId);
            id = itemView.findViewById(R.id.Id);
            title = itemView.findViewById(R.id.title);
            body = itemView.findViewById(R.id.body);
        }
    }
}
