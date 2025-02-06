def add_student(student_dict, name, rollno, marks):
    grade = 'A' if marks >= 90 else 'B' if marks >= 80 else 'C' if marks >= 70 else 'D'
    student_dict[rollno] = [name, str(marks), grade]

def display_students(student_dict):
    for count, (rollno, details) in enumerate(student_dict.items(), 1):
        end_char = "\n" if count < len(student_dict) else ""
        print(f"Name: {details[0]}, Roll Number: {rollno}, Marks: {details[1]}, Grade: {details[2]}", end=end_char)

def calculate_average_marks(student_dict):
    total_students = len(student_dict)
    total_marks = sum(int(details[1]) for details in student_dict.values())
    average_marks = total_marks / total_students
    print(f"\nAverage Marks: {average_marks:.2f}")

def input_data():
    student_dict = {}
    while True:
        try:
            line = input().strip().split()
            if not line:
                break
            if line[0] == "Add":
                add_student(student_dict, line[2][:-1], line[3][:-1], int(line[4]))
            elif line[0] == "DisplayStudents":
                display_students(student_dict)
            elif line[0] == "CalculateAverageMarks":
                calculate_average_marks(student_dict)
        except:
            break

if __name__ == "__main__":
    input_data()