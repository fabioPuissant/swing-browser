package student.uhasselt.be.view;

import student.uhasselt.be.controller.Controller;
import java.util.Observer;

public interface View extends Observer {
    void setController(Controller c);

    Controller getController();
}
