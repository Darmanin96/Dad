package dad.misamigos.model;

import javafx.beans.*;
import javafx.beans.property.*;
import javafx.collections.*;

public class FriendList extends SimpleListProperty<Friend> {
    public FriendList(){
        super(FXCollections.observableArrayList());
    }
}
