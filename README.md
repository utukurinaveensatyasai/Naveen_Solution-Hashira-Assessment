# Polynomial Generator (C++)

## Overview
This project reads a JSON input containing `keys` and their values in various number bases, converts them to decimal, and constructs a polynomial using the first `k` roots. The output is the coefficients of the polynomial. The program handles arbitrarily large numbers using Boost.Multiprecision and JSON input parsing via nlohmann/json.

## Features
- Reads input from a JSON file or standard input.  
- Supports numbers in any base (2–16, 3, 6, etc.).  
- Handles very large numbers using Boost’s `cpp_int`.  
- Computes polynomial coefficients for the first `k` roots.  
- Outputs coefficients in order from highest to lowest degree.

## Project Structure
```
project-folder/
├── main.cpp # Main C++ program
├── json.hpp # nlohmann/json header file
├── input.json # Sample input JSON
└── README.md # This file
```

## Dependencies
- C++17 or later  
- Boost.Multiprecision ([https://www.boost.org/doc/libs/release/libs/multiprecision/doc/html/index.html](https://www.boost.org/doc/libs/release/libs/multiprecision/doc/html/index.html))  
- nlohmann/json ([https://github.com/nlohmann/json](https://github.com/nlohmann/json))

## Installation
1. Install Boost: Download from [https://www.boost.org/users/download/](https://www.boost.org/users/download/) and extract to a folder (e.g., `C:\boost_1_83_0`).  
2. Download `json.hpp`: [https://raw.githubusercontent.com/nlohmann/json/develop/single_include/nlohmann/json.hpp](https://raw.githubusercontent.com/nlohmann/json/develop/single_include/nlohmann/json.hpp) and place it in the project folder.  
3. Prepare input file `input.json` with structure:
```json
{
    "keys": {
        "n": 4,
        "k": 3
    },
    "1": { "base": "10", "value": "4" },
    "2": { "base": "2", "value": "111" },
    "3": { "base": "10", "value": "12" },
    "4": { "base": "4", "value": "213" }
}
```
##Compilation
```
g++ main.cpp -o main.exe -std=c++17 -I "C:\path\to\boost"
```
##Sample Output
```
1 -23 160 -336
```


