package com.example.ammar.navigationdrawer.fragment;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ammar.navigationdrawer.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentJellyBean#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentJellyBean extends Fragment {

    private static final String KEY_MOVIE_TITLE = "key_title";

    public FragmentJellyBean() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment.
     *
     * @return A new instance of fragment FragmentJellyBean.
     */
    public static FragmentJellyBean newInstance(String movieTitle) {
        FragmentJellyBean fragmentThriller = new FragmentJellyBean();
        Bundle args = new Bundle();
        args.putString(KEY_MOVIE_TITLE, movieTitle);
        fragmentThriller.setArguments(args);

        return fragmentThriller;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_jellybean, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Drawable movieIcon = ResourcesCompat.getDrawable(getResources(), R.drawable.movie_icon, getContext().getTheme());
        if (movieIcon != null) {
            movieIcon.setColorFilter(ContextCompat.getColor(getContext(), R.color.orange), PorterDuff.Mode.SRC_ATOP);
        }

        String movieTitle = getArguments().getString(KEY_MOVIE_TITLE);
        ((TextView) view.findViewById(R.id.movie_title)).setText(movieTitle);
    }
}
