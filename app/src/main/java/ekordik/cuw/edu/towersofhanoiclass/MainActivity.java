package ekordik.cuw.edu.towersofhanoiclass;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ViewGroup stagingArea;
    private ViewGroup layoutTower0; //vertical linear layout
    private ViewGroup layoutTower1; //vertical linear layout
    private ViewGroup layoutTower2; //vertical linear layout
    private Tower[] towers;
    private Disk stagedDisk;
    private AlertDialog winningDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.stagingArea = (ViewGroup)this.findViewById(R.id.llStagingArea);
        this.layoutTower0 = (ViewGroup)this.findViewById(R.id.lltower0);
        this.layoutTower1 = (ViewGroup)this.findViewById(R.id.lltower1);
        this.layoutTower2 = (ViewGroup)this.findViewById(R.id.lltower2);
        towers = new Tower[3];
        this.intializeTowers();

        //Initialize AlertDialog for winning message
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("You won! Congratulations!");
        builder.setPositiveButton("Play Again?", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                intializeGame();
            }
        });

        builder.setNegativeButton("Stop Playing", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Thanks for playing", Toast.LENGTH_SHORT).show();
            }
        });
        winningDialog = builder.create();
    }

    public void tower0ButtonPressed(View view) {
        this.move(0, layoutTower0);
    }

    public void tower1ButtonPressed(View view) {
        this.move(1, layoutTower1);
    }

    public void tower2ButtonPressed(View view) {
        this.move(2, layoutTower2);
    }

    private void move(int towerInx, ViewGroup layout) {
        if(this.stagedDisk == null) {
            if(layout.getChildCount() > 0 && towers[towerInx].getCount() > 0) {
                this.stagedDisk = towers[towerInx].pop();
                View temp = layout.getChildAt(0);
                layout.removeViewAt(0);
                stagingArea.addView(temp);
            }
        } else {
            if(towers[towerInx].push(stagedDisk)) {
                View temp = this.stagingArea.getChildAt(0);
                this.stagingArea.removeViewAt(0);
                layout.addView(temp, 0);
                this.stagedDisk = null;
                if(checkForWin()) {
                    this.winningDialog.show();
                }
            } else {
                Toast.makeText(MainActivity.this, "Invalid Move", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private boolean checkForWin() {
        if(this.towers[2].getCount() == 3) {
            return true;
        }
        return false;
    }

    private void intializeGame() {
        this.intializeTowers();
        View temp = this.findViewById(R.id.txt0);
        this.layoutTower2.removeView(temp);
        this.layoutTower0.addView(temp);
        temp = this.findViewById(R.id.txt1);
        this.layoutTower2.removeView(temp);
        this.layoutTower0.addView(temp);
        temp = this.findViewById(R.id.txt2);
        this.layoutTower2.removeView(temp);
        this.layoutTower0.addView(temp);
    }

    private void intializeTowers() {
        for(int i = 0; i < towers.length; i++) {
            this.towers[i] = new Tower();
        }
        this.towers[0].push(new Disk(3, (View)this.findViewById(R.id.txt2)));
        this.towers[0].push(new Disk(2, (View)this.findViewById(R.id.txt1)));
        this.towers[0].push(new Disk(1, (View)this.findViewById(R.id.txt0)));
    }
}
