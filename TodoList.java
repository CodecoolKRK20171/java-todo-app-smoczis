/**
 * Class representing a todo list.
 * TodoList object should aggregate TodoItem objects.
 */

import java.util.ArrayList;

public class TodoList{

    private ArrayList<TodoItem> itemList;

    public TodoList()
    {
        this.itemList = new ArrayList<TodoItem>();
    }

    public Integer getListSize()
    {
        return itemList.size();
    }

    public TodoItem getItem(int idx)
    {
        return itemList.get(idx);
    }
    public void listTasks()
    {
        for(TodoItem item : itemList)
        {
            System.out.println(item.toString());
        }
    }

    public void archiveTasks()
    {
        for(int i = 0; i<itemList.size(); i++)
        {
            TodoItem elem = new TodoItem();
            elem = itemList.get(i);
            if(elem.checkIsMarked())
                itemList.remove(i);
        }
    }

    public void addItem(TodoItem item)
    {
        this.itemList.add(item);
    }

    public void deleteItem(Integer elemIdx)
    {
        for(TodoItem item : itemList)
        {
            if(elemIdx == itemList.indexOf(item))
                item.mark();
        }
    }

}
