package base.syntax.menu;

import static org.junit.jupiter.api.Assertions.assertEquals;

import base.syntax.lib.Injector;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.Test;

class UserInterfaceImplTest {
    public static final InputStream INPUT_STREAM = new ByteArrayInputStream("3".getBytes());
    public static final InputStream INPUT_STREAM_INVALID = new ByteArrayInputStream(
            "124\n2\n".getBytes());
    private static final Injector INJECTOR = Injector.getInjector();
    private static final UserInterface USER_INTERFACE = (UserInterface) INJECTOR.getInstance(
            UserInterface.class);

    @Test
    void chooseAction_validAction_ok() {
        System.setIn(INPUT_STREAM);
        assertEquals(3, USER_INTERFACE.chooseAction());
    }

    @Test
    void chooseAction_invalidAction_ok() {
        System.setIn(INPUT_STREAM_INVALID);
        assertEquals(2, USER_INTERFACE.chooseAction());
    }
}
