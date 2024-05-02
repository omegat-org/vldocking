package com.vlsolutions.swing.sample;

import com.vlsolutions.swing.docking.DockKey;
import com.vlsolutions.swing.docking.Dockable;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class MyTextEditor extends JPanel implements Dockable {
    DockKey key = new DockKey("textEditor");
    JTextArea textArea = new JTextArea("A Text Area");

    public MyTextEditor() {
        setName("myTextEditorPanel");
        setLayout(new BorderLayout());
        textArea.setName("myTextEditorTextArea");
        JScrollPane jsp = new JScrollPane(textArea);
        jsp.setName("myTextEditorScrollPane");
        jsp.setPreferredSize(new Dimension(300, 400));
        add(jsp, BorderLayout.CENTER);
        key.setName("The Text Area");
        key.setTooltip("This is the text area tooltip");
        key.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("textArea16.png"))));
        // turn off autohide, maximize and close features
        key.setCloseEnabled(false);
        key.setAutoHideEnabled(false);
        key.setMaximizeEnabled(false);
    }

    @Override
    public DockKey getDockKey() {
        return key;
    }

    @Override
    public Component getComponent() {
        return this;
    }
}
