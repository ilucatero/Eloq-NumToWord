package com.eloq.numbertoword.en;

public class NumberToWordsConverter {

    // Single-digit and small number names (below twenty)
    private static String[] SMALL_NUMBERS = new String[] { "", "one", "two", "three", "four", "five", "six", "seven",
            "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
            "eighteen", "nineteen"};

    // Tens number names from twenty upwards
    private static String[] TENS = new String[] { "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy",
            "eighty", "ninety"};

    // Scale number names for use during recombination
    private static String[] SCALE_NUMBERS = new String[] {"hundred", "thousand", "million", "billion"};

    private static Integer ONE_BILLION = 1_000_000_000;
    private static Integer ONE_MILLION = 1_000_000;
    private static Integer ONE_THOUSAND = 1_000;
    private static Integer ONE_HUNDRED = 100;


    /**
     * Convert a number to words.
     * <p>For example:  A "245" will be converted to "two hundred forty-five"</p>
     * @param number to convert
     * @return
     */
    public static String convert(Integer number) throws IllegalArgumentException {
        if (number == null || number < 0){
            throw new IllegalArgumentException("The giving (" + number +") value is not valid. It should be a positive not null value.");
        }

        String words = "zero";
        if (number > 0){
            words = getNumberAsWord(number);
        }
        return words.trim();
    }

    private static String getNumberAsWord(int number){
        StringBuilder words = new StringBuilder();

        if (number >= ONE_BILLION ) { // Max of Integer.MAX_VALUE
            words.append(getNumberAsWord(number / ONE_BILLION )).append(" " + SCALE_NUMBERS[3]);
            number = number % ONE_BILLION ;
        }
        if (number >= ONE_MILLION) {
            words.append(getNumberAsWord(number / ONE_MILLION)).append(" " + SCALE_NUMBERS[2]);
            number = number % ONE_MILLION;
        }
        if (number >= ONE_THOUSAND) {
            words.append(getNumberAsWord(number / ONE_THOUSAND)).append(" " + SCALE_NUMBERS[1]);
            number = number % ONE_THOUSAND;
        }
        if (number >= ONE_HUNDRED) {
            words.append(getNumberAsWord(number / ONE_HUNDRED)).append(" " + SCALE_NUMBERS[0]);
            number = number % ONE_HUNDRED;
        }
        if (number >= 20) {
            words.append(" " + TENS[number / 10]);
            int lastValue = number % 10;
            if(lastValue > 0) {
                words.append(getNumberAsWord(lastValue).replace(" ","-"));
            }
        }
        if (number < 20){
            words.append(" " + SMALL_NUMBERS[number]);
        }

        return words.toString();
    }

}
