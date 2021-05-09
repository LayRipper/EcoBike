package base.syntax.menu.options.file.writer;

import static org.junit.jupiter.api.Assertions.assertThrows;

import base.syntax.lib.Injector;
import org.junit.jupiter.api.Test;

class AutoSaveImplTest {
    private static final Injector INJECTOR = Injector.getInjector();
    private static final AutoSave AUTO_SAVE = (AutoSave) INJECTOR.getInstance(AutoSave.class);

    @Test
    void executeQuery_nonexistentFilePath_notOk() {
        assertThrows(RuntimeException.class,
                () -> AUTO_SAVE.executeQuery("", "/fsa /ss/String.exe"));
    }
}
