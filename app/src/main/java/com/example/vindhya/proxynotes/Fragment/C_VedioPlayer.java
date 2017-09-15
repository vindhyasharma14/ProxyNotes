package com.example.vindhya.proxynotes.Fragment;


import android.app.ProgressDialog;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.vindhya.proxynotes.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class C_VedioPlayer extends Fragment {

    private static ProgressDialog progressDialog;
    String tit, videoPath;
    MediaController mediacontroller;
    String videourl;
    VideoView videoview;

    ProgressDialog pDialog;
    TextView title, url;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        ;
        super.onCreate(savedInstanceState);

        Bundle bundle = this.getArguments();
        if (bundle != null) {
            tit = bundle.getString("title");
            videoPath = bundle.getString("url");

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.c_vedio_player_frag, container, false);

        title = view.findViewById(R.id.titleId);
        title.setText(tit);
        url = view.findViewById(R.id.urlId);
        url.setText(videoPath);

        videoview = (VideoView) view.findViewById(R.id.VideoView);
        // Execute StreamVideo AsyncTask

        // Create a progressbar
        pDialog = new ProgressDialog(getActivity());
        // Set progressbar title
        pDialog.setTitle(tit);
        // Set progressbar message
        pDialog.setMessage("Buffering...");
        //  pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        // Show progressbar
        pDialog.show();

        try {
            // Start the MediaController
            mediacontroller = new MediaController(
                    getActivity());
            mediacontroller.setAnchorView(videoview);
            // Get the URL from String VideoURL
            Uri video = Uri.parse(videoPath);
            videoview.setMediaController(mediacontroller);
            videoview.setVideoURI(video);

        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }

        //videoview.requestFocus();
        videoview.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            // Close the progress bar and play the video
            public void onPrepared(MediaPlayer mp) {
                pDialog.dismiss();
                videoview.start();
                mediacontroller.show(0);
            }
        });


        return view;
    }


}
