package base.syntax.service.input.validator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import base.syntax.lib.Injector;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StringInputCheckerImplTest {
    public static final InputStream INPUT_STREAM = new ByteArrayInputStream("Ferrari\n".getBytes());
    public static final InputStream INPUT_STREAM_2 = new ByteArrayInputStream("MAN\n".getBytes());
    public static final InputStream EMPTY_STREAM = new ByteArrayInputStream("\n".getBytes());
    private static final Injector INJECTOR = Injector.getInjector();
    private static StringInputChecker STRING_INPUT_CHECKER;

    @BeforeEach
    public void setUp() {
        STRING_INPUT_CHECKER = (StringInputChecker) INJECTOR.getInstance(StringInputChecker.class);
    }

    @Test
    void getCorrectString_validInput_ok() {
        assertEquals("color", STRING_INPUT_CHECKER.getCorrectString("color", 3));
    }

    @Test
    void getCorrectString_skipValue_Option5_ok() {
        assertEquals("", STRING_INPUT_CHECKER.getCorrectString("", 5));
    }

    @Test
    void getCorrectString_skipValue_OptionNot5_ok() {
        System.setIn(INPUT_STREAM);
        assertEquals("Ferrari", STRING_INPUT_CHECKER.getCorrectString("", 3));
    }

    @Test
    void getCorrectString_badValue_OptionNot5_ok() {
        System.setIn(INPUT_STREAM_2);
        assertEquals("MAN", STRING_INPUT_CHECKER.getCorrectString("fd#2!433", 2));
    }

    @Test
    void getCorrectString_NumericValueSkip_Option5_ok() {
        System.setIn(EMPTY_STREAM);
        assertEquals("", STRING_INPUT_CHECKER.getCorrectString("33", 5));
    }
}
