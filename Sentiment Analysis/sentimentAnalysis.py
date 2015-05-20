__author__ = 'PRASAD PANDE'

from nltk.corpus import movie_reviews as mv
import nltk
import re
from nltk.classify.maxent import MaxentClassifier as maxent
from nltk.classify import util as classifyClass
from nltk.corpus import stopwords
import string

def maximumEntropyClassifer(getFeatFunction,isBalanced,max_iter):

    # Storing the list of Files according to the classes positive and negative
    negReviewFiles=mv.fileids('neg')
    posReviewFiles=mv.fileids('pos')

    print("Extracting the features from Negative and Positive Movie reviews.....")
    # Extracting the features from each file.
    negFeatures=([(getFeatFunction(mv.words(fileids=File)),'neg') for File in negReviewFiles])
    posFeatures=([(getFeatFunction(mv.words(fileids=File)),'pos') for File in posReviewFiles])
    print("Setting Training and Testing Data...")
    # Setting Training data and Test Data
    if(isBalanced==True):
        # Training Data: Balanced Data
        training_data= negFeatures[:(len(negFeatures)*3/4)]+ posFeatures[:(len(posFeatures)*3/4)]
        test_data= negFeatures[(len(negFeatures)*3/4):]+ posFeatures[(len(posFeatures)*3/4):]
    else:
        # Training Data: Unbalanced Data (Taking more of Positive Features)
        training_data= negFeatures[:(len(negFeatures)*1/4)]+ posFeatures[:len(posFeatures)*3/4]
        test_data= negFeatures[(len(negFeatures)*1/4):]+ posFeatures[int(len(posFeatures)*3/4):]

    print("Applying MaxEnt Classifier on Training Data")
    # Train maxEnt Model using the Training Data
    classifier=maxent.train(train_toks=training_data,algorithm='GIS',max_iter=int(max_iter))
    print("Evaluating the accuracy")
    print("Percentage accuracy of MaxEntropy Model")
    print(str(classifyClass.accuracy(classifier,test_data)*100)+"%")
    print("Most Informative Features")
    # Listing the top 10 most informative features of the Model.
    classifier.show_most_informative_features()

def wordFeatures(words):
    return dict([(w,True) for w in words])

def wordFeatures_without_stopwards(words):
    sw=stopwords.words('english')
    # Extending the stop word list to add some more stop words that don't have any significance
    sw.extend(['re','hv','ll','mr','ms','jr'])
    # Excluding the stop words from the feature list
    words = [(w) for w in words if (w not in sw)]
    return dict([(w,True) for w in words])

def wordFeaures_without_punctuation(words):
    punctuation_chars = set(string.punctuation)
    # Removing all the numeric strings as well as punctuations for our experiment
    words = [(w) for w in words if (w not in punctuation_chars)]
    return dict([(w,True) for w in words])

def wordFeaures_with_lemmatization(words):
    wnl=nltk.WordNetLemmatizer()
    return dict([(wnl.lemmatize(w),True) for w in words])


print("Enter the number of iterations for the experiment")
iterations=raw_input()
print("Maximum Entropy Model taking single word as a feature without any condition")
# isBalanced Parameter if Balanced then the proportion of positive and negative features in Training data is Balanced, unbalanced otherwise
maximumEntropyClassifer(wordFeatures,isBalanced=True,max_iter=iterations)
print("--------------------------------------------------------------------------------------------------------------------------")
print("Maximum Entropy Model without Stopwords")
maximumEntropyClassifer(wordFeatures_without_stopwards,isBalanced=True,max_iter=iterations)
print("--------------------------------------------------------------------------------------------------------------------------")
print("Maximum Entropy Model without Punctuation")
maximumEntropyClassifer(wordFeaures_without_punctuation,isBalanced=True,max_iter=iterations)
print("--------------------------------------------------------------------------------------------------------------------------")
print("Maximum Entropy Model with Lemmatization")
maximumEntropyClassifer(wordFeatures,isBalanced=True,max_iter=iterations)
print("--------------------------------------------------------------------------------------------------------------------------")
print("Changing the proportion of Negative and Positive Feature sets in the Training data")
print("Taking 1/4th of negative feature and 3/4th of positive feature")
maximumEntropyClassifer(wordFeaures_with_lemmatization,isBalanced=False,max_iter=iterations)
print("--------------------------------------------------------------------------------------------------------------------------")
