package ekordik.cuw.edu.towersofhanoiclass;

import android.view.View;

/**
 * Created by emmakordik on 3/5/17.
 */

public class Disk {
    private int size;
    private Disk nextDisc;
    private View view;

    public Disk(int size, View view) {
        this.size = size;
        this.view = view;
        this.nextDisc = null;
    }

    public Disk getNextDisc() {
        return nextDisc;
    }

    public void setNextDisc(Disk nextDisc) {
        this.nextDisc = nextDisc;
    }

    public int getSize() {
        return size;
    }


}
