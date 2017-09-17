package core.logger;

import core.logger.base.CoreBaseLogger;

import javax.swing.*;
import java.awt.*;

public class CoreLoggerConsol extends CoreBaseLogger {
    JFrame frame;
    JTextArea area;
    JButton button;

    public CoreLoggerConsol() {
        this.frame = new JFrame();
        this.area = new JTextArea();
        this.button = new JButton("CLEAR");
        area.setPreferredSize(new Dimension(200, 200));
        area.setEditable(false);

        area.setText("Click me to show dialog!");
        frame.add(this.button);
        frame.add(area);
        frame.pack();
        frame.setVisible(true);
        button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

            }
        });

    }

    @Override
    protected void addLogEntry(String message) {
        this.area.setText(this.area.getText() + this.createEntryFrom(message));
    }
}
