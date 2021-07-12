# ValidBraces

```
 This project was made by a teamWork of IBM - all rigths reserved
```

https://www.codewars.com/kata/5277c8a221e209d3f6000b56/java

Write a function that takes a string of braces, and determines if the order of the braces is valid. It should return true if the string is valid, and false if it's invalid.

This Kata is similar to the Valid Parentheses Kata, but introduces new characters: brackets [], and curly braces {}. Thanks to @arnedag for the idea!

All input strings will be nonempty, and will only consist of parentheses, brackets and curly braces: ()[]{}.

What is considered Valid?
A string of braces is considered valid if all braces are matched with the correct brace.

Examples 

"(){}[]"   =>  True

"([{}])"   =>  True

"(}"       =>  False

"[(])"     =>  False

"[({})](]" =>  False


Scenario 1
- Validate Empty String - Done
- Validate invalid characters - Done

Scenario 2
- Validate even chars are passed - Done 
- Validate first braces is an open one - Done
- Validate close brace has its open brace
- Validate braces has the correct syntax