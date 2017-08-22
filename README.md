Autocomplete
-------------------
Google like autocomplete with TST (ternary search tree) and Spring-boot (java 8).

Question
-------------------

● What would you change if the list of keywords was large (several millions)?

-> TST is already optimized for saving memory (it stocks the similar words in the same tree).
For several millions keywords, which means several megabytes' data in memory, TST will be ok.
For a really huge data set, we should use database, or distributed framwork as spark/mapreduce...

● What would you change if the requirements were to match any portion of the
keywords (example: for string “pro”, code would possibly return “reprobe”)

-> TST supports fuzzy queries, using wildcard to search. E.g., using % as a wildcard to search (%pro%) 

● What to improve?

-> inserting data in out-of-order, in order to create a balanced tree
-> loop instead of recursivity
-> unit tests: case insensitive / fuzzy search / big data set
-> finish the front
