package base.syntax.menu.options.catalogue;

import base.syntax.lib.Inject;
import base.syntax.storage.DataStorage;

public class CatalogueCompilerImpl implements CatalogueCompiler {
    @Inject
    private UserFriendlyBike userFriendlyBike;

    @Override
    public String executeQuery(String input, String toFile) {
        StringBuilder builder = new StringBuilder();
        for (String bike : DataStorage.getStorage()) {
            builder.append(userFriendlyBike.formBike(bike));
        }
        return builder.toString();
    }
}
