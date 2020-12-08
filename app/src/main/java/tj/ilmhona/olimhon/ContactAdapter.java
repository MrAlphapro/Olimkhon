package tj.ilmhona.olimhon;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {


    private List<Contact> mList;
    private Context mContext;

    public ContactAdapter(MainActivity mContext) {
        this.mContext = mContext;
    }



    public void setData (List<Contact> list){
        this.mList = list;
        notifyDataSetChanged();
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact, parent, false);
        return new ContactViewHolder(view);
    }



    @Override
    public void onBindViewHolder(ContactViewHolder holder,int position)
    {

        Contact contact = mList.get(position);
        if (contact == null){
            return;
        }

        holder.imageView.setImageResource(contact.getImage());
        holder.textView.setText(contact.getName());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext,InfoActivity.class);
                intent.putExtra("image",mList.get(position).getImage());
                intent.putExtra("data",mList.get(position).getName());
                mContext.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        if (mList != null) {
            return mList.size();
        }
        return 0;
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;

        public ContactViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
            imageView = itemView.findViewById(R.id.profileImage);



        }


    }


}
