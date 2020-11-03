package student.uhasselt.be.view;

import student.uhasselt.be.model.BrowserModel;
import student.uhasselt.be.controller.BrowserController;
import student.uhasselt.be.controller.Controller;
import student.uhasselt.be.utils.BrowserHome;

import javax.swing.*;
import java.util.Observable;

public class PanelBar implements View {
    private JPanel topPanel;
    private JTextField textField;
    private JButton goToButton;
    private JButton previousButton;
    private JButton forwardButton;
    private Controller controller;

    PanelBar() {
        initComponents();
        topPanel.add(previousButton);
        topPanel.add(forwardButton);
        topPanel.add(textField);
        topPanel.add(goToButton);
    }

    JPanel getTopPanel() {
        return topPanel;
    }

    private void initComponents() {
        topPanel = new JPanel();
        textField = new JTextField();
        SwingUtilities.invokeLater(() -> textField.setText((BrowserHome.HOME_PATH)));
        goToButton = new JButton("GO");
        goToButton.addActionListener(e -> {
            ((BrowserController) controller).onGoTo(textField.getText());
        });
        previousButton = new JButton("<");
        previousButton.addActionListener(e -> {
            ((BrowserController) controller).onPrevious();
        });
        forwardButton = new JButton(">");
        forwardButton.addActionListener(e -> {
            ((BrowserController) controller).onForward();
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

    @Override
    public void update(Observable o, Object arg) {
        String currentPath = ((BrowserModel) arg).getUrl().toString();
        SwingUtilities.invokeLater(() -> textField.setText(currentPath));
    }
}
