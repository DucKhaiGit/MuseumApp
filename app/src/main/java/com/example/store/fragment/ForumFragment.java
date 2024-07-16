package com.example.store.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.store.Item;
import com.example.store.ItemAdapter;
import com.example.store.R;

import java.util.ArrayList;
import java.util.List;


public class ForumFragment extends Fragment {

   private RecyclerView rcvData;
   private ItemAdapter itemAdapter;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    public ForumFragment() {

    }


    // TODO: Rename and change types and number of parameters
    public static ForumFragment newInstance(String param1, String param2) {
        ForumFragment fragment = new ForumFragment();
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
        View view = inflater.inflate(R.layout.fragment_forum, container, false);

        rcvData = view.findViewById(R.id.rcv_data);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        rcvData.setLayoutManager(linearLayoutManager);

        itemAdapter = new ItemAdapter(getListItem(),getContext());
        rcvData.setAdapter(itemAdapter);

        return view;
    }

    private List<Item> getListItem() {
        List<Item> list = new ArrayList<>();
        list.add(new Item(R.drawable.batcom,"Bát cổ chạm khắc đầu rồng","Một vật dụng cổ đại được sản xuất thủ công thật tỉ mỉ"));
        list.add(new Item(R.drawable.dai_minh_vinh_lac_kiem,"Độc cô cửu kiếm","Vũ khí thời cổ đại"));
        list.add(new Item(R.drawable.khung_long,"Hóa thạch khủng long","Một bộ xương hóa thạch nguyên vẹn"));
        list.add(new Item(R.drawable.matna,"Mặt nạ thủ lam ngư","Bộ mặt nạ được cổ nhân chế tác tinh diệu từ da cá sấu"));
        list.add(new Item(R.drawable.trongcoloa,"Trống đồng","Nhạc cụ cổ đại"));
        list.add(new Item(R.drawable.tuongda,"Tượng thần","Một bức tượng tín ngưỡng thời xưa"));
        return list;

    }
}