package fi.tuni.monitor.mainwindow;

import javafx.scene.control.ToggleButton;

/**
 * A custom toggle button that acts like a radio button.
 */
public class RadioToggleButton extends ToggleButton
{
    /**
     * Overridden default fire method to prevent the button from being unchecked
     */
    @Override
    public void fire()
    {
        // disallow deselection
        if (!isSelected())
            super.fire();
    }
}
