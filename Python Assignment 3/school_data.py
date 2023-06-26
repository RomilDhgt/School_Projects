# school_data.py
# AUTHOR NAME
# Romil Dhagat
# A terminal-based application for computing and printing statistics based on given input.
# Detailed specifications are provided via the Assignment 3 git repository.
# You must include the main listed below. You may add your own additional classes, functions, variables, etc. 
# You may import any modules from the standard Python library.
# Remember to include docstrings and comments.

# Importing numpy and arrays from given_data into variables  
import numpy as np
from given_data import year_2013, year_2014, year_2015, year_2016, year_2017, year_2018, year_2019, year_2020, year_2021, year_2022

# Declare any global variables needed to store the data here

# Creating a numpy array and reshaping it to the proper size
raw_data = year_2013, year_2014, year_2015, year_2016, year_2017, year_2018, year_2019, year_2020, year_2021, year_2022
school_data = np.array(raw_data)
school_data = np.reshape(school_data,(10,20,3))

# Creating dictionary with the school names and codes 
schools = {"Centennial High School": "1224",
               "Robert Thirsk School":"1679",
               "Louise Dean School":"9626",
               "Queen Elizabeth High School":"9806",
               "Forest Lawn High School":"9813",
               "Crescent Heights High School":"9815",
               "Western Canada High School":"9816",
               "Central Memorial High School":"9823",
               "James Fowler High School":"9825",
               "Ernest Manning High School":"9826",
               "William Aberhart High School":"9829",
               "National Sport School":"9830",
               "Henry Wise Wood High School":"9836",
               "Bowness High School":"9847",
               "Lord Beaverbrook High School":"9850",
               "Jack James High School":"9856",
               "Sir Winston Churchill High School":"9857",
               "Dr. E. P. Scarlett High School":"9858",
               "John G Diefenbaker High School":"9860",
               "Lester B. Pearson High School":"9865"}

# Creating list with the school names
names = list(schools.keys())

# You may add your own additional classes, functions, variables, etc.

def main():
    print("ENSF 592 School Enrollment Statistics")

    # Print Stage 1 requirements here
    # Printing shape and dimensions of full data array
    print("Shape of full data array: ", school_data.shape)
    print("Dimensions of full data array: ", len(school_data))
    
    # Prompt for user input
    
    # Creating string variables 
    school_name = " "
    school_code = " "

    # Getting user input and making sure it is a valid one, either school name or school code
    while True:  
        input1 = input("Please enter the school name or school code: ")
        try:
            if input1 in schools or input1 in schools.values():
               break
            else:
                raise ValueError
        except ValueError:
            print("You must enter a valid school name or code.")

    # Making sure if the user inputted a code or a name and storing them correctly 
    if input1 in schools:
         school_name = input1
         school_code = schools[input1]
    elif input1 in schools.values():
        school_code = input1
        school_name = [i for i, value in schools.items() if value == input1]
        school_name = school_name[0]

    # Creating an index for the school name to line the give_data up with the school names
    index = names.index(school_name)

    # Print Stage 2 requirements here
    print("\n***Requested School Statistics***\n")

    # Printing results by parsing thru the data at specific axis 
    print("School name: ", school_name, " School Code: ", school_code )
    print("Mean enrollment for Grade 10: ", int(np.nanmean(school_data[:,index,0])))    
    print("Mean enrollment for Grade 11: ", int(np.nanmean(school_data[:,index,1])))
    print("Mean enrollment for Grade 12: ", int(np.nanmean(school_data[:,index,2])))
    print("Highest enrollment for a single grade: ", int(np.nanmax(school_data[:,index,:])))
    print("Lowest enrollment for a single grade: ", int(np.nanmin(school_data[:,index,:])))
    print("Total enrollment for 2013: ", int(np.nansum(school_data[0,index,:]))) 
    print("Total enrollment for 2014: ", int(np.nansum(school_data[1,index,:])))
    print("Total enrollment for 2015: ", int(np.nansum(school_data[2,index,:])))
    print("Total enrollment for 2016: ", int(np.nansum(school_data[3,index,:])))
    print("Total enrollment for 2017: ", int(np.nansum(school_data[4,index,:])))
    print("Total enrollment for 2018: ", int(np.nansum(school_data[5,index,:])))
    print("Total enrollment for 2019: ", int(np.nansum(school_data[6,index,:])))
    print("Total enrollment for 2020: ", int(np.nansum(school_data[7,index,:])))
    print("Total enrollment for 2021: ", int(np.nansum(school_data[8,index,:]))) 
    print("Total enrollment for 2022: ", int(np.nansum(school_data[9,index,:])))
    print("Total ten year enrollment: ", int(np.nansum(school_data[:,index,:]))) 
    print("Mean total enrollment over 10 years: ", int(np.nanmean(school_data[:,index,0]) + np.nanmean(school_data[:,index,1]) + np.nanmean(school_data[:,index,2])))

    # Making sure that there is an enrollment data for over 500 students 
    enroll = school_data[:,index,:]
    enroll = enroll[enroll>500]
    if (enroll.size == 0):
        print("No enrollments above 500.") 
    else:
        print("For all enrollments over 500, the median value was: ", int(np.nanmean(enroll)))

    # Print Stage 3 requirements here
    print("\n***General Statistics for All Schools***\n")

    # Printing the results of the overall school data 
    print("Mean enrollment in 2013: ", int(np.nanmean(school_data[0,:,:])))
    print("Mean enrollment in 2022: ", int(np.nanmean(school_data[9,:,:])))
    print("Total graduating call of 2022: ", int(np.nansum(school_data[9,:,2])))
    print("Highest enrollment for a single grade: ", int(np.nanmax(school_data[:,:,:])))
    print("Lowest enrollment in 2022: ", int(np.nanmin(school_data[:,:,:])))

if __name__ == '__main__':
    main()

