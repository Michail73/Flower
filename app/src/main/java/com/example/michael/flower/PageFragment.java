package com.example.michael.flower;

import java.util.Random;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class PageFragment extends Fragment {

    static final String ARGUMENT_PAGE_NUMBER = "arg_page_number";

    int pageNumber; // показывает в консоли номер страницы
    int backColor;
    Button mButton;
    static PageFragment newInstance(int page) {
        PageFragment pageFragment = new PageFragment();
        Bundle arguments = new Bundle();
        arguments.putInt(ARGUMENT_PAGE_NUMBER, page);
        pageFragment.setArguments(arguments);
        return pageFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageNumber = getArguments().getInt(ARGUMENT_PAGE_NUMBER);

        Random rnd = new Random();
        backColor = Color.argb(40, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment, null);


            mButton = (Button) view.findViewById(R.id.start);
        View.OnClickListener OclStartBtn = new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getActivity(), Catalog.class);
                    startActivity(intent);
                }
            };
        // comment for same changes :(
        mButton.setOnClickListener(OclStartBtn);

        TextView tvPage = (TextView) view.findViewById(R.id.tvPage);
        ImageView im = (ImageView) view.findViewById(R.id.icon);
        switch (pageNumber){
            case 0:
                tvPage.setText(R.string.first);
                mButton.setVisibility(View.GONE);
                im.setImageResource(R.drawable.first);
                break;
            case 1:
                im.setImageResource(R.drawable.second);
                mButton.setVisibility(View.GONE);
                tvPage.setText(R.string.sec);
                break;
            case 2:
                im.setImageResource(R.drawable.tri);
                tvPage.setText(R.string.third);
                mButton.setVisibility(View.VISIBLE);
                break;
        }
        return view;
    }
}