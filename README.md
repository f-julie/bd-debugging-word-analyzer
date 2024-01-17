# bd-debugging-word-analyzer

## Introduction to the Example Code

### Read (5 minutes)
Read the Javadoc for the `WordAnalyzer` class and its methods, but not the actual source.
You can open the Javadoc from IntelliJ by opening the `javadoc` folder,
right-clicking on `index.html`, and choosing "Open in Browser" from the context menu.

Assuming the code works as described in the Javadoc, if we initialized a
`WordAnalyzer` with the string `"toothless"`, `firstRepeatedCharacter()`
would return 'o'. 

## Debugging with Output

### Read (5 minutes)
Read this
[print debugging example](https://www.inf.unibz.it/~calvanese/teaching/05-06-ip/lecture-notes/uni10/node9.html).

### Fix `firstRepeatedCharacter` (10 minutes)
Run the `main` method in `WordAnalyzerTest` from IntelliJ.
The class is in the `tst` directory (parallel to `src`,
in the root of the snippets package repository). Find the
`main` method and click the little green play button in the margin. Select 'Run WordAnalyzerTest.main()'.
From the results, you can see that the `WordAnalyzer` doesn't work as expected, and the tests fail.

Add some print statements to `WordAnalyzer` to figure out why
`firstRepeatedCharacter()` is not behaving as expected. Don't make any changes
to `WordAnalyzerTest`. When you understand the problem, fix it.
*Do not fix any other methods.*

Once `firstRepeatedCharacter()` is fixed, the print statements are no longer
helpful. In fact, they're cluttering the code and the output, causing readability
problems. Remove them.

There's more to fix here; we'll explore another debugging method before we push
any code.

## Debugging with Direct Observation

### Watch (14 minutes)
Watch [Debugging in IntelliJ](https://www.youtube.com/embed/1bCgzjatcr4/?start=20&end=844)
from 00:20 to 14:04. Since your icons may look a little different, pay
attention to the command names, like "step over", so you can find the
appropriate icons in your version of IntelliJ.

**Vocabulary alert!** The presenter uses some terms you may not know yet.
These aren't in the learning objectives, so you don't need to memorize
them:
* `logical bug`: An error in code that causes incorrect results for valid
expected inputs. Code with logical bugs compiles properly, but works
improperly.
* `flow of execution`: The order that code statements are executed. This
is also called "flow control". In code, statements like `if` can change
the flow of execution. The debugger allows you to observe and control
the flow by specifying where to interrupt and when to continue.

The presenter runs his program multiple times, and has to enter the same
values each time to duplicate the error. This could be easier if they had
written a test, and we'll learn an easy way to run tests in the Unit Testing
lesson. If your debugging process does not include a way to make
reproducing the bug easier, consider adding one.

Next, let's use the "step over", "step into", and "step out" to find another
bug.

### Fix `firstMultipleCharacter` (10 minutes)
Run the WordAnalyzerTest again. Earlier, you fixed
`firstRepeatedCharacter()`, but now the test shows that
`firstMultipleCharacter()` is broken. (You didn't cause this error; the
test is just progressing farther now.)

Let's debug this problem without using any print statements at all.
When you feel a print statement would be useful, use the debugger's
variable panel. You could even set a watch.

Set a breakpoint that will help you observe the behavior of
`firstMultipleCharacter()` and start the debugger. Use `step over`,
`step into`, and `step out` to observe the behavior of
`firstMultipleCharacter()` and `find()`. Use the variable display in the
debugger panel to observe the state of the program.

Fix the program until the `firstMultipleCharacter()` tests pass.

### Fix All the Bugs (15 minutes)

Run the `WordAnalyzerTest` again. The `countRepeatedCharacters()` tests
have some failures.

You've already explored debugging with print statements and debugging with the
interactive debugger. Apply your debugging process with either method to find
and fix the problems in the program until the `WordAnalyzerTest` succeeds.
