/*
 * Construct a character counter that inputs a piece of text that is analyzed
 * character by character
 * to determine the vowels, spaces and letters used. Fill in the code that
 * computes the number of spaces,
 * vowels, and consonants.
 */
class CountCharacters {
    public static void main(String[] args) {

        String text = "To be or not to be, that is the question;"
                + "Whether this nobler in the mind to suffer"
                + " the slings and arrows of outrageous fortune,"
                + " or to take arms against a sea of troubles,"
                + " and by opposing end them?";
        System.out.println(text.length());
        int spaces = 0, vowels = 0, letters = 0, schar = 0, totalChar = text.length();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch == ' ') {
                spaces++;
            } else if (ch == 'a' || ch == 'e'
                    || ch == 'i' || ch == 'o'
                    || ch == 'u') {
                vowels++;
            } else if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                letters++;
            } else {
                schar++;
            }
        }

        System.out.println(
                "The text contained vowels: " + vowels + "\n consonants " + (totalChar - vowels - spaces - schar)
                        + "\nspaces: "
                        + spaces);
    }

}