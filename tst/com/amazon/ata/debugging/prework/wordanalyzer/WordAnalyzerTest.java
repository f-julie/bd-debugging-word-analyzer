package com.amazon.ata.debugging.prework.wordanalyzer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

public class WordAnalyzerTest {
    /**
     * The entry point, which results in calls to all test methods.
     *
     * @param args Command line arguments (ignored).
     */
    public static void main(String[] args) {
        WordAnalyzerTest tester = new WordAnalyzerTest();
        tester.runAllTests();
    }

    /**
     * A convenience method that prints whether the first repeated character is the expected one.
     *
     * @param analyzed The string that will be analyzed.
     * @param expected The character expected as the first repeated character.
     * @return True if the expected character was the result, false otherwise.
     */
    private static boolean expectFirstRepeatToBe(String analyzed, char expected) {
        WordAnalyzer analyzer = new WordAnalyzer(analyzed);
        char actual = analyzer.firstRepeatedCharacter();
        if (actual == expected) {
            System.out.println(String.format("PASS: firstRepeatedCharacter for \"%s\" is '%c'.", analyzed, actual));
            return true;
        } else {
            System.out.println(String.format("FAIL: expected firstRepeatedCharacter for \"%s\" to be '%c', got '%c'!",
                                             analyzed, expected, actual));
            return false;
        }
    }

    /**
     * A convenience method that prints whether the first multiple character is the expected one.
     *
     * @param analyzed The string that will be analyzed.
     * @param expected The character expected as the first multiple character.
     * @return True if the expected character was the result, false otherwise.
     */
    private static boolean expectFirstMultipleToBe(String analyzed, char expected) {
        WordAnalyzer analyzer = new WordAnalyzer(analyzed);
        char actual = analyzer.firstMultipleCharacter();
        if (actual == expected) {
            System.out.println(String.format("PASS: firstMultipleCharacter for \"%s\" is '%c'.", analyzed, actual));
            return true;
        } else {
            System.out.println(String.format("FAIL: expected firstMultipleCharacter for \"%s\" to be '%c', got '%c'!",
                                             analyzed, expected, actual));
            return false;
        }
    }

    /**
     * A convenience method that prints whether the number of repeated groups is the expected one.
     *
     * @param analyzed The string that will be analyzed.
     * @param expected The number of repeated groups expected.
     * @return True if the expected number was the result, false otherwise.
     */
    private static boolean expectRepeatCountToBe(String analyzed, int expected) {
        WordAnalyzer analyzer = new WordAnalyzer(analyzed);
        int actual = analyzer.countRepeatedCharacters();
        if (actual == expected) {
            System.out.println(String.format("PASS: countRepeatedCharacters for \"%s\" is %d.", analyzed, actual));
            return true;
        } else {
            System.out.println(String.format("FAIL: expected countRepeatedCharacters for \"%s\" to be %d, got %d!",
                                             analyzed, expected, actual));
            return false;
        }
    }

    /**
     * Calls the test methods, keeping track of whether each WordAnalyzer method passes all of its tests or not.
     * Prints a summary of results. Note that some tests may not run if earlier tests fail.
     * <p>
     * The {@code @Test} annotation here marks this as a unit test, so that JUnit runs the tests when the Brazil package
     * is built. We'll cover this in the Unit Testing lesson.
     */
    @Test
    public void runAllTests() {
        char noneFound = 0;

        System.out.println("\nTesting firstRepeatedCharacter()...");
        boolean pass = expectFirstRepeatToBe("aa", 'a');
        pass = expectFirstRepeatToBe("roommate", 'o') && pass;
        pass = expectFirstRepeatToBe("aardvark", 'a') && pass;
        pass = expectFirstRepeatToBe("mate", noneFound) && pass;
        pass = expectFirstRepeatToBe("test", noneFound) && pass;
        if (!pass) {
            String errorMessage = "\nThe firstRepeatedCharacter() method failed. Test aborted.";
            fail(errorMessage);
        }

        System.out.println("\nTesting firstMultipleCharacter()...");
        pass = expectFirstMultipleToBe("aa", 'a');
        pass = expectFirstMultipleToBe("mississippi", 'i') && pass;
        pass = expectFirstMultipleToBe("mate", noneFound) && pass;
        pass = expectFirstMultipleToBe("test", 't') && pass;
        if (!pass) {
            String errorMessage = "\nThe firstMultipleCharacter() method failed. Test aborted.";
            fail(errorMessage);
        }

        System.out.println("\nTesting countRepeatedCharacters()...");
        pass = expectRepeatCountToBe("mississippiii", 4);
        pass = expectRepeatCountToBe("test", 0) && pass;
        pass = expectRepeatCountToBe("aabbcdaaaadcbb", 4) && pass;
        if (!pass) {
            String errorMessage = "\nThe countRepeatedCharacters() method failed. Test aborted.";
            fail(errorMessage);
        }

    }
}
