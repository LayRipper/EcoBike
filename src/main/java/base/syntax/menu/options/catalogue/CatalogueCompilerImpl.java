package base.syntax.menu.options.catalogue;

import base.syntax.storage.DataStorage;

public class CatalogueCompilerImpl implements CatalogueCompiler {
    private static final int BIKE_TITLE = 0;
    private static final int BIKE_DISTINCTIVE_FEATURE = 2;
    private static final int BIKE_LIGHTS = 3;
    private static final int BIKE_PRICE = 6;

    @Override
    public void executeQuery(String input, String toFile) {
        StringBuilder builder = new StringBuilder();
        for (String bike : DataStorage.getStorage()) {
            String[] bikeTitles = bike.split(";");
            if (bikeTitles[BIKE_TITLE].contains("E-BIKE")
                    || bikeTitles[BIKE_TITLE].contains("SPEEDELEC")) {
                builder.append(bikeTitles[BIKE_TITLE])
                        .append(" with")
                        .append(bikeTitles[BIKE_DISTINCTIVE_FEATURE])
                        .append(" mAh battery and ");
            } else {
                builder.append(bikeTitles[BIKE_TITLE])
                        .append(" with")
                        .append(bikeTitles[BIKE_DISTINCTIVE_FEATURE])
                        .append(" gear(s) and ");
            }
            if (bikeTitles[BIKE_LIGHTS].contains("false")) {
                builder.append("no head/tail light.\n");
            } else {
                builder.append("head/tail light.\n");
            }
            builder.append("Price:").append(bikeTitles[BIKE_PRICE]).append(" euros.\n");
        }
        System.out.println(builder);
    }
}
