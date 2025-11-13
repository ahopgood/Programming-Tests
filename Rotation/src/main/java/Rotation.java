public class Rotation {

    public static boolean isRotated(String original, String potentiallyRotated) {

        if (original == null || potentiallyRotated == null) {
            return false;
        }

        for (int i = 0; i < potentiallyRotated.length(); i++) {
            char firstChar = potentiallyRotated.charAt(0);
            potentiallyRotated = potentiallyRotated.substring(1) + firstChar;
            if (potentiallyRotated.equals(original)) {
                return true;
            }
        }


        return false;
    }

}
