package adven.crimeintent.model;

import java.util.Date;

import hugo.weaving.DebugLog;

@DebugLog
public class Crime {

    private String title;
    private boolean solved;
    private Date date;
    private int id;

    public Crime(int id, String title, Date date) {
        this.id = id;
        this.title = title;
        this.date = date;
    }

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
