from graphics import *
import random

def drawScreen(win,text):
     rect = [None for x in range(20)]
     rectCal = Rectangle(Point(20, 20), Point(490, 140))

     rectCal.draw(win)
     calLine = Line(Point(20,80),Point(490,80))
     calLine.draw(win)
     startx = 20
     starty = 150
     endx = 130
     endy = 220
     locations = []
     for i in range(len(text)):
          rect[i]= Rectangle(Point(startx,starty), Point(endx, endy))
          rect[i].draw(win)
          string = Text(Point((startx+endx)/2,(starty+endy)/2),text[i])
          string.setSize(20)
          string.draw(win)
          location = []
          location.append(startx)
          location.append(endx)
          location.append(starty)
          location.append(endy)
          copy = list(location)
          locations.append(copy)
          startx = startx + 120
          endx = endx + 120
          if( i%4==3):
               startx = 20
               endx = 130
               starty = endy +10
               endy = starty +70
     return locations

def calculate(question):
     qlist = list(question)
     prelist = []
     pre = 0
     post =0
     now = 0
     temp = 0
     ans = 0
     calfirst=0
     operator =""
     spoperator=""
     preoperator=""
     bracket = False
     bracketclose = True
     for i in qlist:
          if checkInt(i):
               prelist.append(i)
          else:
               if(i=="("):
                    bracket = True
                    if(operator!=""):
                         preoperator = operator
               else:
                    if(bracket and operator=="" and i !=")"):
                         calfirst = int(''.join(prelist))
                         prelist =[]
                         operator = i
                    elif(operator==""):
                         pre = int(''.join(prelist))
                         prelist =[]
                         operator = i
                    else:
                         if(bracket):
                              if(i == ")"):
                                   bracket= False
                                   now = int(''.join(prelist))
                                   prelist =[]
                                   if(spoperator!=""):
                                        if(temp!=0):
                                             if(spoperator=="*"):
                                                  temp = multiply(temp,now)
                                             elif(spoperator=="/"):
                                                  temp = divide(temp,now)
                                             if(i!="*" and i!="/"):
                                                  pre = cal(operator,pre,temp)
                                                  temp =0
                                                  spoperator=""
                                        else:
                                             if(spoperator=="*"):
                                                  temp = multiply(post,now)
                                             elif(spoperator=="/"):
                                                  temp = divide(post,now)
                                        calfirst = cal(operator,calfirst,temp)
                                   else:
                                        if(operator=="+"):
                                             calfirst = add(calfirst,now)
                                        elif(operator=="-"):
                                             calfirst = subtract(calfirst,now)
                                        elif(operator=="*"):
                                             calfirst = multiply(calfirst,now)
                                        elif(operator =="/"):
                                             calfirst = divide(calfirst,now)
                                   if(preoperator!=""):
                                             prelist = list(str(calfirst))
                                             preoperator=""
                                   else:
                                        prelist = list(str(calfirst))
                                        operator=""
                              else:
                                   now = int(''.join(prelist))
                                   prelist =[]
                                   if(spoperator!=""):
                                        if(temp!=0):
                                             if(spoperator=="*"):
                                                  temp = multiply(temp,now)
                                             elif(spoperator=="/"):
                                                  temp = divide(temp,now)
                                             if(i!="*" and i!="/"):
                                                  calfirst = cal(operator,calfirst,temp)
                                                  temp =0
                                                  spoperator=""
                                             else:
                                                  spoperator = i
                                        else:
                                             if(spoperator=="*"):
                                                  temp = multiply(post,now)
                                             elif(spoperator=="/"):
                                                  temp = divide(post,now)
                                             if(i!="*" and i!="/"):
                                                  calfirst = cal(operator,calfirst,temp)
                                                  temp=0
                                                  spoperator=""
                                             else:
                                                  spoperator = i
                                   else:     
                                        if(operator=="+"):
                                             if(i=="*"):
                                                  spoperator = "*"
                                                  post = now
                                             elif(i=="/"):
                                                  spoperator = "/"
                                                  post = now
                                             else:
                                                  calfirst = add(calfirst,now)
                                                  operator = i
                                        elif(operator=="-"):
                                             if(i=="*"):
                                                  spoperator = "*"
                                                  post = now
                                             elif(i=="/"):
                                                  spoperator = "/"
                                                  post = now
                                             else:
                                                  calfirst = subtract(calfirst,now)
                                                  operator = i
                                        elif(operator=="*"):
                                             calfirst = multiply(calfirst,now)
                                             operator = i
                                        elif(operator =="/"):
                                             calfirst = divide(calfirst,now)
                                             operator = i
                         else:
                              now = int(''.join(prelist))
                              prelist =[]
                              if(spoperator!=""):
                                   if(temp!=0):
                                        if(spoperator=="*"):
                                             temp = multiply(temp,now)
                                        elif(spoperator=="/"):
                                             temp = divide(temp,now)
                                        if(i!="*" and i!="/"):
                                             pre = cal(operator,pre,temp)
                                             temp =0
                                             spoperator=""
                                        else:
                                             spoperator = i
                                   else:
                                        if(spoperator=="*"):
                                             temp = multiply(post,now)
                                        elif(spoperator=="/"):
                                             temp = divide(post,now)
                                        if(i!="*" and i!="/"):
                                             pre = cal(operator,pre,temp)
                                             temp=0
                                             spoperator=""
                                        else:
                                             spoperator = i
                              else:
                                   if(operator=="+"):
                                        if(i=="*"):
                                             spoperator = "*"
                                             post = now
                                        elif(i=="/"):
                                             spoperator = "/"
                                             post = now
                                        else:
                                             pre = add(pre,now)
                                             operator = i
                                   elif(operator=="-"):
                                        if(i=="*"):
                                             spoperator = "*"
                                             post = now
                                        elif(i=="/"):
                                             spoperator = "/"
                                             post = now
                                        else:
                                             pre = subtract(pre,now)
                                             operator = i
                                   elif(operator=="*"):
                                        pre = multiply(pre,now)
                                        operator = i
                                   elif(operator =="/"):
                                        pre = divide(pre,now)
                                        operator = i

                    
     if(prelist!=[] and operator!=""):
          now = int(''.join(prelist))
          prelist =[]
          if(spoperator!=""):
               if(temp!=0):
                    if(spoperator=="*"):
                         temp = multiply(temp,now)
                    elif(spoperator=="/"):
                         temp = divide(temp,now)
                    if(i!="*" and i!="/"):
                         pre = cal(operator,pre,temp)
                         temp =0
                         spoperator=""
               else:
                    if(spoperator=="*"):
                         temp = multiply(post,now)
                    elif(spoperator=="/"):
                         temp = divide(post,now)
               ans = cal(operator,pre,temp)     
          else:
               if(operator=="+"):
                    ans = add(pre,now)
               elif(operator=="-"):
                    ans = subtract(pre,now)
               elif(operator=="*"):
                    ans = multiply(pre,now)
               elif(operator =="/"):
                    ans = divide(pre,now)
     else:
          ans = int(''.join(prelist))
               
     print(ans)
     return ans

def checkInt(a):
     try:
         float(a)
         return True
     except ValueError:
         return False
def cal(operator,a,b):
     if(operator=="+"):
          return add(a,b)
     elif(operator=="-"):
          return subtract(a,b)
     elif(operator=="*"):
          return multiply(a,b)
     elif(operator =="/"):
          return divide(a,b)
     
def add(a,b):
   return a + b

def subtract(a,b):
   return a - b

def multiply(a,b):
   return a * b

def divide(a,b):
   return a / b



def main():
     winWidth = 500
     winHeight = 560
     win = GraphWin("Simple Calculator", winWidth, winHeight)
     text = ["AC","(",")","/","1","2","3","*","4","5","6","-","7","8","9","+","Ans","0","Back","="]
     locations = drawScreen(win,text)
     question = ""
     calQuestion =""
     message = Text(Point(30,60), question)
     message.setSize(18)
     message.draw(win)
     ans = 0
     move=0
     ansmsg =  Text(Point(465,120), ans)
     ansmsg.setSize(18)
     ansmsg.draw(win)
     while True:
          p1 = win.getMouse()
          count = 0
          for location in locations:
               if(p1.getX()>location[0] and p1.getX()<location[1]):
                    if(p1.getY()>location[2] and p1.getY()<location[3]):
                         if(count==19):
                              ans = calculate(calQuestion)
                              ansmsg.undraw()
                              ansmsg =  Text(Point(470-(len(str(ans))*6.48),120), ans)
                              ansmsg.setSize(18)
                              ansmsg.draw(win)
                         elif(count==18):
                              tempQ = list(question)
                              newQ = ""
                              for i in tempQ[:-1]:
                                   newQ = newQ + i
                              question = newQ
                              message.setText(newQ)
                              tempC = list(calQuestion)
                              newC = ""
                              for j in tempC[:-1]:
                                   newC = newC + j
                              calQuestion = newC
                              message.move(-1*move,0)
                         else:
                              question = question + text[count]
                              message.setText(question)
                              if(count==16):
                                   calQuestion = calQuestion + str(ans)
                                   message.move(20.48,0)
                                   move = 20.48
                              else:
                                   calQuestion = calQuestion + text[count]
                                   if(count==0):
                                        message.undraw()
                                        question = ""
                                        calQuestion = ""
                                        message = Text(Point(30,60), question)
                                        message.setSize(18)
                                        message.draw(win)
                                        ans = 0
                                        ansmsg.undraw()
                                        ansmsg =  Text(Point(465,120), ans)
                                        ansmsg.setSize(18)
                                        ansmsg.draw(win)
                                   elif(count<3 or count ==11):
                                        message.move(4,0)
                                        move = 4
                                   elif(count ==3 or count ==18):
                                        message.move(3.48,0)
                                        move = 3.48
                                   elif(count==7):
                                        message.move(4.48,0)
                                        move = 4.48
                                   elif(count==15):
                                        message.move(7,0)
                                        move = 7
                                   else:
                                        message.move(6.48,0)
                                        move = 6.48
               count = count+1


main()

                       
