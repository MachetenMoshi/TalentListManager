package utils;

import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBasicCloseTransition;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.input.MouseEvent;

public class JFXHamburgerHelper {


    private HamburgerBasicCloseTransition burgerAnimationTask;
    private BooleanProperty               hamburgerStateAfterAnimation = new SimpleBooleanProperty();

    public JFXHamburgerHelper(BooleanProperty hamburgerStateProperty, JFXHamburger hamburger) {
        hamburgerStateAfterAnimation.set(hamburgerStateProperty.get());
        initialize(hamburger, hamburgerStateProperty.get());
        hamburgerStateProperty.addListener((obs, oldVal, newVal) -> updateHamburgerState(newVal));
    }

    private void initialize(JFXHamburger hamburger, boolean hamburgerStage) {
        burgerAnimationTask = new HamburgerBasicCloseTransition(hamburger);
        burgerAnimationTask.setRate(-1);

        if (!hamburgerStage) {
            burgerAnimationTask.setRate(burgerAnimationTask.getRate() * -1);
            burgerAnimationTask.play();
        }
        hamburger.addEventHandler(MouseEvent.MOUSE_PRESSED, (e) -> {
            burgerAnimationTask.setRate(burgerAnimationTask.getRate() * -1);
            burgerAnimationTask.play();
            reverseState();
        });
    }

    private void reverseState() {
        hamburgerStateAfterAnimation.set(!hamburgerStateAfterAnimation.get());
    }

    private void updateHamburgerState(Boolean newVal) {
        if (newVal != hamburgerStateAfterAnimation.get()) {
            burgerAnimationTask.setRate(burgerAnimationTask.getRate() * -1);
            burgerAnimationTask.play();
            reverseState();
        }
    }


    public final BooleanProperty hamburgerStateAfterAnimationProperty() {
        return this.hamburgerStateAfterAnimation;
    }


    public final boolean isHamburgerStateAfterAnimation() {
        return this.hamburgerStateAfterAnimationProperty().get();
    }


    public final void setHamburgerStateAfterAnimation(final boolean hamburgerStateAfterAnimation) {
        this.hamburgerStateAfterAnimationProperty().set(hamburgerStateAfterAnimation);
    }
}