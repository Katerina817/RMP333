package com.example.rmp333;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import com.example.rmp333.databinding.FragmentLinearLayoutBinding;

public class FragmentOnMainActivity extends Fragment {
    public FragmentOnMainActivity(){
        super(R.layout.fragment_linear_layout);
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Toast.makeText(requireContext(), "onCreate", Toast.LENGTH_LONG).show();
        Log.i("Fragment1","onCreate");
        getParentFragmentManager().setFragmentResultListener("requestKey", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle bundle) {
                String result = bundle.getString("bundleKey");
                Button button = requireView().findViewById(R.id.Knopka1);
                button.setText(result);
            }
        });
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Toast.makeText(requireContext(), "INITIALIZED(onCreateView)", Toast.LENGTH_LONG).show();
        Log.i("Fragment1","INITIALIZED(onCreateView)");
        return super.onCreateView(inflater, container, savedInstanceState);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Toast.makeText(requireContext(), "INITIALIZED(onViewCreated)", Toast.LENGTH_LONG).show();
        Log.i("Fragment1","INITIALIZED(onViewCreated)");

        /*FragmentLinearLayoutBinding binding = FragmentLinearLayoutBinding.inflate(getLayoutInflater());
        //Инициализация текстового компонента  троковым ресурсом
        binding.textView.setText(getString(R.string.my_name));

        //Инициализация компонента изображения ресурсом картинки
        binding.imageView1.setImageResource(R.drawable.ice_cream_svgrepo_com);
        //обработка нажатия на кнопку
        binding.mainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Fragment1", "Кнопка была нажата программным способом");
            }
        });*/

        //Без ViewBinding
        //Инициализация текстового компонента строковым ресурсом
        TextView textView = view.findViewById(R.id.textView);
        String welcomeString = getResources().getString(R.string.welcome_string);
        textView.setText(welcomeString);
        //Инициализация кнопки
        Button button = view.findViewById(R.id.mainButton);
        String myName=getResources().getString(R.string.my_name);
        button.setText(myName);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Fragment1","Кнопка была нажата программным способом");
                Intent intent = new Intent(requireContext(), SecondActivity.class);
                // передача объекта с ключом "hello" и значением "Hello World"
                intent.putExtra("hello", "Передача данных с переходом в новую активность");
                //startActivity(intent);
                mStartForResult.launch(intent);
            }
        });
        // Инициализация компонента картинки – ресурсом картинки
        ImageView imageView = view.findViewById(R.id.imageView1);
        imageView.setImageResource(R.drawable.ice_cream_svgrepo_com);
        // Инициализация EditText
        EditText editText = view.findViewById(R.id.editText);
        editText.setHint("Введите что-нибудь здесь!!!!!!!AAAAa");
    }
    //данные, полученные из второй активности с ее закрытием
    ActivityResultLauncher<Intent> mStartForResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        //Результат получен
                        Intent data = result.getData();
                        Toast.makeText(requireContext(), data.getStringExtra("key"), Toast.LENGTH_LONG).show();
                    }
                }
            });

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        Toast.makeText(requireContext(), "CREATED(onViewStateRestored)", Toast.LENGTH_LONG).show();
        Log.i("Fragment1","CREATED(onViewStateRestored)");
        super.onViewStateRestored(savedInstanceState);
    }
    @Override
    public void onStart() {
        Toast.makeText(requireContext(), "STARTED(onStart)", Toast.LENGTH_LONG).show();
        Log.i("Fragment1","STARTED(onStart)");
        super.onStart();
    }

    @Override
    public void onResume() {
        Toast.makeText(requireContext(), "RESUMED(onResume)", Toast.LENGTH_LONG).show();
        Log.i("Fragment1","RESUMED(onResume)");
        super.onResume();
    }

    @Override
    public void onPause() {
        Toast.makeText(requireContext(), "STARTED(onPause)", Toast.LENGTH_LONG).show();
        Log.i("Fragment1","STARTED(onPause)");
        super.onPause();
    }

    @Override
    public void onStop() {
        Toast.makeText(requireContext(), "CREATED(onStop)", Toast.LENGTH_LONG).show();
        Log.i("Fragment1","CREATED(onStop)");
        super.onStop();
    }
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        Toast.makeText(requireContext(), "CREATED(onSaveInstanceState)", Toast.LENGTH_LONG).show();
        Log.i("Fragment1","CREATED(onSaveInstanceState)");
        super.onSaveInstanceState(outState);
    }
    @Override
    public void onDestroyView() {
        Toast.makeText(requireContext(), "DESTROYED(onDestroyView)", Toast.LENGTH_LONG).show();
        Log.i("Fragment1","DESTROYED(onDestroyView)");
        super.onDestroyView();
    }
}


