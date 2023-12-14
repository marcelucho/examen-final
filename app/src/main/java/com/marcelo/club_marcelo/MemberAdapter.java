package com.marcelo.club_marcelo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MemberAdapter extends RecyclerView.Adapter<MemberAdapter.UserViewHolder> {

    private List<Member> members;
    private int selectedPosition = -1;

    private Context context;

    public MemberAdapter(List<Member> members, Context context) {
        this.members = members;
        this.context = context;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_item, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        Member member = members.get(position);
        // Se configura los datos de los elementos de la lista
        holder.idTV.setText(String.valueOf(member.getId()));
        holder.nombreTV.setText(member.getName());
        holder.telefonoTV.setText(member.getPhone());
        holder.documentoTV.setText(member.getDocument());

        // Configura un OnClickListener en el ViewHolder
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Guarda el índice del elemento seleccionado
                setSelectedPosition(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return members.size();
    }

    public int getSelectedPosition() {
        return selectedPosition;
    }

    public void setSelectedPosition(int selectedPosition) {
        this.selectedPosition = selectedPosition;
    }

    class UserViewHolder extends RecyclerView.ViewHolder {
        // Se declararan los elementos de la vista (Layout user_item.xml)
        TextView idTV, nombreTV, telefonoTV,documentoTV;

        public UserViewHolder(View itemView) {
            super(itemView);
            idTV = itemView.findViewById(R.id.txtItemId);
            nombreTV = itemView.findViewById(R.id.txtItemNombre);
            telefonoTV = itemView.findViewById(R.id.txtItemPhone);
            documentoTV = itemView.findViewById(R.id.txtItemDocument);
        }
    }

}
