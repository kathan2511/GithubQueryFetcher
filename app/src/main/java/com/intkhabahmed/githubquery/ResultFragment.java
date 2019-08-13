package com.intkhabahmed.githubquery;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ResultFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_result, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String result = getArguments().getString("result");
        String url = getArguments().getString("url");
        TextView urlTextView = view.findViewById(R.id.url_tv);
        TextView resultTextView = view.findViewById(R.id.result_tv);

        urlTextView.setText(url);
        resultTextView.setText(result);
    }
}
