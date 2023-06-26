# input_processing.py
# Romil Dhagat, ENSF 592 P23
# A terminal-based program for processing computer vision changes detected by a car.
# Detailed specifications are provided via the Assignment 2 git repository.
# You must include the code provided below but you may delete the instructional comments.
# You may add your own additional classes, functions, variables, etc. as long as they do not contradict the requirements (i.e. no global variables, etc.). 
# You may import any modules from the standard Python library.
# Remember to include your name and comments.



# No global variables are permitted


# You do not need to provide additional commenting above this class, just the user-defined functions within the class
class Sensor:

    # Must include a constructor that uses default values
    # You do not need to provide commenting above the constructor

    #Using the init function to initiate the class and set default values to the sensor
    def __init__(self, light = 'green', pedestrian = 'no', vehicle = 'no'):
        self.light = light
        self.pedestrian = pedestrian
        self.vehicle = vehicle

    # This update_status function takes in user inputs and a sensor object to update the instance variables of the class based on the users inputs
    def update_status(self,input_1,input_2): # You may decide how to implement the arguments for this function
        try:    
            if input_1 == '1' and (input_2 in ['green', 'red', 'yellow']) :                     
                    self.light = input_2
                    return                          #ERROR: you need to check if light gets 'yes' or 'no'
            elif input_1 == '2' and (input_2 == 'yes' or input_2 == 'no'):
                    self.pedestrian = input_2       # If the sensor detects a pedestrian change then the pedestrian instance variable changes based on what the sensor sees
                    return
            elif input_1 == '3' and (input_2 == 'yes' or input_2 == 'no'):
                    self.vehicle = input_2          # If the sensor detects a vehicle change then the vehicle instance variable changes bases on what the sensor detects 
                    return
            else :
                 raise ValueError
        except ValueError:
             print('Invalid vision change')

# The sensor object should be passed to this function to print the action message and current status
# The print_message takes a sensor object and uses it's instance variables to output a status meesage of what the car should do and prints the current state of each variable
def print_message(sensor):
    # The if statement below is used to check waht state the car should be in based on the instances variables of the sensor
    if sensor.light == 'red' or sensor.pedestrian == 'yes' or sensor.vehicle == 'yes':    
        print("\nSTOP\n")
    elif sensor.light == 'yellow':
        print("\nCaution\n")
    elif sensor.light == 'green':
        print("\nProceed\n")
    # Printing out the states of each instance variable 
    print('Light = ' + sensor.light + ' Pedestrian = ' + sensor.pedestrian + ' Vehicle = ' + sensor.vehicle + '\n')

# Complete the main function below
# The main function is used prompt the user with questions and make sure that the user enters the proper inputs and calls methods to update and print the changes 
def main():
    print("\n***ENSF 592 Car Vision Detector Processing Program***\n")
    
    # Creating a default sensor object
    my_sensor = Sensor()

    # Creating lists of the vaild possible inputs 
    in1 = ['1','2','3','0']
    in2 = ['green','yellow','red','yes','no']
    
    # Prompting the user for inputs and making sure they do not select unwanted inputs 
    while True:
        input_1 = input("Are changes detected in the vision input? \nSelect 1 for light, 2 for pedestrian, 3 for vehicle and 0 to end the program : ")
        try:                                                                # Try asking user for input and check that input against the list of possible inputs, raise ValueError if not in list
            if input_1 not in in1:
                raise ValueError
            elif input_1 == '0' :
                exit()
            else :
                input_2 = input('What change has been detected?: ')
                try:
                    if input_2 not in in2:
                        raise ValueError
                    else:
                        my_sensor.update_status(input_1,input_2)            # Calling update_status with the users 2 inputs 
                except ValueError:
                    print('Invalid vision change')
            print_message(my_sensor)                                        # Calling print message and sending the sensor my_sensor with it
        except ValueError:
            print('You must select 1, 2, 3 or 0')


# Conventional Python code for running main within a larger program
# No additional code should be included below this
if __name__ == '__main__':
    main()

