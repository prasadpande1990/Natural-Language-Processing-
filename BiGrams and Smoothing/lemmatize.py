__author__ = 'PRASAD PANDE'
import nltk
import re

wnl = nltk.WordNetLemmatizer()

corpusFile = input("Ener the Corpus file name with complete path\n")
LemmaList = []
fopen = open(corpusFile, 'r',encoding='UTF-8')
for line in fopen:
    line = re.sub(r"[^A-Za-z ]+", '', line)
    LemmaList = LemmaList+[wnl.lemmatize(word) for word in line.split()]
print(len(set(LemmaList)))

