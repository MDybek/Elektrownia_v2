package com.company.GUI.ElektrownieOkno;

import javax.swing.*;
import java.awt.*;
public class OknoFrame{

    public static JPanel mainPanel;
    public static JFrame frame;

    public OknoFrame(){
        frame = new JFrame();
        frame.setTitle("Okno elektrowni");
        mainPanel = new JPanel();
        mainPanel.setPreferredSize(new Dimension(900,600));
        frame.setLayout(new GridLayout());
        frame.setResizable(false);
        frame.setVisible(false);
        frame.add(mainPanel);
        frame.pack();
    }

}