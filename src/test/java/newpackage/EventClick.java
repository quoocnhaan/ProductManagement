package newpackage;

import java.awt.Component;

public interface EventClick {

    public void itemClick(DataSearch data);

    public void itemRemove(Component com, DataSearch data);
    
    void itemHover(DataSearch data); // New method for hover event
}
