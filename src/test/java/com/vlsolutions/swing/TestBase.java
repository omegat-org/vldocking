package com.vlsolutions.swing;

import com.vlsolutions.swing.sample.MySplitDockApp;
import org.assertj.swing.core.GenericTypeMatcher;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.junit.testcase.AssertJSwingJUnitTestCase;

import javax.swing.*;
import java.awt.*;

public class TestBase extends AssertJSwingJUnitTestCase {

    protected FrameFixture window;
    protected MySplitDockApp application;

    @Override
    protected void onSetUp() {
        application = GuiActionRunner.execute(() -> {
            MySplitDockApp frame = new MySplitDockApp();
            frame.setPreferredSize(new Dimension(800, 600));
            frame.setMinimumSize(new Dimension(800, 600));
            frame.validate();
            return frame;
        });
        window = new FrameFixture(robot(), application);
        window.show();
    }

    protected static class AutoHideButtonMatcher extends GenericTypeMatcher<JLabel> {
        private final String name;
        private final int index;
        private int count = 0;

        public AutoHideButtonMatcher(String name, int index) {
            super(JLabel.class);
            this.name = name;
            this.index = index;
        }

        @Override
        protected boolean isMatching(JLabel button) {
            return name.equals(button.getName()) && count++ == index;
        }
    }

    protected static class PanelMatcher extends GenericTypeMatcher<JPanel> {
        private final String name;
        private final int index;
        private int count = 0;

        public PanelMatcher(String name, int index) {
            super(JPanel.class);
            this.name = name;
            this.index = index;
        }

        @Override
        protected boolean isMatching(JPanel jPanel) {
            return name.equals(jPanel.getName()) && count++ == index;
        }
    }
}
