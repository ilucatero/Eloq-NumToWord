# Converts Numbers into Words

## Requirements
Checks or certain contracts for example, require to write the amounts in any letter.
This exercise proposes to write a program to automate such a conversion.
This program, written in Java, must convert an integer into words (in English).

Here are some examples :

 - "245" is converted to "two hundred forty-five"
 - "75" is converted to "seventy-five"

## Limitations and remarks
Even if the application transform numbers with certain digits length, it has some limitations.

 - Number max value: It can transform number values within a java Integer.MAX_VALUE (upto 2 147 483 647).
   * Disclaimer : I use this max value because for a normal contract or check, a value grater than that is very unusual (in 
        which case this app should be updated to Integer.MAX_VALUE (up to 9 quintillion).
 - Zeros at the left are not considered (worth to say it).
 - As the requirement demands, no decimals are taken into account, only integers; so for a value of 12.3, it will be converted only the integer part (12).
 - Inverse mechanism is not provided (nor required).
 - Only english language is supported on conversion.
 - only positive values are accepted, otherwise zero will be showed.

### Some useful information
Some of the ideas for this algorithm I got them based on next link :
  - http://mathforum.org/library/drmath/view/57113.html
  - http://www.blackwasp.co.uk/numbertowords.aspx
  - https://www.baeldung.com/java-number-of-digits-in-int


## Usage

To build this project use

```bash
    mvn clean install
```

To run this project from within Maven use

```bash
    mvn exec:java
```


(Quicky) or altogether

```bash
    mvn clean install exec:java
```

To run this project as JAR

```bash
    java -jar dist/number-to-word.jar
```
