package ekordik.cuw.edu.towersofhanoiclass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity {
    private ViewGroup stagingArea;
    private ViewGroup tower0; //vertical linear layout
    private ViewGroup tower1; //vertical linear layout
    private ViewGroup tower2; //vertical linear layout
    private String currMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.stagingArea = (ViewGroup)this.findViewById(R.id.llStagingArea);
        this.tower0 = (ViewGroup)this.findViewById(R.id.lltower0);
        this.tower1 = (ViewGroup)this.findViewById(R.id.lltower1);
        this.tower2 = (ViewGroup)this.findViewById(R.id.lltower2);
        this.currMode = "SRC";

    }

    public void tower0ButtonPressed(View view) {
        if(this.currMode == "SRC") {
            if(this.tower0.getChildCount() > 0) {
                View temp = this.tower0.getChildAt(0);
                this.tower0.removeViewAt(0);
                stagingArea.addView(temp);
                this.currMode = "DEST";
            }
        } else {
            View temp = this.stagingArea.getChildAt(0);
            this.stagingArea.removeViewAt(0);
            this.tower0.addView(temp, 0);
            this.currMode = "SRC";
        }

    }

    public void tower1ButtonPressed(View view) {
        if(this.currMode == "SRC") {
            if (this.tower1.getChildCount() > 0) {
                View temp = this.tower1.getChildAt(0);
                this.tower1.removeViewAt(0);
                stagingArea.addView(temp);
                this.currMode = "DEST";
            }
        } else {
            View temp = this.stagingArea.getChildAt(0);
            this.stagingArea.removeViewAt(0);
            this.tower1.addView(temp, 0);
            this.currMode = "SRC";
        }

    }

    public void tower2ButtonPressed(View view) {
        if(this.currMode == "SRC") {
            if (this.tower2.getChildCount() > 0) {
                View temp = this.tower2.getChildAt(0);
                this.tower2.removeViewAt(0);
                stagingArea.addView(temp);
                this.currMode = "DEST";
            }
        } else {
            View temp = this.stagingArea.getChildAt(0);
            this.stagingArea.removeViewAt(0);
            this.tower2.addView(temp, 0);
            this.currMode = "SRC";
        }

    }
}
