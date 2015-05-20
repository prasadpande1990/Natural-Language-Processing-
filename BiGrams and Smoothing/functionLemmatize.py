import nltk
import re

def Lemmatizer(trainingFile):
    wnl = nltk.WordNetLemmatizer()
    LemmaList = []
    fopen = open(trainingFile, "r")
    for line in fopen:
        line = re.sub(r"[^A-Za-z ]+", '', line)
        LemmaList = LemmaList+[wnl.lemmatize(word) for word in line.split()]

    return len(set(LemmaList))

print(Lemmatizer(r"F:\Masters-Spring2015\Natural Language Processing\Assignments\Assignment2\Corpus.txt"))