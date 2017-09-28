package com.londonappbrewery.destini;

import android.os.PersistableBundle;
import android.support.v4.app.NotificationCompatSideChannelService;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.value;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:

    Button   mTopButton;
    Button   mBottomButton;
    TextView mStoryTextView;

    int mStoryIndex = 0;
    int mTopButtonIndex = 0;
    int mBottomButtonIndex = 0;

    final int[] mStoryAns ={
            R.string.T1_Story,
            R.string.T2_Story,
            R.string.T3_Story,
            R.string.T4_End,
            R.string.T5_End,
            R.string.T6_End,
            R.string.Restart};

    final int[] mTopButtonAns    = {R.string.T1_Ans1,R.string.T2_Ans1,R.string.T3_Ans1};
    final int[] mBottomButtonAns = {R.string.T1_Ans2,R.string.T2_Ans2,R.string.T3_Ans2};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (savedInstanceState != null){
            mStoryIndex        = savedInstanceState.getInt("StoryIndex");
            mTopButtonIndex    = savedInstanceState.getInt("TopButtonIndex");
            mBottomButtonIndex = savedInstanceState.getInt("BottomButtonIndex");

        }
        else {
            mStoryIndex        = 0;
            mTopButtonIndex    = 0;
            mBottomButtonIndex = 0;
        }


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mTopButton     = (Button)   findViewById(R.id.buttonTop);
        mBottomButton  = (Button)   findViewById(R.id.buttonBottom);
        mStoryTextView = (TextView) findViewById(R.id.storyTextView);

        mStoryTextView.setText(mStoryAns[mStoryIndex]);
        mTopButton.setText(mTopButtonAns[mTopButtonIndex]);
        mBottomButton.setText(mBottomButtonAns[mBottomButtonIndex]);

        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:

        mTopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String CheckButtonText = mTopButton.getText().toString();

               if ( CheckButtonText.equalsIgnoreCase("Start Again")){
                   mStoryIndex        = 0;
                   mTopButtonIndex    = 0;
                   mBottomButtonIndex = 0;

                   mStoryTextView.setText(mStoryAns[0]);
                   mTopButton.setText(mTopButtonAns[0]);
                   mBottomButton.setText(mBottomButtonAns[0]);
                   mBottomButton.setVisibility(View.VISIBLE);
               }
               else
                  SelectTopButtonStory(mStoryIndex);
            }
        });


        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mBottomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SelectBottomButtonStory(mStoryIndex);
            }
        });

    }

    private  void SelectTopButtonStory ( int storyIndex ) {

        switch (storyIndex) {
            case 0:
                mStoryIndex        = 2;
                mTopButtonIndex    = 2;
                mBottomButtonIndex = 2;
                break;
            case 1:
                mStoryIndex        = 2;
                mTopButtonIndex    = 2;
                mBottomButtonIndex = 2;
                break;

            case 2:
                mStoryIndex = 5;
                mStoryTextView.setText(mStoryAns[mStoryIndex]);
                mTopButton.setText(mStoryAns[6]);
                mBottomButton.setVisibility(View.GONE);
                break;
        }

        if (mStoryIndex != 5) {
            mStoryTextView.setText(mStoryAns[mStoryIndex]);
            mTopButton.setText(mTopButtonAns[mTopButtonIndex]);
            mBottomButton.setText(mBottomButtonAns[mBottomButtonIndex]);
        }
    }

    private  void SelectBottomButtonStory ( int storyIndex ){

        switch (storyIndex) {
            case 0:
                mStoryIndex        = 1;
                mTopButtonIndex    = 1;
                mBottomButtonIndex = 1;

                mStoryTextView.setText(mStoryAns[mStoryIndex]);
                mTopButton.setText(mTopButtonAns[mTopButtonIndex]);
                mBottomButton.setText(mBottomButtonAns[mBottomButtonIndex]);

                break;
            case 1:
                mStoryIndex        = 3;
                mStoryTextView.setText(mStoryAns[mStoryIndex]);
                mTopButton.setText(mStoryAns[6]);
                mBottomButton.setVisibility(View.GONE);
                break;
            case 2:
                mStoryIndex        = 4;
                mStoryTextView.setText(mStoryAns[mStoryIndex]);
                mTopButton.setText(mStoryAns[6]);
                mBottomButton.setVisibility(View.GONE);
                break;
        }

    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putInt("StoryIndex",mStoryIndex);
        outState.putInt("TopButtonIndex",mTopButtonIndex);
        outState.putInt("BottomButtonIndex",mBottomButtonIndex);
    }
}
