package intelligenttodo.ali.com.data;

import nl.qbusict.cupboard.annotation.Column;

public class Todo {
    private long _id;
    @Column("title")
    private String mTitle;
    @Column("description")
    private String mDescription;
    @Column("date_added")
    private String mDateAdded;
    @Column("todo_at")
    private String mTodoAt;
    @Column("expiry_date")
    private String mExpiryDate;
    @Column("priority")
    private int mPriority;
    @Column("color_id")
    private int mColorId;
    @Column("color_id")
    private int mStatus;

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public String getDateAdded() {
        return mDateAdded;
    }

    public void setDateAdded(String mDateAdded) {
        this.mDateAdded = mDateAdded;
    }

    public String getTodoAt() {
        return mTodoAt;
    }

    public void setTodoAt(String mTodoAt) {
        this.mTodoAt = mTodoAt;
    }

    public String getExpiryDate() {
        return mExpiryDate;
    }

    public void setExpiryDate(String mExpiryDate) {
        this.mExpiryDate = mExpiryDate;
    }

    public int getPriority() {
        return mPriority;
    }

    public void setPriority(int mPriority) {
        this.mPriority = mPriority;
    }

    public int getColorId() {
        return mColorId;
    }

    public void setColorId(int mcolorId) {
        this.mColorId = mcolorId;
    }

    public int getStatus() {
        return mStatus;
    }

    public void setStatus(int mStatus) {
        this.mStatus = mStatus;
    }
}
