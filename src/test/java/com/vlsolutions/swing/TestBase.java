package com.vlsolutions.swing;

import org.assertj.swing.core.GenericTypeMatcher;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.junit.testcase.AssertJSwingJUnitTestCase;

import javax.swing.*;
import java.awt.*;

public abstract class TestBase extends AssertJSwingJUnitTestCase {

    protected FrameFixture window;
    protected JFrame application;

    @Override
    protected void onSetUp() {
        application = GuiActionRunner.execute(this::createApplication);
        window = new FrameFixture(robot(), application);
        window.show();
        startApplication();
    }

    protected abstract JFrame createApplication();

    protected abstract void startApplication();

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
