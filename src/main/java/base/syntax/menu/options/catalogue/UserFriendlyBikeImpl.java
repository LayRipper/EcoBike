package base.syntax.menu.options.catalogue;

public class UserFriendlyBikeImpl implements UserFriendlyBike {
    private static final int BIKE_TITLE = 0;
    private static final int BIKE_DISTINCTIVE_FEATURE = 2;
    private static final int BIKE_LIGHTS = 3;
    private static final int BIKE_PRICE = 6;

    @Override
    public String formBike(String rawBike) {
        StringBuilder builder = new StringBuilder();
        String[] bikeTitles = rawBike.split(";");
        if (bikeTitles[BIKE_TITLE].contains("E-BIKE") || bikeTitles[BIKE_TITLE].contains(
                "SPEEDELEC")) {
            builder.append(bikeTitles[BIKE_TITLE]).append(" with").append(
                    bikeTitles[BIKE_DISTINCTIVE_FEATURE]).append(" mAh battery and ");
        } else {
            builder.append(bikeTitles[BIKE_TITLE]).append(" with").append(
                    bikeTitles[BIKE_DISTINCTIVE_FEATURE]).append(" gear(s) and ");
        }
        if (bikeTitles[BIKE_LIGHTS].contains("false")) {
            builder.append("no head/tail light.\n");
        } else {
            builder.append("head/tail light.\n");
        }
        builder.append("Price:").append(bikeTitles[BIKE_PRICE]).append(" euros.\n");
        return builder.toString();
    }
}
