Autocomplete
-------------------
Google like autocomplete with TST (ternary search tree) and Spring-boot (java 8).
<br/>
Question
-------------------
<br/>
● What would you change if the list of keywords was large (several millions)?<br/>
<br/>
-> TST is already optimized for saving memory (it stocks the similar words in the same tree).<br/>
For several millions keywords, which means several megabytes' data in memory, TST will be ok.<br/>
For a really huge data set, we should use database, or distributed framwork as spark/mapreduce...<br/>
<br/>
● What would you change if the requirements were to match any portion of the<br/>
keywords (example: for string “pro”, code would possibly return “reprobe”)<br/>
<br/>
-> TST supports fuzzy queries, using wildcard to search. E.g., using % as a wildcard to search (%pro%) <br/>
<br/>
● What to improve?<br/>

-> inserting data in out-of-order, in order to create a balanced tree<br/>
-> loop instead of recursivity<br/>
-> unit tests: case insensitive / fuzzy search / big data set<br/>
-> finish the front<br/>
