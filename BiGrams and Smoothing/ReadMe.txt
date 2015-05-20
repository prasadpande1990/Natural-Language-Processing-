								Assignments2-ReadME.txt

********************************************************************************
SOFTWARE USED: Java 1.7.0_75, python 3.4.2
********************************************************************************

********************************************************************************
Execution Steps
********************************************************************************
1. Execute the python code lemmatize.py through PyCharm IDE to find the Lemma count for given Corpus.
2. Import the Java Project in Eclipse IDE.
3. Run the Project through Eclipse.

********************************************************************************
SAMPLE OUTPUT
******************************************************************************************
Python Code for Finding the Lemma Count
******************************************************************************************
C:\Python34\python.exe C:/Users/Sunil/PycharmProjects/N-Grams/lemmatize.py
Ener the Corpus file name with complete path
F:\Masters-Spring2015\Natural Language Processing\Assignments\Assignment2\Assignment2\Corpus.txt
5049

Process finished with exit code 0
******************************************************************************************
Main Code for Bigrams
******************************************************************************************
Enter the Corpus File with complete path For e.g.(F:\Assignments\Sample_1.txt)
F:\Masters-Spring2015\Natural Language Processing\Assignments\Assignment2\Corpus.txt
=====================Prcessing Statement-1 w/o Smoothing==========================
C(The,company): 86.0
C(The): 1583.0
-- P(The,company)/C(The)=0.054327227
C(company,chairman): 0.0
C(company): 148.0
-- P(company,chairman)/C(company)=0.0
C(chairman,said): 23.0
C(chairman): 571.0
-- P(chairman,said)/C(chairman)=0.04028021
C(said,he): 21.0
C(said): 281.0
-- P(said,he)/C(said)=0.07473309
C(he,will): 7.0
C(he): 121.0
-- P(he,will)/C(he)=0.05785124
C(will,increase): 0.0
C(will): 115.0
-- P(will,increase)/C(will)=0.0
C(increase,the): 0.0
C(increase): 7.0
-- P(increase,the)/C(increase)=0.0
C(the,profit): 0.0
C(the): 1583.0
-- P(the,profit)/C(the)=0.0
C(profit,next): 0.0
C(profit): 10.0
-- P(profit,next)/C(profit)=0.0
C(next,year): 6.0
C(next): 21.0
-- P(next,year)/C(next)=0.2857143
Final Probability: 0.0
=====================Prcessing Statement-2 w/o Smoothing==========================
C(The,president): 4.0
C(The): 1583.0
-- P(The,president)/C(The)=0.0025268476
C(president,said): 2.0
C(president): 97.0
-- P(president,said)/C(president)=0.020618556
C(said,he): 21.0
C(said): 281.0
-- P(said,he)/C(said)=0.07473309
C(he,believes): 1.0
C(he): 121.0
-- P(he,believes)/C(he)=0.008264462
C(believes,the): 1.0
C(believes): 1.0
-- P(believes,the)/C(believes)=1.0
C(the,last): 4.0
C(the): 1583.0
-- P(the,last)/C(the)=0.0025268476
C(last,year): 4.0
C(last): 33.0
-- P(last,year)/C(last)=0.121212125
C(year,profit): 0.0
C(year): 59.0
-- P(year,profit)/C(year)=0.0
C(profit,were): 0.0
C(profit): 10.0
-- P(profit,were)/C(profit)=0.0
C(were,good): 0.0
C(were): 48.0
-- P(were,good)/C(were)=0.0
Final Probability: 0.0
=====================Prcessing Statement-1 with Add-One Smoothing==========================
C(The,company)+1: 87.0
C(The+V):6679.0
-- P((The,company)+1/(The+V))= 0.013025902
C(company,chairman)+1: 1.0
C(company+V):5244.0
-- P((company,chairman)+1/(company+V))= 1.9069413E-4
C(chairman,said)+1: 24.0
C(chairman+V):5667.0
-- P((chairman,said)+1/(chairman+V))= 0.004235045
C(said,he)+1: 22.0
C(said+V):5377.0
-- P((said,he)+1/(said+V))= 0.004091501
C(he,will)+1: 8.0
C(he+V):5217.0
-- P((he,will)+1/(he+V))= 0.0015334483
C(will,increase)+1: 1.0
C(will+V):5211.0
-- P((will,increase)+1/(will+V))= 1.9190175E-4
C(increase,the)+1: 1.0
C(increase+V):5103.0
-- P((increase,the)+1/(increase+V))= 1.9596316E-4
C(the,profit)+1: 1.0
C(the+V):6679.0
-- P((the,profit)+1/(the+V))= 1.4972301E-4
C(profit,next)+1: 1.0
C(profit+V):5106.0
-- P((profit,next)+1/(profit+V))= 1.9584803E-4
C(next,year)+1: 7.0
C(next+V):5117.0
-- P((next,year)+1/(next+V))= 0.0013679891
Final Probability: 9.9563176791311E-32
=====================Prcessing Statement-2 with Add-One Smoothing==========================
C(The,president)+1: 5.0
C(The+V):6679.0
-- P((The,president)+1/(The+V))= 7.486151E-4
C(president,said)+1: 3.0
C(president+V):5193.0
-- P((president,said)+1/(president+V))= 5.7770073E-4
C(said,he)+1: 22.0
C(said+V):5377.0
-- P((said,he)+1/(said+V))= 0.004091501
C(he,believes)+1: 2.0
C(he+V):5217.0
-- P((he,believes)+1/(he+V))= 3.833621E-4
C(believes,the)+1: 2.0
C(believes+V):5097.0
-- P((believes,the)+1/(believes+V))= 3.9238768E-4
C(the,last)+1: 5.0
C(the+V):6679.0
-- P((the,last)+1/(the+V))= 7.486151E-4
C(last,year)+1: 5.0
C(last+V):5129.0
-- P((last,year)+1/(last+V))= 9.748489E-4
C(year,profit)+1: 1.0
C(year+V):5155.0
-- P((year,profit)+1/(year+V))= 1.9398642E-4
C(profit,were)+1: 1.0
C(profit+V):5106.0
-- P((profit,were)+1/(profit+V))= 1.9584803E-4
C(were,good)+1: 1.0
C(were+V):5144.0
-- P((were,good)+1/(were+V))= 1.9440125E-4
Final Probability: 1.4346768709214916E-33
=======Prcessing Statement-1 with Good-Turing Smoothing========================
P*(0.0): 0.006993007
P*(6.0): 3.4231503E-4
P*(7.0): 1.9150491E-5
P*(21.0): 2.9462296E-6
P*(23.0): 4.944721E-7
Good Turing Probability:4.944721E-7
=======Prcessing Statement-2 with Good-Turing Smoothing========================
P*(0.0): 0.054054055
P*(1.0): 0.0014609204
P*(2.0): 3.5535902E-4
P*(4.0): 1.6007163E-5
Good Turing Probability:1.6007163E-5
-- -----------------------------------------------------------------------------------------
Do you want to test any other statement?(Y/N)
n
Exit.......!!!!
