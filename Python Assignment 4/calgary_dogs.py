# calgary_dogs.py
# AUTHOR NAME
# Romil Dhagat
# A terminal-based application for computing and printing statistics based on given input.
# Detailed specifications are provided via the Assignment 4 git repository.
# You must include the main listed below. You may add your own additional classes, functions, variables, etc. 
# You may import any modules from the standard Python library.
# Remember to include docstrings and comments.

import pandas as pd

###
#    The main function contain all the data importing, the user prompting and the data manipulation 
#
###

def main():

    # Import data here
    # Importing data in from the excel file CalgaryDogBreeds.xlsx, however my system could not recognize hte excel file until I added .xlsx to the name.
    data = pd.read_excel('CalgaryDogBreeds.xlsx')

    print("ENSF 592 Dogs of Calgary")

    # User input stage

    # Using an while true loop to make sure that the user inputs a valid input 
    while True:  
        input1 = input("Please enter a Dog Breed: ").upper()
        # Slicing the data such that breed contains the data for the specific dog breed the user input
        breed = data.loc[data['Breed'].str.upper() == input1]
        try:
            # If there is no dog breed in the data with the name specified then raise error
            if breed.empty:
               raise KeyError
            else:
            # IF there is data in breed then we have a valid dog breed given by user
                break
        except KeyError:
            print("You must enter a valid dog breed.")

    # Data anaylsis stage
    # Creating a multi-index dataframe that is 'IndexSlice'd to create a breed_slice to use to get popular months
    data1 = breed.set_index(['Breed', 'Year', 'Month'])
    idx = pd.IndexSlice
    breed_slice = data1.loc[idx[input1]]

    # Finding  the top years for the particular breed by using the unique version the breed showed up for 
    top_breed_years = breed['Year'].unique()
    print("The ", input1.upper(), " was found in the top breeds for years ", *top_breed_years)

    # Using the data for the specific breed to sum all the totals for it, getting the breed's total amount
    breed_total = breed["Total"].sum()
    print("There have been ", breed_total, input1.upper(), "dogs registered total.")

    # Initializing variables required for the total percentages
    total_all_years = 0
    breed_total_all_years = 0

    # Using a for loop to print the percentages for all three years 
    for year in [2021,2022,2023]:
        # Using masking and built in pandas function sum() to get the total per year 
        total_per_year = data[data["Year"] == year]["Total"].sum()
        # Summing and iterating to totals for all years 
        total_all_years = total_all_years + total_per_year
        # Using masking and built in pandas function sum() to get the total foe the breed per year
        breed_total_per_year = breed[breed["Year"] == year]["Total"].sum()
        # Summing and iterating to get the breed totals for all years 
        breed_total_all_years = breed_total_all_years + breed_total_per_year
        # Getting the percentage by using the totals and breed totals 
        breed_yearly_percent = (breed_total_per_year / total_per_year) * 100
        # Printing the result
        print("The ", input1.upper(), "was ", "{:.6}%".format(breed_yearly_percent), " of the top breeds in ", year)

    # Using the total for all the years and totals for the breed for all years to get the percentage for all years
    breed_all_years_percentage = (breed_total_all_years / total_all_years) * 100
    print("The ", input1.upper(), "was ", "{:.6}%".format(breed_all_years_percentage), " across all years")

    # Using count on data that I grouped by months to get the amount of months the breed popped up in the data
    pop_months = breed_slice.groupby("Month").count()
    # Using a masking function to get the popular months and indexing to list so we can print it as list 
    pop_months = pop_months[pop_months["Total"] > 1].index.tolist()
    print("The most popular month(s)) for ", input1.upper(), " are ", *pop_months)

if __name__ == '__main__':
    main()
