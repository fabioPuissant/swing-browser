package student.uhasselt.be.controller;

import student.uhasselt.be.model.BrowserModel;
import student.uhasselt.be.utils.BrowserHome;
import student.uhasselt.be.view.BrowserGui;
import student.uhasselt.be.view.PanelBar;
import student.uhasselt.be.view.View;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;


public class BrowserController implements Controller {
    private List<String> browserHistory;
    private int currentPathIndex;
    private Observable model;

    public BrowserController() {
        browserHistory = new ArrayList<>();
        browserHistory.add(BrowserHome.HOME_PATH);
        currentPathIndex = 0;
    }

    public void onForward() {
        if (currentPathIndex < browserHistory.size() - 1) {
            currentPathIndex += 1;
            onGoTo(browserHistory.get(currentPathIndex));
            System.out.println("Go Back");
        }
    }

    public void onGoTo(String path) {
        try {
            ((BrowserModel) model).setUrl(new URL(path));
            if (currentPathIndex == browserHistory.size() - 1) {
                currentPathIndex +=1;
                browserHistory.add(path);
            }
        } catch (MalformedURLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void onPrevious() {
        if (currentPathIndex > 0) {
            currentPathIndex -= 1;
            onGoTo(browserHistory.get(currentPathIndex));
            System.out.println("Go Back");
        }
    }

    @Override
    public void setModel(Observable model) throws Exception {
        if (!(model instanceof BrowserModel)) {
            throw new Exception("Not the right kind of observable");
        }
        if (getModel() != null) {
            throw new Exception("Model already set");
        }
        this.model = model;
    }

    @Override
    public Observable getModel() {
        return model;
    }
}
