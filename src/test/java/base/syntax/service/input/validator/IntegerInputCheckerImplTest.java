package base.syntax.service.input.validator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import base.syntax.lib.Injector;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IntegerInputCheckerImplTest {
    public static final InputStream INPUT_STREAM = new ByteArrayInputStream("42\n".getBytes());
    public static final InputStream INPUT_STREAM_2 = new ByteArrayInputStream("12\n".getBytes());
    public static final InputStream EMPTY_STREAM = new ByteArrayInputStream("\n".getBytes());
    private static final Injector INJECTOR = Injector.getInjector();
    private static IntegerInputChecker INTEGER_INPUT_CHECKER;

    @BeforeEach
    public void setUp() {
        INTEGER_INPUT_CHECKER = (IntegerInputChecker) INJECTOR.getInstance(
                IntegerInputChecker.class);
    }

    @Test
    void getCorrectInteger_validInput_ok() {
        assertEquals("23", INTEGER_INPUT_CHECKER.getCorrectInteger("23", 3));
    }

    @Test
    void getCorrectInteger_skipValue_Option5_ok() {
        assertEquals("", INTEGER_INPUT_CHECKER.getCorrectInteger("", 5));
    }

    @Test
    void getCorrectInteger_skipValue_OptionNot5_ok() {
        System.setIn(INPUT_STREAM);
        assertEquals("42", INTEGER_INPUT_CHECKER.getCorrectInteger("", 3));
    }

    @Test
    void getCorrectInteger_nonNumeric_OptionNot5_ok() {
        System.setIn(INPUT_STREAM_2);
        assertEquals("12", INTEGER_INPUT_CHECKER.getCorrectInteger("mimi", 2));
    }

    @Test
    void getCorrectInteger_nonNumericValueSkip_Option5_ok() {
        System.setIn(EMPTY_STREAM);
        assertEquals("", INTEGER_INPUT_CHECKER.getCorrectInteger("gm", 5));
    }
}
