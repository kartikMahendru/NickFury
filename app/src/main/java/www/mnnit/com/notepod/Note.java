package www.mnnit.com.notepod;

/**
 * Created by jatin_jt_narula on 21/12/17.
 */

import android.database.Cursor;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import www.mnnit.com.notepod.utilities.Constants;
public class Note {
    private Long id;
    private String title;
    private String content;
    private Calendar dateCreated;
    private Calendar dataModified;

    public String getReadableModifiedDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy - h:mm a", Locale.getDefault());
        sdf.setTimeZone(getDataModified().getTimeZone());
        Date modifiedDate = getDataModified().getTime();
        String displayDate = sdf.format(modifiedDate);
        return displayDate;
    }

    public static Note getNotefromCursor(Cursor cursor){
        Note note = new Note();
        note.setId(cursor.getLong(cursor.getColumnIndex(Constants.COLUMN_ID)));
        note.setTitle(cursor.getString(cursor.getColumnIndex(Constants.COLUMN_TITLE)));
        note.setContent(cursor.getString(cursor.getColumnIndex(Constants.COLUMN_CONTENT)));

        //get Calendar instance
        Calendar calendar = GregorianCalendar.getInstance();

        //set the calendar time to date created
        calendar.setTimeInMillis(cursor.getLong(cursor.getColumnIndex(Constants.COLUMN_CREATED_TIME)));
        note.setDateCreated(calendar);

        //set the calendar time to date modified
        calendar.setTimeInMillis(cursor.getLong(cursor.getColumnIndex(Constants.COLUMN_MODIFIED_TIME)));
        note.setDataModified(calendar);
        return note;
    }




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Calendar getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Calendar dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Calendar getDataModified() {
        return dataModified;
    }

    public void setDataModified(Calendar dataModified) {
        this.dataModified = dataModified;
    }
}
