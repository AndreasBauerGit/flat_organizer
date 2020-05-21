package com.example.flat_organizer.ui.main;
import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.View.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import android.widget.Button;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.example.flat_organizer.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link F2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class F2 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public List<ImageDisplay> im_view_list = new ArrayList<ImageDisplay>();

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;




    public Button button;
    public Context context;
    public Activity activity;
    public ConstraintLayout cl;
    public View lv;
    public String test ="test";


    public int call_id;
    private int reqCode = 1; // when intent from start activitz extits, this int is automatically passed to onActivityResult
    // "identifies where the request comes from"
    Uri imageURI;
    ImageView imageView;


    public F2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment F2.
     */
    // TODO: Rename and change types and number of parameters
    public static F2 newInstance(String param1, String param2) {
        F2 fragment = new F2();
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
        View view = inflater.inflate(R.layout.f2, container, false);
        ConstraintLayout cl = view.findViewById(R.id.CL1);

        Button button = view.findViewById(R.id.button2);

        imageView = view.findViewById(R.id.imageView);

        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("button","second");
                openImage();
            }
        });
        try{
            URL eu = new URL("http://example.com/");
            ImageDisplay im_object = new ImageDisplay(eu, imageView);
            im_view_list.add(im_object);
        }
        catch (MalformedURLException e) {

        }





        //ImageDisplayButton im_button = new ImageDisplayButton(button, imageView, cl, view, getContext(), getActivity());

        return view;
    }




    private void openImage(){
        Intent intent = new Intent();
        intent.setData(Uri.parse("content://media/internal/images/media"));
        intent.setAction(Intent.ACTION_GET_CONTENT);
        Log.d("setImage","33");
        startActivityForResult(intent, reqCode);  //acitivity.startActivityForResult calls
        // the on Actitivty result method from main acitivity ?
        // just actitivty from
    }


    @Override
    public void onActivityResult(int requestCode,int resultCode, Intent data){
        Log.d("setImage","3388");
        super.onActivityResult(requestCode,requestCode,data); // whz is this here?

        // result_ok is standard code (-1) send when activity exited with good result
        if (requestCode == reqCode && resultCode == Activity.RESULT_OK){
            Log.d("setImage","success1");
            imageURI = data.getData();
            Log.d("setImage", imageURI.toString());
            imageView.setImageURI(imageURI);
            Log.d("setImage","success2");

        } else {
            Log.d("setImage","fail");
        }

    }

    // now make view movable and resiyeable


    //@Override
    //public void onActivityResult(int requestCode, int resultCode, Intent data){
    //    if (requestCode == ImageDisplayButton.call_id) {
            //TODO: action
     //   }
   // }



}
