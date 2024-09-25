package com.vlsolutions.swing.sample;

import com.vlsolutions.swing.docking.DockKey;
import com.vlsolutions.swing.docking.Dockable;

import javax.swing.*;
import java.awt.*;

public class MyTextEditor extends JPanel implements Dockable {
    DockKey key = new DockKey("textEditor");
    JTextArea textArea = new JTextArea("A Text Area");

    public MyTextEditor() {
        setName("myTextEditorPanel");
        setLayout(new BorderLayout());
        textArea.setName("myTextEditorTextArea");
        DockableScrollPane jsp = new DockableScrollPane(textArea);
        jsp.setName("myTextEditorScrollPane");
        jsp.setPreferredSize(new Dimension(300, 400));
        add(jsp, BorderLayout.CENTER);
        key.setName("The Text Area");
        key.setCloseEnabled(false);
        key.setMaximizeEnabled(false);
        key.setAutoHideEnabled(false);
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
