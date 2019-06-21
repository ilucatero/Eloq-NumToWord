package com.eloq.numbertoword;


public class NumberToWordsConverterEN {

    private static final String ZERO = "zero";

    // Small number names (below twenty)
    private static final String[] SMALL_NUMBERS = new String[] { "", "one", "two", "three", "four", "five", "six", "seven",
            "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
            "eighteen", "nineteen"};

    // Tens number names from twenty upwards (with initial space char)
    private static final String[] TENS = new String[] { "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy",
            "eighty", "ninety"};

    // Big number scales with initial space char
    private static final String[] SCALE_NUMBERS = new String[] {"hundred", "thousand", "million", "billion"};


    // comparing numbers used for readability and standardize
    private static final Integer ONE_BILLION = 1_000_000_000;
    private static final Integer ONE_MILLION = 1_000_000;
    private static final Integer ONE_THOUSAND = 1_000;
    private static final Integer ONE_HUNDRED = 100;

    /**
     * Convert a not null positive number to words.
     *  <p>For example:  A "245" will be converted to "two hundred forty-five"</p>
     * @param number to convert
     * @return the given number in letters
     * @throws IllegalArgumentException if given value is negative or null
     */
    public static String convert(Integer number) throws IllegalArgumentException {
        if (number == null || number < 0){
            throw new IllegalArgumentException("The giving (" + number +") value is not valid. It should be a positive not null value.");
        }

        if (number > 0){
            return getNumberAsWord(number).trim();
        }

        return ZERO;
    }

    /**
     * Do convert the given positive number into a word in a recursive way.
     * @param number to convert
     * @return the words describing the numbers, or empty if negative number is provided.
     */
    private static String getNumberAsWord(int number){
        StringBuilder words = new StringBuilder();

        if (number >= ONE_BILLION ) { // until Integer.MAX_VALUE
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

        // get tens : from 20 to 90
        if (number >= 20) {
            words.append(" " + TENS[number / 10]);
            int lastDigit = number % 10;
            if(lastDigit > 0) {
                words.append(getNumberAsWord(lastDigit).replace(" ","-"));
            }
        }
        // get units: from 1 to 19
        if (number > 0 && number < 20){
            words.append(" " + SMALL_NUMBERS[number]);
        }

        return words.toString();
    }

}
