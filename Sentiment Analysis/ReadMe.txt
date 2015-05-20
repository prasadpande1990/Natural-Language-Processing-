								Assignments3-ReadME

********************************************************************************
SOFTWARE USED: python 2.7
IDE USED: PyCharm 4.0.4
********************************************************************************

********************************************************************************
Execution Steps
********************************************************************************
1. Refer Assignment3.pdf for the all pre-requisite software and the packages required before the execution of the code.
2. Execute the python code sentimentAnalysis.py through PyCharm IDE or through command prompt
3. Enter the number of iterations that needs to be performed during model training.
4. Verify the output.
5. Refer Assignment3.pdf for all the observations, result table and conclusion.

********************************************************************************
SAMPLE OUTPUT
******************************************************************************************
Enter the number of iterations for the experiment
3
Maximum Entropy Model taking single word as a feature without any condition
Extracting the features from Negative and Positive Movie reviews.....
Setting Training and Testing Data...
Applying MaxEnt Classifier on Training Data
  ==> Training (3 iterations)

      Iteration    Log Likelihood    Accuracy
      ---------------------------------------
             1          -0.69315        0.500
             2          -0.69252        0.953
         Final          -0.69190        0.953
Evaluating the accuracy
Percentage accuracy of MaxEntropy Model
72.2%
Most Informative Features
  -0.000 magnificent==True and label is 'neg'
  -0.000 insulting==True and label is 'pos'
  -0.000 vulnerable==True and label is 'neg'
  -0.000 uninvolving==True and label is 'pos'
  -0.000 avoids==True and label is 'neg'
  -0.000 outstanding==True and label is 'neg'
  -0.000 astounding==True and label is 'neg'
  -0.000 fascination==True and label is 'neg'
  -0.000 ludicrous==True and label is 'pos'
  -0.000 affecting==True and label is 'neg'
--------------------------------------------------------------------------------------------------------------------------
Maximum Entropy Model without Stopwords
Extracting the features from Negative and Positive Movie reviews.....
Setting Training and Testing Data...
Applying MaxEnt Classifier on Training Data
  ==> Training (3 iterations)

      Iteration    Log Likelihood    Accuracy
      ---------------------------------------
             1          -0.69315        0.500
             2          -0.69253        0.951
         Final          -0.69191        0.951
Evaluating the accuracy
Percentage accuracy of MaxEntropy Model
71.6%
Most Informative Features
  -0.000 magnificent==True and label is 'neg'
  -0.000 insulting==True and label is 'pos'
  -0.000 vulnerable==True and label is 'neg'
  -0.000 uninvolving==True and label is 'pos'
  -0.000 avoids==True and label is 'neg'
  -0.000 outstanding==True and label is 'neg'
  -0.000 astounding==True and label is 'neg'
  -0.000 fascination==True and label is 'neg'
  -0.000 ludicrous==True and label is 'pos'
  -0.000 affecting==True and label is 'neg'
--------------------------------------------------------------------------------------------------------------------------
Maximum Entropy Model without Punctuation
Extracting the features from Negative and Positive Movie reviews.....
Setting Training and Testing Data...
Applying MaxEnt Classifier on Training Data
  ==> Training (3 iterations)

      Iteration    Log Likelihood    Accuracy
      ---------------------------------------
             1          -0.69315        0.500
             2          -0.69253        0.951
         Final          -0.69190        0.952
Evaluating the accuracy
Percentage accuracy of MaxEntropy Model
71.8%
Most Informative Features
  -0.000 magnificent==True and label is 'neg'
  -0.000 insulting==True and label is 'pos'
  -0.000 vulnerable==True and label is 'neg'
  -0.000 uninvolving==True and label is 'pos'
  -0.000 avoids==True and label is 'neg'
  -0.000 outstanding==True and label is 'neg'
  -0.000 astounding==True and label is 'neg'
  -0.000 fascination==True and label is 'neg'
  -0.000 ludicrous==True and label is 'pos'
  -0.000 affecting==True and label is 'neg'
--------------------------------------------------------------------------------------------------------------------------
Maximum Entropy Model with Lemmatization
Extracting the features from Negative and Positive Movie reviews.....
Setting Training and Testing Data...
Applying MaxEnt Classifier on Training Data
  ==> Training (3 iterations)

      Iteration    Log Likelihood    Accuracy
      ---------------------------------------
             1          -0.69315        0.500
             2          -0.69252        0.953
         Final          -0.69190        0.953
Evaluating the accuracy
Percentage accuracy of MaxEntropy Model
72.2%
Most Informative Features
  -0.000 magnificent==True and label is 'neg'
  -0.000 insulting==True and label is 'pos'
  -0.000 vulnerable==True and label is 'neg'
  -0.000 uninvolving==True and label is 'pos'
  -0.000 avoids==True and label is 'neg'
  -0.000 outstanding==True and label is 'neg'
  -0.000 astounding==True and label is 'neg'
  -0.000 fascination==True and label is 'neg'
  -0.000 ludicrous==True and label is 'pos'
  -0.000 affecting==True and label is 'neg'
--------------------------------------------------------------------------------------------------------------------------
Changing the proportion of Negative and Positive Feature sets in the Training data
Taking 1/4th of negative feature and 3/4th of positive feature
Extracting the features from Negative and Positive Movie reviews.....
Setting Training and Testing Data...
Applying MaxEnt Classifier on Training Data
  ==> Training (3 iterations)

      Iteration    Log Likelihood    Accuracy
      ---------------------------------------
             1          -0.69315        0.750
             2          -0.68886        0.750
         Final          -0.68465        0.750
Evaluating the accuracy
Percentage accuracy of MaxEntropy Model
25.0%
Most Informative Features
  -0.000 memorable==True and label is 'neg'
  -0.000 wonderfully==True and label is 'neg'
  -0.000 nomination==True and label is 'neg'
  -0.000 tradition==True and label is 'neg'
  -0.000 understanding==True and label is 'neg'
  -0.000 court==True and label is 'neg'
  -0.000 spielberg==True and label is 'neg'
  -0.000 flawless==True and label is 'neg'
  -0.000 suffering==True and label is 'neg'
  -0.000 triumph==True and label is 'neg'
--------------------------------------------------------------------------------------------------------------------------

Process finished with exit code 0
