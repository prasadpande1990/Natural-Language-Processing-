__author__ = 'PRASAD PANDE'
from nltk.book import *

V = set(text1)
V_count = []
for i in V:
    V_count.append(len(i))
print(V)
#For Printing the length of all words in the text1
print(V_count)
#Length of Longest Word in Text1
print(max(V_count))
#For Finding the Longest Word from the book
long_words = [w for w in V if len(w) == max(V_count)]
print(sorted(long_words))