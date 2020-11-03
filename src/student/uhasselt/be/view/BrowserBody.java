package student.uhasselt.be.view;

import student.uhasselt.be.model.BrowserModel;
import student.uhasselt.be.controller.Controller;
import student.uhasselt.be.utils.BrowserHome;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.Observable;

public class BrowserBody implements View {
    private JEditorPane editor;
    private Controller controller;

    public BrowserBody() {
        try {
            editor = new JEditorPane(new URL(BrowserHome.HOME_PATH));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    JEditorPane getBody() {
        return editor;
    }

    @Override
    public void update(Observable o, Object arg) {
        URL url = ((BrowserModel) arg).getUrl();
        SwingUtilities.invokeLater(() -> {
            try {
                editor.setPage(url);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public void setController(Controller c) {
        if (controller == null) {
            controller = c;
            controller.getModel().addObserver(this);
        }
    }

    @Override
    public Controller getController() {
        return controller;
    }
}
