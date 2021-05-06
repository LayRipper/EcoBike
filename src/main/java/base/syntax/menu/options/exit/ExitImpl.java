package base.syntax.menu.options.exit;

public class ExitImpl implements Exit {
    @Override
    public void exit() {
        System.exit(-1);
    }
}
