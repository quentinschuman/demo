class Student(object):
    def __init__(self, name, grade, teacher, score):
        self.name = name
        self.grade = grade
        self.teacher = teacher
        self.score = score

if __name__ == '__main__':
    s = Student("Jack Ma", "本科三年级", "Michel", 88)
    print(s)