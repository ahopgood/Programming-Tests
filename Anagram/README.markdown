# Anagram Checker
* You are provided with a list of words.
*  The task is to check if any of the words in the list is an anagram of another.
* An anagram is a work thad can be rearranged to form another word using **all** of the letters, e.g. Listen -> Silent

## Considerations:
* What is the complexity of your solution?
* Can you think of other solutions with less (or more) complexity?


To make an anagram comparable you will need to order bother strings.
Then if they are equal then we have an anagram.
Loop through the list comparing the current string to the next string to see if it is an anagram, if
so then add both to a list that will be returned. O(n*n)
A single loop checking against a map of sorted anagrams would be quicker O(n)+1 for lookup.
Increase complexity
Search for anagrams within other words / sentences.
Compare each word in the map to the current sorted string using substring method.