package com.eloq.numbertoword;

public class NumberToWordsConverter {

    // Single-digit and small number names (below twenty)
    private String[] SMALL_NUMBERS = new String[] { "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven",
            "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
            "Eighteen", "Nineteen"};

    // Tens number names from twenty upwards
    private String[] TENS = new String[] { "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy",
            "Eighty", "Ninety"};

    // Scale number names for use during recombination
    private String[] SCALE_NUMBERS = new String[] {"", "Thousand", "Million", "Billion"};

    /**
     * Convert a number to words.
     * <p>For example:  A "245" will be converted to "two hundred forty-five"</p>
     * @param value to convert
     * @return
     */
    public static String convert(Integer value){
        String words = "";
        if (value == null || value.equals(0)){
            words = "zero";
        } else{
            int valLength = value.toString().length();
            // TODO
            if (valLength == 10){
                // todo: divide by  1_000_000_000
                //  call convertHundred with the result of division and add the SCALE_NUMBERS respective word
                //  append the result of call to convert(value - 1_000_000_000)
            }
            if (valLength > 8 && valLength < 10){
                // todo: divide by  1_000_000
                //  call convertHundred with the result of division and add the SCALE_NUMBERS respective word
                //  append the result of call to convert(value - 1_000_000)
            }
        }
        return words;
    }
}
