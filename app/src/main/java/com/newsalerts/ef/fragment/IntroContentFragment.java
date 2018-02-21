package com.newsalerts.ef.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.newsalerts.ef.StartScreenActivity;
import com.newsalerts.ef.util.Prefs;
import com.newsalerts.ef.walkthrought.R;


public class IntroContentFragment extends Fragment {
    private TextView tvTitle;
    private TextView tvMsg;
    private TextView tvStart;
    private ImageView ivIcon;
    private Activity activity;
    private Prefs prefs;

    public IntroContentFragment() {
        // Required empty public constructor
    }

    public static IntroContentFragment newInstance(int position) {
        IntroContentFragment fragment = new IntroContentFragment();
        Bundle args = new Bundle();
        args.putInt("POSITION", position);;
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_intro_content, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        activity = getActivity();
        prefs = new Prefs(activity);
        tvTitle = (TextView) view.findViewById(R.id.txt_title);
        ivIcon  = (ImageView) view.findViewById(R.id.icon);
        tvMsg = (TextView) view.findViewById(R.id.tvMessage);
        tvStart = (TextView) view.findViewById(R.id.tvStart);
        tvStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prefs.setIntroShowed(true);
                Intent intent = new Intent(activity, StartScreenActivity.class);
                intent.putExtra(StartScreenActivity.REDIRECT_ACTIVTY, StartScreenActivity.REDIRECT_TO_HOME_SCREEN);
                startActivity(intent);
            }
        });


        switch (getArguments().getInt("POSITION")) {

            case 0:
                setDataToView(R.string.intro_slide1_title, R.drawable.cv_2,R.string.intro_slide1_title);
                tvStart.setVisibility(View.GONE);
                //       ((IndicatorVisibilityListener)activity).onChangeVisibility(0);
                break;
            case 1:
                setDataToView(R.string.intro_slide1_title, R.drawable.cv_2,R.string.intro_slide1_title);
                tvStart.setVisibility(View.GONE);
                //      ((IndicatorVisibilityListener)activity).onChangeVisibility(1);
                break;
            case 2:
                setDataToView(R.string.intro_slide1_title, R.drawable.cv_2,R.string.intro_slide1_title);
                tvStart.setVisibility(View.GONE);
                //    ((IndicatorVisibilityListener)activity).onChangeVisibility(2);
                break;
            case 3:
                setDataToView(R.string.intro_slide1_title, R.drawable.cv_2,R.string.intro_slide1_title);
                tvStart.setVisibility(View.GONE);
                //  ((IndicatorVisibilityListener)activity).onChangeVisibility(3);
                break;

            case 4:
                setDataToView(R.string.intro_slide1_title, R.drawable.cv_2,R.string.intro_slide1_title);
                tvStart.setVisibility(View.VISIBLE);
                // ((IndicatorVisibilityListener)activity).onChangeVisibility(4);
                break;

            default:
                break;
        }
    }

    private void setDataToView(int titleId, int drawableId,int msgId) {
        ivIcon.setImageResource(drawableId);
        tvTitle.setText(getActivity().getResources().getString(titleId));
        tvMsg.setText(getActivity().getResources().getString(msgId));

    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (Activity) context;

    }


    public interface IndicatorVisibilityListener{
        void onChangeVisibility(int position);
    }
}
