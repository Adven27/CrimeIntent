package adven.crimeintent.model;

import hugo.weaving.DebugLog;

@DebugLog
public class Crime {

    private String title;
    private boolean solved;

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setSolved(boolean solved) {
        this.solved = solved;
    }

    public boolean isSolved() {
        return solved;
    }
}
