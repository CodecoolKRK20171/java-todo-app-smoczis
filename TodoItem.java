/**
 * Class representing a single todo item.
 *
 */
public class TodoItem{
    private String description;
    private Boolean isMarked;

    public TodoItem(String description)
    {
        this.description = description;
        this.isMarked = false;
    }

    public TodoItem()
    {
        this.description = "";
        this.isMarked = false;
    }

    public String getDescription()
    {
        return this.description;
    }

    public Boolean checkIsMarked()
    {
        return this.isMarked;
    }

    public String toString()
    {
        String result = "";
        String mark = " ";
        if(this.isMarked) mark = "x";
        result += "[" + mark + "] " + this.description;
        return result;
    }
    public void mark()
    {
        this.isMarked = true;
    }

    public void unmark()
    {
        this.isMarked = false;
    }


}
