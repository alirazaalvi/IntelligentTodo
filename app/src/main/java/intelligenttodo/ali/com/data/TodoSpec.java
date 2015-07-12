package intelligenttodo.ali.com.data;

import com.yahoo.squidb.annotations.ColumnSpec;
import com.yahoo.squidb.annotations.PrimaryKey;
import com.yahoo.squidb.annotations.TableModelSpec;

@TableModelSpec(className = "Todo", tableName = "todo")
public class TodoSpec {
    @PrimaryKey(autoincrement = true)
    private Long id;
    @ColumnSpec(name = "title")
    private String title;
    @ColumnSpec(name = "description")
    private String description;
    @ColumnSpec(name = "date_added")
    private String dateAdded;
    @ColumnSpec(name = "todo_at")
    private String todoAt;
    @ColumnSpec(name = "expiry_date")
    private String expiryDate;
    @ColumnSpec(name = "priority")
    private int priority;
    @ColumnSpec(name = "status")
    private int status;
}
