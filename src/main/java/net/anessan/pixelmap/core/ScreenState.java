package net.anessan.pixelmap.core;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

public class ScreenState<T> {
    private final BiConsumer<State<T>, State<T>> onChangedState;

    /**
     * Meant to declare anonymous classes.
     */
    public interface State<T> {
        void onEnterState(T screen);

        void onExitState(T screen);
    }

    public ScreenState(BiConsumer<State<T>, State<T>> onChangedState) {
        this.onChangedState = onChangedState;
    }

    public ScreenState() {
        this.onChangedState = null;
    }

    private volatile State<T> currentState;

    public State<T> current() {
        return currentState;
    }

    public boolean is(State<T> state) {
        return current() == state;
    }

    public void switchTo(State<T> state, T screen) {
        if (currentState != null) {
            currentState.onExitState(screen);
        }
        if (onChangedState != null) onChangedState.accept(currentState, state);
        currentState = state;
        if (state != null) {
            state.onEnterState(screen);
        }
    }
}
