class Question:

    def __init__(self,questionText,choices,correctOption,maxMarks,penalty):
        self.question_text = questionText
        self.choices = choices
        self.correctOption = correctOption
        self.max_marks = maxMarks
        self.penalty = penalty
        self.userChoice = 0
        self.score  = maxMarks
    
    def getQuestionText(self):
        return self.question_text
    
    def getChoices(self):        
        return self.choices
    
    def getCorrectOption(self):
        return self.correctOption
    
    def getMaxMarks(self):
        return self.max_marks
    
    def getPenalty(self):     
        return self.penalty
    
    def getScore(self):
        return self.score
    
    def getUserChoice(self):
        return self.userChoice
    
    def setscore(self,score):     
        self.score = score

    def setUserChoice(self,choice):
        self.userChoice = choice

    def evaluateAnswer(self):
        return (self.getScore() if (self.getCorrectOption() == self.getUserChoice()) else (self.getPenalty()))




class Quiz:
    def __init__(self):
        self.questions:list[Question] = []
        self.total_score = 0

    
    def parseQuestions(self,data):
        data = data.split("\n")
        for i in data:
            questionText, choices, correctOption, maxMarks, penalty = i.split(":")
            choices = choices.split(',')
            question = Question(questionText, choices, int(correctOption), int(maxMarks), int(penalty))
            self.questions.append(question)
        



    def startQuiz(self,test_answers):
        j = 0
        for i in test_answers:
            val = self.questions[j]
            val.setUserChoice(i)
            score = val.evaluateAnswer()
            self.questions[j].setscore(score)
            self.total_score += val.getScore()
            j+=1




    def scoreReport(self):
        print("\nScore Report:")
        for i in self.questions:
            correctString = f"Correct Answer! Marks Awarded: {i.getScore()}"
            wrongString = f"Wrong Answer! Penalty Applied: {i.getScore()}"
            choice = ", ".join(i.getChoices())
            print(f"Question: {i.getQuestionText()}\nChoices: {choice}\nYour Answer: {i.getUserChoice()} | Correct Answer: {i.getCorrectOption()}\n{correctString if i.getScore() > 0 else wrongString}\n")
        print(f"Total Score: {self.total_score}")

