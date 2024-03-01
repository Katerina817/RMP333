package com.example.rmp333;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentOnSecondActivity extends Fragment {
    public FragmentOnSecondActivity(){
        super(R.layout.fragment_absolute_layout);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Button button = requireView().findViewById(R.id.Knopka2);
        /*button.setOnClickListener(new View.OnClickListener() {
            @Override//передача данных между двумя фрагментами(добавить в одну активность)
            public void onClick(View v) {
                Bundle result = new Bundle();
                result.putString("bundleKey", "данные получены");
                getParentFragmentManager().setFragmentResult("requestKey", result);
            }
        });*/
        //String name = getArguments().getString("hello");
        String name = getActivity().getIntent().getExtras().get("hello").toString();
        button.setText(name);//получение данных из первой активности

        Button button1 = requireView().findViewById(R.id.Knopochka);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override//отправка данных обратно
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("key", "value");
                requireActivity().setResult(Activity.RESULT_OK, resultIntent);
                requireActivity().finish();
            }
        });
        super.onViewCreated(view, savedInstanceState);
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
