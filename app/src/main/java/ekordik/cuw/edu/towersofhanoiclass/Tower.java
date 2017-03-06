package ekordik.cuw.edu.towersofhanoiclass;

/**
 * Created by emmakordik on 3/5/17.
 */

public class Tower {
    private Disk top;
    private int count;

    public Tower() {
        this.top = null;
        count = 0;
    }

    public boolean push(Disk d) {
        if(this.top == null) {
            this.top = d;
            this.count++;
            return true;
        } else {
            if(top.getSize() > d.getSize()) {
                d.setNextDisc(top);
                this.top = d;
                this.count++;
                return true;
            }
        }
        return false;
    }

    public Disk pop(){
        Disk curTop = top;
        if(this.top != null) {
            top = top.getNextDisc();
            curTop.setNextDisc(null);
            this.count--;
        }
        return curTop;
    }

    public int getCount() {
        return this.count;
    }

}

