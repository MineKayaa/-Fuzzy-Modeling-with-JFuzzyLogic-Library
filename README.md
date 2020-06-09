# -Fuzzy-Modeling-with-JFuzzyLogic-Library

The dataset contains 5 features related to Bloggers.(kohkiloyeh.xlsx) These are degrees, caprice, subject, lmt (local media turnover) and 
lpss (local, political and social sphere). According to these 5 features, bloggers are categorized into professional or not, which is kept 
in the column called pb. I first examined the dataset before making the FCL file. Using this analysis, I determined the limit values of the model. I sort them. There are 3 
variables, low, medium and high, for the option grade,if its low these bloggers are 35% professional, 72% in medium, 76% in high.

FUZZIFY degree 

TERM low := (0,0)(1,1)(2,0);   

TERM medium := (1,0)(2,1)(3,0); 

TERM high := (2,0)(3,1); 

END_FUZZIFY

Then, I tried to get output in defuzzify part whether it is professional  or not. I determined the limit variables according to the higher percentage. There were 32% nonprof, 68% prof bloggers, so 1 nonprof 2 became prof. In the next step, I updated the data set according to the variables in the tables. For example, I have edited a new excel file as low is 1, medium is 2, high is 3.(DATASET.XLS) 
I wrote the rules by making an algorihm. Those with more than 80% professionalism become a directly profesional, if its giving 70% and 60% percent of professionalism i made a cartesian product among them. I override toString to print the calculated data in Blogger.java and wrote a function that will return the proBlogger data I will use to calculate the MAPE error rate. I included the jxl.jar library and the jFuzzyLogic.jar library in the data we modeled in order to be able to read excel in the mainin. Then I took the data by browsing through the columns and lines and sent it to the blogger object and modeled it fuzzy. I named this object b and again I called the val () function, which I will use to calculate the error rate. I calculated the MAPE error rate in the Error () function in the main class and showed it on the screen.

RESULTS 

![FUZZY](https://user-images.githubusercontent.com/47714688/84186314-08a57200-aa99-11ea-8e08-79c115f16640.png)

I learned how far we can approach the real data with the rules we have determined by blurring the data we have and rinsing it. I got 35% as the error rate because it had an inconsistency in its data. For example, 92 and 94. Although all the data of bloggers on the lines are the same, one is not a professional person. Because of these, although I increased my rules, I got my error rate the lowest.
