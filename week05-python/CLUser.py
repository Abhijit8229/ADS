# Person.py
class Person:
    def __init__(self, name, number=None):
        if(number is None):
            self.name = name
        else:
            self.name = name
            self.number  = number
        pass

    def get_name(self):
        return self.name
        pass

    def get_number(self):
        return self.number
        pass

    def set_number(self, new_number):
        self.number = new_number
        pass

    def __str__(self):
        return f"{self.name} {self.number}"

    def __eq__(self, other):
        if isinstance(other, Person):
            return self.name == other.name and self.number == other.number
        return False


# ContactList.py
class ContactList:
    def __init__(self, file_name):
        """
        Initialize an empty contact list and load contacts from the specified file.
        """
        self.contacts:list[Person] = []  # list to hold Person objects
        self.file_name = file_name
        self.load_data(file_name)

    def get_contacts(self):
        return self.contacts

    def add(self, name, number):
        self.contacts.append(Person(name,number))

    def find_person(self, name):
        for i in range(len(self.contacts)):
            if(self.contacts[i].get_name() == name):
                return i
        return -1
        pass

    def remove_person(self, name):
        person = self.find_person(name)
        if(person!=-1):
            self.contacts.pop(person)
            return self.contacts[person].get_number()
        return None


    def add_or_change_contact(self, name, number):
        person = self.find_person(name)
        oldnumber = self.contacts[person].get_number()
        if(person!= -1):
            self.contacts[person].set_number(number)
            return oldnumber
        self.add(name,number)
        return None

    def load_data(self, file_name):
        """
        Load contact data from the specified file.
        Each line should contain a name and a number separated by whitespace.
        """
        try:
            with open(file_name, "r") as f:
                for line in f:
                    line = line.strip()
                    if line:
                        parts = line.split()
                        if len(parts) >= 2:
                            name = parts[0]
                            number = parts[1]
                            self.add(name, number)
                        # Incomplete pairs are ignored.
        except FileNotFoundError:
            print(f"File not found: {file_name}")
            # Start with an empty contact list if the file does not exist.

    def save(self):
        """
        Save the contact list to the file.
        Each contact is written on a new line in the format: name number
        """
        try:
            with open(self.file_name, "w") as f:
                for person in self.contacts:
                    f.write(f"{person.get_name()} {person.get_number()}\n")
        except Exception as e:
            print("Save of directory failed")
            print(e)
            exit(1)


# CLUser.py (Command-Line User Interface)
class CLUser:
    def __init__(self):
        self.user_contacts = None

    def process_commands(self, contact_list):
        """
        Processes user commands until the user chooses to exit.
        """
        self.user_contacts = contact_list
        commands = [
            "Add/Change Contact",
            "Look Up Person",
            "Remove Person",
            "Save Directory",
            "Exit"
        ]
        choice = None
        while choice != 5:
            for i, cmd in enumerate(commands, start=1):
                print(f"Select {i}: {cmd}")
            try:
                choice_input = input("Enter choice: ")
                choice = int(choice_input)
            except ValueError:
                print("INVALID CHOICE - TRY AGAIN")
                continue

            if choice == 1:
                self.do_add_change_contact()
            elif choice == 2:
                self.do_lookup_person()
            elif choice == 3:
                self.do_remove_person()
            elif choice == 4:
                self.do_save()
            elif choice == 5:
                self.do_save()
                print("Bye")
            else:
                print("INVALID CHOICE - TRY AGAIN")

    def do_add_change_contact(self):
        new_name = input("Enter name: ")
        print()
        if new_name == "":
            return
        new_number = input("Enter number: ")
        if new_number == "":
            return
        old_number = self.user_contacts.add_or_change_contact(new_name, new_number)
        if old_number is None:
            message = f"{new_name} was added to the directory\nNew number: {new_number}"
        else:
            message = (f"Number for {new_name} was changed\n"
                       f"Old number: {old_number}\nNew number: {new_number}")
        print(message)

    def do_lookup_person(self):
        name = input("Enter name: ")
        print()
        if name == "":
            return
        index = self.user_contacts.find_person(name)
        if index != -1:
            number = self.user_contacts.contacts[index].get_number()
            print(f"The number for {name} is {number}")
        else:
            print(f"{name} is not listed in the directory")

    def do_remove_person(self):
        name = input("Enter name: ")
        print()
        if name == "":
            return
        removed_number = self.user_contacts.remove_person(name)
        if removed_number is not None:
            print(f"{name} with number {removed_number} is removed")
        else:
            print(f"{name} is not listed in the directory")

    def do_save(self):
        self.user_contacts.save()


# Main program entry point
def main():
    file_name = "phonedata.txt"
    cl = ContactList(file_name)
    user = CLUser()
    user.process_commands(cl)


if __name__ == "__main__":
    main()
