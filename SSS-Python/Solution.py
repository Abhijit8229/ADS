import datetime
from functools import cmp_to_key
class person:
    def __init__(self, Student_Name, Date_of_Birth, Subject_1_Marks, Subject_2_Marks, Subject_3_Marks, Total_Marks, Reservation_Category):
        self.Student_Name = Student_Name
        self.Date_of_Birth = datetime.datetime.strptime(Date_of_Birth, "%d-%m-%Y")
        self.Subject_1_Marks = int(Subject_1_Marks)
        self.Subject_2_Marks = int(Subject_2_Marks)
        self.Subject_3_Marks = int(Subject_3_Marks)
        self.Total_Marks = int(Total_Marks)
        self.Reservation_Category = Reservation_Category
    
    def __str__(self):
        return f"{self.Student_Name},{self.Total_Marks},{self.Reservation_Category}"

def compare(p1: person, p2: person):
    if p1.Total_Marks != p2.Total_Marks:
        return p2.Total_Marks - p1.Total_Marks
    elif p1.Subject_3_Marks != p2.Subject_3_Marks:
        return p2.Subject_3_Marks - p1.Subject_3_Marks
    elif p1.Subject_2_Marks != p2.Subject_2_Marks:
        return p2.Subject_2_Marks - p1.Subject_2_Marks
    elif p1.Date_of_Birth != p2.Date_of_Birth:
        return (p2.Date_of_Birth - p1.Date_of_Birth).days
    else:
        return 0

dt = {
    "qualified_students": -1,
    "total_number_of_vacancies": -1,
    "unreserved_category_vacancies": -1,
    "BC_category_vacancies": -1,
    "SC_category_vacancies": -1,
    "ST_category_vacancies": -1,
    "students": [],
    "open_category": [],
    "BC_category": [],
    "SC_category": [],
    "ST_category": []
}

while True:
    try:
        inp = input().strip()
        if dt["qualified_students"] == -1:
            dt["qualified_students"] = int(inp)
        elif dt["total_number_of_vacancies"] == -1:
            dt["total_number_of_vacancies"] = int(inp)
        elif dt["unreserved_category_vacancies"] == -1:
            dt["unreserved_category_vacancies"] = int(inp)
        elif dt["BC_category_vacancies"] == -1:
            dt["BC_category_vacancies"] = int(inp)
        elif dt["SC_category_vacancies"] == -1:
            dt["SC_category_vacancies"] = int(inp)
        elif dt["ST_category_vacancies"] == -1:
            dt["ST_category_vacancies"] = int(inp)
        else:
            inpt = inp.split(",")
            dt["students"].append(person(inpt[0], inpt[1], inpt[2], inpt[3], inpt[4], inpt[5], inpt[6]))
    except EOFError:
        break


dt["students"].sort(key=cmp_to_key(compare))

for i in dt["students"]:
    print(i)
print()
for _ in range(dt["unreserved_category_vacancies"]):
    dt["open_category"].append(dt["students"].pop(0))


remaining_students = dt["students"]

for student in remaining_students[:]: 
    if student.Reservation_Category == "BC":
        dt["BC_category"].append(student)
        remaining_students.remove(student)  
    elif student.Reservation_Category == "SC":
        dt["SC_category"].append(student)
        remaining_students.remove(student)  
    elif student.Reservation_Category == "ST":
        dt["ST_category"].append(student)
        remaining_students.remove(student)  


dt["BC_category"].sort(key=cmp_to_key(compare))
dt["SC_category"].sort(key=cmp_to_key(compare))
dt["ST_category"].sort(key=cmp_to_key(compare))


if 'final' not in dt:
    dt['final'] = []

# print([str(i) for i in dt["students"]])
for i in dt["open_category"]:
    dt['final'].append(i)

# print(len(dt["BC_category"]),len(dt["SC_category"]),len(dt["ST_category"]))
if len(dt["BC_category"]) != 0 :
        for i in range(min(dt["BC_category_vacancies"],len(dt["BC_category"]))):
            dt['final'].append(dt["BC_category"][i])
            dt["BC_category"].remove(dt["BC_category"][i])
            dt["BC_category_vacancies"]-=1
else:
    for i in range(dt["BC_category_vacancies"]):
        dt['final'].append(dt["students"].pop(0))
        dt["BC_category_vacancies"]-=1


if len(dt["ST_category"]) != 0:
        
        for i in range(dt["ST_category_vacancies"]):
            dt['final'].append(dt["ST_category"][i])
            dt["ST_category"].remove(dt["ST_category"][i])
            dt["ST_category_vacancies"]-=1
else:
  
    for i in range(dt["ST_category_vacancies"]):
        dt['final'].append(dt["students"].pop(0))
        dt["ST_category_vacancies"]-=1


if len(dt["SC_category"]) != 0:
        
        for i in range(dt["SC_category_vacancies"]):
            dt['final'].append(dt["SC_category"][i])
            dt["SC_category"].remove(dt["SC_category"][i])
            dt["SC_category_vacancies"]-=1
else:

    for i in range(dt["SC_category_vacancies"]):
        dt['final'].append(dt["students"].pop(0))
        dt["SC_category_vacancies"]-=1



if(len(dt["BC_category"])!=dt["BC_category_vacancies"]):
    for i in range(dt["BC_category_vacancies"]-1):
        dt['final'].append(dt["students"].pop(0))
        dt["BC_category_vacancies"]-=1
    if(dt["BC_category_vacancies"]):
        dt['final'].append(dt['ST_category'][0])
if(len(dt["SC_category"])!=dt["ST_category_vacancies"]):
    for i in range(dt["ST_category_vacancies"]):
        dt['final'].append(dt["students"].pop(0))
        dt["ST_category_vacancies"]-=1
if(len(dt["SC_category"])!=dt["SC_category_vacancies"]):
    for i in range(dt["SC_category_vacancies"]):
        dt['final'].append(dt["students"].pop(0))
        dt["SC_category_vacancies"]-=1

dt["final"].sort(key=cmp_to_key(compare))
for i in dt['final']:
    print(i)